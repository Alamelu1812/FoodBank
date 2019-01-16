package foodbank.controller;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import foodbank.domain.AvailableInventory;
import foodbank.domain.Category;
import foodbank.domain.ConsumptionRequest;
import foodbank.domain.ConsumptionRequestItem;
import foodbank.domain.ConsumptionHistory;
import foodbank.domain.ConsumptionAllocated;
import foodbank.domain.Donation;
import foodbank.domain.DonationItem;
import foodbank.domain.UserInfo;
import foodbank.domain.UserLogin;
import foodbank.domain.UserType;
import foodbank.exceptions.InvalidCredentialsException;
import foodbank.services.dao.mysql.FoodBankMySqlDAO;

@Controller
@RequestMapping(value = "/")
@MultipartConfig
public class HomeController {

	@Resource
	FoodBankMySqlDAO foodBankDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String handleRegisterUserForm(HttpServletRequest request) {
		UserInfo userInfo = new UserInfo();
		userInfo.setEmail(request.getParameter("email"));
		userInfo.setPassword(request.getParameter("password"));
		userInfo.setUserName(request.getParameter("user_name"));
		userInfo.setAddressLine(request.getParameter("address_line"));
		userInfo.setCity(request.getParameter("city"));
		userInfo.setState(request.getParameter("state"));
		userInfo.setCountry(request.getParameter("country"));
		userInfo.setZipCode(request.getParameter("zip_code"));
		userInfo.setPhoneNumber(request.getParameter("phone_number"));
		userInfo.setUserDescription(request.getParameter("user_description"));
		userInfo.setUserType(UserType.valueOf(request.getParameter("user_type")));
		userInfo.setTransportationMethod(request.getParameter("transportation_method"));
		userInfo.setPopulation(Integer.parseInt(request.getParameter("population")));
		userInfo.setUpdTime(LocalDateTime.now());
		try {
			if (foodBankDao.registerUser(userInfo)) {
				return "signup-success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error-page";
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String handleLoginForm(HttpServletRequest request, HttpServletResponse response, ModelMap map) {

		String userId = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			UserLogin userLogin = foodBankDao.checkAndGetUserLogin(userId, password);
			request.getSession().setAttribute("userId", userLogin.getUserId());
			switch (userLogin.getUserType()) {
			case DONOR:
				request.getSession().setAttribute("userType", "donor");
				return "donor-dashboard";
			case RECIPIENT:
				request.getSession().setAttribute("userType", "recipient");
				return "recipient-dashboard";
			case FOODBANK:
				request.getSession().setAttribute("userType", "foodBank");
				return "foodbank-dashboard";
			}
		} catch (InvalidCredentialsException exception) {
		}
		map.addAttribute("errorMessage", "Invalid username/password!");
		return "error-page";
	}

	@RequestMapping(value = "/user/login/donate", method = RequestMethod.POST)
	@Transactional
	public String handleDonate(HttpServletRequest request) {
		LocalDateTime updTime = LocalDateTime.now();
		Donation donation = new Donation();
		donation.setAppointmentTime(LocalDateTime.parse(request.getParameter("appointmentTime")));
		donation.setComments(request.getParameter("comments"));
		donation.setDonorID((int) request.getSession().getAttribute("userId"));
		donation.setFrequency(request.getParameter("frequency"));
		donation.setPreferredBeneficiary(request.getParameter("preferredBeneficiary"));
		donation.setUpdTime(updTime);
		
		foodBankDao.persistDonation(donation);
		
		int itemCount = Integer.parseInt(request.getParameter("itemCount"));
		for (int itemNumber = 1; itemNumber <= itemCount; itemNumber++) {
			DonationItem donationItem = new DonationItem();
			donationItem.setDonationID(donation.getDonationID());
			donationItem.setCategoryID(Integer.parseInt(request.getParameter("category" + itemNumber)));
			donationItem.setFoodItem(request.getParameter("foodItem" + itemNumber));
			donationItem.setQuantity(Integer.parseInt(request.getParameter("quantity" + itemNumber)));
			donationItem.setExpirationDate(LocalDate.parse(request.getParameter("expiration" + itemNumber)));
			donationItem.setUnits(request.getParameter("unit" + itemNumber));
			donationItem.setUpdTime(updTime);
			foodBankDao.persistDonationItem(donationItem);
		}
		return "donor-dashboard";
	}
	
	@RequestMapping(value = "/user/login/consume", method = RequestMethod.POST)
	@Transactional
	public String handleConsumeRequest(HttpServletRequest request) {
		System.out.println("Consumption Request Recieved from user:");
		System.out.println(request.getSession().getAttribute("userId"));
		
		LocalDateTime updTime = LocalDateTime.now();
		ConsumptionRequest consumptionRequest = new ConsumptionRequest();
		consumptionRequest.setAppointmentTime(LocalDateTime.parse(request.getParameter("appointmentTime")));
		consumptionRequest.setComments(request.getParameter("comments"));
		consumptionRequest.setConsumerID((int) request.getSession().getAttribute("userId"));
		consumptionRequest.setFrequency(request.getParameter("frequency"));
		consumptionRequest.setPreferredBeneficiary(request.getParameter("preferredBeneficiary"));
		consumptionRequest.setUpdTime(updTime);
		
		foodBankDao.persistConsumptionRequest(consumptionRequest);
		
		int itemCount = Integer.parseInt(request.getParameter("itemCount"));
		for (int itemNumber = 1; itemNumber <= itemCount; itemNumber++) {
			ConsumptionRequestItem consumptionRequestItem = new ConsumptionRequestItem();
			consumptionRequestItem.setConsumptionRequestID(consumptionRequest.getConsumptionRequestID());
			consumptionRequestItem.setCategoryID(Integer.parseInt(request.getParameter("category" + itemNumber)));
			consumptionRequestItem.setFoodItem(request.getParameter("foodItem" + itemNumber));
			consumptionRequestItem.setQuantity(Integer.parseInt(request.getParameter("quantity" + itemNumber)));
			consumptionRequestItem.setExpirationDate(LocalDate.parse(request.getParameter("expiration" + itemNumber)));
			consumptionRequestItem.setUnits(request.getParameter("unit" + itemNumber));
			consumptionRequestItem.setUpdTime(updTime);
			foodBankDao.persistConsumptionRequestItem(consumptionRequestItem, (int) request.getSession().getAttribute("userId"));
		}

		return "recipient-dashboard";
	}

	@RequestMapping(value = "/user/login/allocate", method = RequestMethod.POST)
	@Transactional
	public String handleAllocate(HttpServletRequest request) {
		try {
			System.out.println("Picked up!");
			Map<String, String[]> parameters = request.getParameterMap();
			for(String parameter : parameters.keySet()) {
		    	System.out.println("Param " + parameter + " - " + request.getParameter(parameter));
			    if(parameter != null && parameter.toLowerCase().startsWith("quantity")) {
			        String quantity = request.getParameter(parameter);
			        if (quantity != null && !quantity.equals("")) {
			        	try {
			        		int quantityValue = Integer.parseInt(quantity);
			        		if (quantityValue > 0) {
			        			String foodItem = parameter.replace("quantity_", "");
			        			int recipientId = Integer.parseInt(request.getParameter("recipient_" + foodItem));
			        			System.out.println("Logging - " + foodItem + " " + recipientId + " " + quantityValue);
			        			foodBankDao.stalePendingCounsumptionRequestItem(recipientId, foodItem);
			        			List<AvailableInventory> inventories = foodBankDao.getPersistedAvailableInventory(foodItem);
			        			if (inventories != null && inventories.size() > 0) {
			        				AvailableInventory availableInventory = inventories.get(0);
			        				availableInventory.setQuantity(availableInventory.getQuantity() - quantityValue);
			        				foodBankDao.updateAvailableInventoryQuantity(availableInventory);
			        				foodBankDao.persistAvailableInventory(availableInventory);
			        			}
			        		}
			        	} catch (Exception e) {
			        		System.out.println(e);
			        		continue;
			        	}
			        }
			    }
			}

		} catch (Exception exception) {
			return "error-page";
		}
		return "success";
	}	

	@RequestMapping(value = "/user/login/foodBank", method = RequestMethod.POST)
	@Transactional
	public String handleFoodBankRequest(HttpServletRequest request) {
		System.out.println("FoodBank Recieved from user:");
		System.out.println(request.getSession().getAttribute("userId"));
		
		LocalDateTime updTime = LocalDateTime.now();
		
		
		int itemCount = Integer.parseInt(request.getParameter("itemCount"));
		for (int itemNumber = 1; itemNumber <= itemCount; itemNumber++) {
			ConsumptionHistory consumptionHistory = new ConsumptionHistory();
			consumptionHistory.setConsumerID((Integer.parseInt(request.getParameter("consumer_id" + itemNumber))));
			consumptionHistory.setConsumptionRequestID((Integer.parseInt(request.getParameter("consumer_request_id" + itemNumber))));
			consumptionHistory.setRequestedQuantity((Integer.parseInt(request.getParameter("requested_quantity" + itemNumber))));
			consumptionHistory.setFulfilledAmount((Integer.parseInt(request.getParameter("fulfilled_amount" + itemNumber))));
			consumptionHistory.setYtdRequestedQuantity((Integer.parseInt(request.getParameter("ytd_requested_quantity" + itemNumber))));
			consumptionHistory.setYtdFulfilledAmount((Integer.parseInt(request.getParameter("ytd_fulfilled_amount" + itemNumber))));
			consumptionHistory.setUpdTime(updTime);
			foodBankDao.persistConsumptionHistory(consumptionHistory);
		}
		return "foodbank-dashboard";
	}


	@RequestMapping(value = "/user/login/contact", method = RequestMethod.GET)
	public String handleContact(HttpServletRequest request) {
		return "contact";
	}

	@RequestMapping(value = "/user/login/about", method = RequestMethod.GET)
	public String handleAbout(HttpServletRequest request) {
		return "about";
	}

	@RequestMapping(value = "/user/login/profile", method = RequestMethod.GET)
	public String handleProfile(HttpServletRequest request) {
		return "profile";
	}

	@RequestMapping(value = "/user/login/upload", method = RequestMethod.POST)
	public String handleCSVUpload(HttpServletRequest request, ModelMap map) {
	
		int maxFileSize = 5000 * 1024;
		int maxMemSize = 5000 * 1024;

		// Verify the content type
		String contentType = request.getContentType();

		if ((contentType.indexOf("multipart/form-data") >= 0)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// maximum size that will be stored in memory
			factory.setSizeThreshold(maxMemSize);

			// Location to save data that is larger than maxMemSize.
			factory.setRepository(new File("C:\\Users\\burmi\\eclipse-workspace\\temp\\"));

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// maximum file size to be uploaded.
			upload.setSizeMax(maxFileSize);

			String userType = (String) request.getSession().getAttribute("userType");
			try {
				List<FileItem> fileItems = upload.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					if (fileItem.getName() == null) {
						continue;
					}
					System.out.println("Successfully uploaded file " + fileItem.getName());
					String fileContent = fileItem.getString();
					if (fileContent == null || !fileContent.contains("\n")) {
						return "upload-failed";
					}
					fileContent.replaceAll("\r\n", "\n");
					if ("donor".equalsIgnoreCase(userType)) {
						handleDonorCSVUpload(fileContent, request);
					}
					if ("recipient".equals(userType)) {
						handleRecipientCSVUpload(fileContent, request);
					}
					if ("foodBank".equals(userType)) {
						handleFoodBankCSVUpload(fileContent,request);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "upload-failed";
			}
		}
		return "success";
	}
	
//	@RequestMapping(value = "/user/login/allocate", method = RequestMethod.POST)
//	public String allocateByCategory(HttpServletRequest request) {
//		int itemCount = Integer.parseInt(request.getParameter("itemCount"));
//		for (int itemNumber = 1; itemNumber <= itemCount; itemNumber++) {
//			ConsumptionAllocated consumptionAllocated = new ConsumptionAllocated();
//			consumptionAllocated.setConsumptionRequestItemID(0);
//			consumptionAllocated.setFoodItem(request.getParameter("consumer_id" + itemNumber));
//			consumptionAllocated.setConsumptionRequestID(0);
//			consumptionAllocated.setUserName(request.getParameter("recipient" + itemNumber));
//			consumptionAllocated.setQuantity((Integer.parseInt(request.getParameter("quantity" + itemNumber))));
//			consumptionAllocated.setUpdTime(LocalDateTime.now());
//			foodBankDao.persistConsumptionAllocated(consumptionAllocated);
//		}
//		return "foodbank-dashboard";
//	}

	private void handleDonorCSVUpload(String csvContent, HttpServletRequest request) {
			String[] lines = csvContent.split("\n");
			Donation donation = new Donation();
			// Set donation content using 1st Line
			String[] donationFields = lines[1].split(",");
			donation.setPreferredBeneficiary(donationFields[1]);
			donation.setAppointmentTime(LocalDateTime.now());
			donation.setFrequency(donationFields[3]);
			donation.setComments(donationFields[4]);
			donation.setDonorID((int) request.getSession().getAttribute("userId"));
			donation.setUpdTime(LocalDateTime.now());
			foodBankDao.persistDonation(donation);

			for (int lineNumber = 1; lineNumber < lines.length; lineNumber++) {
				String fields[] = lines[lineNumber].split(",");
				if (fields.length < 11) {
					throw new RuntimeException("Invalid number of fields in line " + lineNumber);
				}
				DonationItem donationItem = new DonationItem();
				donationItem.setDonationID(donation.getDonationID());
				donationItem.setCategoryID(Category.getIdForDesc(fields[5]));
				donationItem.setFoodItem(fields[6]);
				donationItem.setQuantity(Integer.parseInt(fields[7]));
				donationItem.setUnits(fields[8]);
				//donationItem.setNutrition(fields[9]);
				donationItem.setExpirationDate(LocalDate.now());
				donationItem.setUpdTime(donation.getUpdTime());
				foodBankDao.persistDonationItem(donationItem);
			}
	}

	private void handleRecipientCSVUpload(String csvContent, HttpServletRequest request) {
		String[] lines = csvContent.split("\n");
		ConsumptionRequest consumptionRequest = new ConsumptionRequest();
		// Set donation content using 1st Line
		String[] consumptionRequestFields = lines[1].split(",");
		consumptionRequest.setPreferredBeneficiary(consumptionRequestFields[1]);
		consumptionRequest.setAppointmentTime(LocalDateTime.now());
		consumptionRequest.setFrequency(consumptionRequestFields[3]);
		consumptionRequest.setComments(consumptionRequestFields[4]);
		consumptionRequest.setConsumerID((int) request.getSession().getAttribute("userId"));
		consumptionRequest.setUpdTime(LocalDateTime.now());
		foodBankDao.persistConsumptionRequest(consumptionRequest);

		for (int lineNumber = 1; lineNumber < lines.length; lineNumber++) {
			String fields[] = lines[lineNumber].split(",");
			if (fields.length < 11) {
				throw new RuntimeException("Invalid number of fields in line " + lineNumber);
			}
			ConsumptionRequestItem consumptionRequestItem = new ConsumptionRequestItem();
			consumptionRequestItem.setConsumptionRequestID(consumptionRequest.getConsumptionRequestID());
			consumptionRequestItem.setCategoryID(Category.getIdForDesc(fields[5]));
			consumptionRequestItem.setFoodItem(fields[6]);
			consumptionRequestItem.setQuantity(Integer.parseInt(fields[7]));
			consumptionRequestItem.setUnits(fields[8]);
			//donationItem.setNutrition(fields[9]);
			consumptionRequestItem.setExpirationDate(LocalDate.now());
			consumptionRequestItem.setUpdTime(consumptionRequest.getUpdTime());
			foodBankDao.persistConsumptionRequestItem(consumptionRequestItem, (int) request.getSession().getAttribute("userId"));
		}
	}
	
	/*private void handleFoodBankCSVUpload(String csvContent) {
		for (String line : csvContent.split("\n")) {
			for (String field : line.split(",")) {
				System.out.print(field + "\t");
			}
			System.out.println();
		}
	}
	*/
	
	private void handleFoodBankCSVUpload(String csvContent,HttpServletRequest request) {
		String[] lines = csvContent.split("\n");
		
		for (int lineNumber = 1; lineNumber < lines.length; lineNumber++) {
			String fields[] = lines[lineNumber].split(",");
			if (fields.length < 3) {
				throw new RuntimeException("Invalid number of fields in line " + lineNumber);
			}
			ConsumptionAllocated consumptionAllocated = new ConsumptionAllocated();
			consumptionAllocated.setConsumptionRequestItemID(foodBankDao.getRecipientID(fields[1]).get(0));
			consumptionAllocated.setFoodItem(fields[0]);
			consumptionAllocated.setConsumptionRequestID(0);
			consumptionAllocated.setUserName(fields[1]);
			consumptionAllocated.setQuantity((Integer.parseInt(fields[2])));
			consumptionAllocated.setUpdTime(LocalDateTime.now());
			foodBankDao.persistConsumptionAllocated(consumptionAllocated);
			System.out.println(foodBankDao.getRecipientID(fields[1]).get(0) + " "+ fields[1]);
			foodBankDao.stalePendingCounsumptionRequestItem(foodBankDao.getRecipientID(fields[1]).get(0),fields[0]);
			List<AvailableInventory> inventories = foodBankDao.getPersistedAvailableInventory(fields[0]);
			if (inventories != null && inventories.size() > 0) {
				AvailableInventory availableInventory = inventories.get(0);
				availableInventory.setQuantity(availableInventory.getQuantity() - Integer.parseInt(fields[2]));
				foodBankDao.updateAvailableInventoryQuantity(availableInventory);
				foodBankDao.persistAvailableInventory(availableInventory);
			}
		}
	}

}
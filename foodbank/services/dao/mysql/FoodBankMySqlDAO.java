package foodbank.services.dao.mysql;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import foodbank.domain.ActiveRequest;
import foodbank.domain.AvailableInventory;
import foodbank.domain.Category;
import foodbank.domain.ConsumptionAllocated;
import foodbank.domain.ConsumptionHistory;
import foodbank.domain.ConsumptionRequest;
import foodbank.domain.ConsumptionRequestItem;
import foodbank.domain.Donation;
import foodbank.domain.DonationItem;
import foodbank.domain.UserInfo;
import foodbank.domain.UserLogin;
import foodbank.exceptions.InvalidCredentialsException;

public class FoodBankMySqlDAO extends MySqlDAO {

	private static final String LATEST_UPD_TIME_END_STRING = "29000101";

	private final FoodBankSequenceSeedHome sequenceSeedHome;

	private static FoodBankMySqlDAO instance = null;

	public FoodBankMySqlDAO(String host, String port, String database, String user, String password) {
		super(host, port, database, user, password);
		sequenceSeedHome = new FoodBankSequenceSeedHome(host, port, database, user, password);
		if (instance == null) {
			instance = this;
		}
	}

	public boolean registerUser(UserInfo userInfo) {
		userInfo.setUserId(sequenceSeedHome.getUserInfoSeed());
		return 0 < executeUpdate(
				"INSERT INTO user_info (user_id, email, user_name, address_line, city, state, country, zip_code, phone_number, user_description, user_type, transportation_method, population, upd_time, upd_time_end) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				userInfo.getUserId(),
				userInfo.getEmail(),
				userInfo.getUserName(),
				userInfo.getAddressLine(),
				userInfo.getCity(),
				userInfo.getState(),
				userInfo.getCountry(),
				userInfo.getZipCode(),
				userInfo.getPhoneNumber(),
				userInfo.getUserDescription(),
				userInfo.getUserType().toString(),
				userInfo.getTransportationMethod(),
				userInfo.getPopulation(),
				userInfo.getUpdTime(),
				LATEST_UPD_TIME_END_STRING)
			&& 0 < executeUpdate("INSERT INTO user_login (user_id, email, user_type, password, upd_time, upd_time_end) values (?, ?, ?, ?, ?, ?)",
				userInfo.getUserId(),
				userInfo.getEmail(),
				userInfo.getUserType().toString(),
				getMD5Hash(userInfo.getPassword()),
				userInfo.getUpdTime(),
				LATEST_UPD_TIME_END_STRING
				);
	}

	public UserLogin checkAndGetUserLogin(String userId, String password) {
		if (userId == null || password == null) {
			throw new InvalidCredentialsException();
		}
		List<UserLogin> userLogins = RowMappers.mapAllRows(executeQuery("SELECT user_id, email, password, user_type FROM user_login WHERE email=? AND upd_time_end=?", userId, LATEST_UPD_TIME_END_STRING), RowMappers.USER_LOGIN_MAPPER);
		if (userLogins != null && userLogins.size() > 0 && getMD5Hash(password).equals(userLogins.get(0).getPassword())) {
			return userLogins.get(0);
		}
		throw new InvalidCredentialsException();
	}

	public boolean persistDonation(Donation donation) {
		donation.setDonationID(sequenceSeedHome.getDonationSeed());

		return 0 > executeUpdate("INSERT INTO donation (donation_id, donor_id, preferred_beneficiary, appointment_time, frequency, comments, upd_time, upd_time_end) values (?, ?, ?, ?, ?, ?, ?, ?)",
			donation.getDonationID(),
			donation.getDonorID(),
			donation.getPreferredBeneficiary(),
			donation.getAppointmentTime(),
			donation.getFrequency(),
			donation.getComments(),
			donation.getUpdTime(),
			LATEST_UPD_TIME_END_STRING
		);

	}

	public boolean persistDonationItem(DonationItem donationItem) {
		donationItem.setDonationItemID(sequenceSeedHome.getDonationItemSeed());
		System.out.println("Persisting donationItem " + donationItem);

		executeUpdate("INSERT INTO donation_item (donation_item_id, donation_id, category_id, food_item, units, quantity, expiration_date, upd_time, upd_time_end) values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
			donationItem.getDonationItemID(),
			donationItem.getDonationID(),
			donationItem.getCategoryID(),
			donationItem.getFoodItem(),
			donationItem.getUnits(),
			donationItem.getQuantity(),
			donationItem.getExpirationDate(),
			donationItem.getUpdTime(),
			LATEST_UPD_TIME_END_STRING
		);

		List<AvailableInventory> availableInventories = getPersistedAvailableInventory(Category.getDescForId(donationItem.getCategoryID()), donationItem.getFoodItem());
		int quantity = donationItem.getQuantity();
		if (availableInventories != null && availableInventories.size() > 0) {
			AvailableInventory availableInventory = availableInventories.get(0);
			quantity += availableInventory.getQuantity();
			updateAvailableInventoryQuantity(availableInventory);
		}
		AvailableInventory availableInventory = new AvailableInventory();
		availableInventory.setAvailableInventoryId(sequenceSeedHome.getAvailableInventorySeed());
		availableInventory.setCategoryName(Category.getDescForId(donationItem.getCategoryID()));
		availableInventory.setFoodItem(donationItem.getFoodItem());
		availableInventory.setQuantity(quantity);
		availableInventory.setUnit(donationItem.getUnits());
		availableInventory.setUpdTime(LocalDateTime.now());
		
		persistAvailableInventory(availableInventory);
		return true;
	}

	public List<Pair<Donation, List<DonationItem>>> getPersistedDonations(int userId) {
		System.out.println("Checking donations for user - " + userId);
		List<Pair<Donation, List<DonationItem>>> result = new ArrayList<>();
		List<Donation> donations = RowMappers.mapAllRows(executeQuery("SELECT * FROM donation WHERE donor_id=? AND UPD_TIME_END=? ORDER BY upd_time DESC LIMIT 10", userId, LATEST_UPD_TIME_END_STRING), RowMappers.DONATION_MAPPER);
		for (Donation donation: donations) {
			result.add(new ImmutablePair<Donation, List<DonationItem>>(donation, getPersistedDonationItems(donation.getDonationID())));
		}
		System.out.println("Donations returned - " + result);
		return result;
	}

	private List<DonationItem> getPersistedDonationItems(int donationId) {
		return RowMappers.mapAllRows(executeQuery("SELECT * FROM donation_item WHERE donation_id=?", donationId), RowMappers.DONATION_ITEM_MAPPER);
	}
	
	public boolean persistConsumptionRequest(ConsumptionRequest consumptionRequest) {
		consumptionRequest.setConsumptionRequestID(sequenceSeedHome.getConsumptionRequestSeed());

		return 0 < executeUpdate("INSERT INTO consumption_request (consumption_request_id, consumer_id, preferred_beneficiary, appointment_time, frequency, comments, upd_time, upd_time_end) values (?, ?, ?, ?, ?, ?, ?, ?)",
			consumptionRequest.getConsumptionRequestID(),
			consumptionRequest.getConsumerID(),
			consumptionRequest.getPreferredBeneficiary(),
			consumptionRequest.getAppointmentTime(),
			consumptionRequest.getFrequency(),
			consumptionRequest.getComments(),
			consumptionRequest.getUpdTime(),
			LATEST_UPD_TIME_END_STRING
		);
	}
	
	public boolean persistConsumptionRequestItem(ConsumptionRequestItem consumptionRequestItem, int userId) {
		consumptionRequestItem.setConsumptionRequestItemID(sequenceSeedHome.getConsumptionRequestItemSeed());
		System.out.println("Persisting consumptionRequestItem " + consumptionRequestItem);

		executeUpdate("INSERT INTO consumption_request_item (consumption_request_item_id, consumption_request_id, category_id, food_item, units, quantity, expiration_date, upd_time, upd_time_end) values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
			consumptionRequestItem.getConsumptionRequestItemID(),
			consumptionRequestItem.getConsumptionRequestID(),
			consumptionRequestItem.getCategoryID(),
			consumptionRequestItem.getFoodItem(),
			consumptionRequestItem.getUnits(),
			consumptionRequestItem.getQuantity(),
			consumptionRequestItem.getExpirationDate(),
			consumptionRequestItem.getUpdTime(),
			LATEST_UPD_TIME_END_STRING
		);

		persistActiveRequest(consumptionRequestItem, userId);
		
		return true;
	}

	public boolean persistActiveRequest(ConsumptionRequestItem consumptionRequestItem, int userId) {
		String sql = "INSERT INTO pending_consumption_request_item (pending_consumption_request_item_id, user_id, category_id, food_item, units, quantity, expiration_date, upd_time, upd_time_end) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return 0 < executeUpdate(sql, sequenceSeedHome.getPendingConsumptionRequestItemSeed(), userId, consumptionRequestItem.getCategoryID(), consumptionRequestItem.getFoodItem(), consumptionRequestItem.getUnits(), consumptionRequestItem.getQuantity(), consumptionRequestItem.getExpirationDate(), LocalDateTime.now(), LATEST_UPD_TIME_END_STRING);
	}

	public List<Pair<ConsumptionRequest, List<ConsumptionRequestItem>>> getPersistedConsumptionRequests(int userId) {
		System.out.println("Checking consumption request for user - " + userId);
		List<Pair<ConsumptionRequest, List<ConsumptionRequestItem>>> result = new ArrayList<>();
		List<ConsumptionRequest> consumptionRequests = RowMappers.mapAllRows(executeQuery("SELECT * FROM consumption_request WHERE consumer_id=? AND UPD_TIME_END=? ORDER BY upd_time DESC LIMIT 10", userId, LATEST_UPD_TIME_END_STRING), RowMappers.CONSUMPTION_REQUEST_MAPPER);
		for (ConsumptionRequest consumptionRequest: consumptionRequests) {
			result.add(new ImmutablePair<ConsumptionRequest, List<ConsumptionRequestItem>>(consumptionRequest, getPersistedConsumptionRequestItems(consumptionRequest.getConsumptionRequestID())));
		}
		return result;
	}

	private List<ConsumptionRequestItem> getPersistedConsumptionRequestItems(int consumptionRequestId) {
		return RowMappers.mapAllRows(executeQuery("SELECT * FROM consumption_request_item WHERE consumption_request_id=?", consumptionRequestId), RowMappers.CONSUMPTION_REQUEST_ITEM_MAPPER);
	}
	

	public boolean persistConsumptionHistory(ConsumptionHistory consumptionHistory) {
		System.out.println("Persisting consumptionHistory " + consumptionHistory);

		return 0 < executeUpdate("INSERT INTO consumption_history (consumer_id, consumption_request_id, requested_quantity, fulfilled_amount, ytd_requested_quantity, ytd_fulfilled_amount, upd_time, upd_time_end) values (?, ?, ?, ?, ?, ?, ?, ?)",
			consumptionHistory.getConsumerID(),
			consumptionHistory.getConsumptionRequestID(),
			consumptionHistory.getRequestedQuantity(),
			consumptionHistory.getFulfilledAmount(),
			consumptionHistory.getYtdRequestedQuantity(),
			consumptionHistory.getYtdFulfilledAmount(),
			consumptionHistory.getUpdTime(),
			LATEST_UPD_TIME_END_STRING
		);
	}
	
	public boolean persistConsumptionAllocated(ConsumptionAllocated consumptionAllocated) {
		System.out.println("Persisting consumptionAllocated " + consumptionAllocated);

		return 0 < executeUpdate("INSERT INTO consumption_allocated (consumption_request_item_id, food_item, consumption_request_id, user_name, quantity, upd_time, upd_time_end) values (?, ?, ?, ?, ?, ?, ?)",
			consumptionAllocated.getConsumptionRequestItemID(),
			consumptionAllocated.getFoodItem(),
			consumptionAllocated.getConsumptionRequestID(),
			consumptionAllocated.getUserName(),
			consumptionAllocated.getQuantity(),
			consumptionAllocated.getUpdTime(),
			LATEST_UPD_TIME_END_STRING
		);
	}

	
	public boolean persistAvailableInventory(AvailableInventory availableInventory) {
		System.out.println("Persisting availableInventory " + availableInventory);

		return 0 < executeUpdate("INSERT INTO available_inventory (available_inventory_id, category,food_item, quantity,unit, upd_time, upd_time_end) values (?, ?, ?, ?, ?, ?, ?)",
			availableInventory.getAvailableInventoryId(),
			availableInventory.getCategoryName(),
			availableInventory.getFoodItem(),
			availableInventory.getQuantity(),
			availableInventory.getUnit(),
			availableInventory.getUpdTime(),
			LATEST_UPD_TIME_END_STRING
		);
	}

	public List<Integer> getRecipientID(String recipientName) {
			return RowMappers.mapAllRows(executeQuery("SELECT * FROM user_info WHERE user_name=?", recipientName),RowMappers.RECIPIENT_ID_MAPPER);
	}
	
	public List<String> getRecipientName(int recipientId) {
		return RowMappers.mapAllRows(executeQuery("SELECT * FROM user_info WHERE user_id=?", recipientId),RowMappers.RECIPIENT_NAME_MAPPER);
	}

	public List<AvailableInventory> getPersistedAvailableInventory() {
		List<AvailableInventory> availableInventories = RowMappers.mapAllRows(executeQuery("SELECT * FROM available_inventory WHERE quantity > 0 and upd_time_end=?", LATEST_UPD_TIME_END_STRING), RowMappers.AVAILABLE_INVENTORY_MAPPER);
		for (AvailableInventory availableInventory : availableInventories) {
			availableInventory.setActiveRequest(getActiveRequestsForFoodItem(availableInventory.getFoodItem()));
		}
		return availableInventories;
	}

	private List<ActiveRequest> getActiveRequestsForFoodItem(String foodItem) {
		List<ActiveRequest> activeRequests = new ArrayList<>();
		activeRequests.addAll(RowMappers.mapAllRows(executeQuery("SELECT p.*, u.user_name FROM pending_consumption_request_item p JOIN user_info u ON (p.user_id=u.user_id) WHERE p.food_item=? AND p.upd_time_end=? AND p.quantity > 0", foodItem, LATEST_UPD_TIME_END_STRING), RowMappers.ACTIVE_REQUEST_MAPPER));
		return activeRequests;
	}

	public List<AvailableInventory> getPersistedAvailableInventory(String category, String foodItem) {
		return RowMappers.mapAllRows(executeQuery("SELECT * FROM available_inventory WHERE category=? AND food_item=? AND quantity > 0 and upd_time_end=?", category, foodItem, LATEST_UPD_TIME_END_STRING), RowMappers.AVAILABLE_INVENTORY_MAPPER);
	}

	public List<AvailableInventory> getPersistedAvailableInventory(String foodItem) {
		return RowMappers.mapAllRows(executeQuery("SELECT * FROM available_inventory WHERE food_item=? AND quantity > 0 and upd_time_end=?", foodItem, LATEST_UPD_TIME_END_STRING), RowMappers.AVAILABLE_INVENTORY_MAPPER);
	}

	public boolean updateAvailableInventoryQuantity(AvailableInventory availableInventory) {
		return 0 < executeUpdate("UPDATE available_inventory SET upd_time_end=? WHERE available_inventory_id=?", LocalDateTime.now(), availableInventory.getAvailableInventoryId());
	}

	public List<ConsumptionHistory> getPersistedConsumptionHistory() {
		return RowMappers.mapAllRows(executeQuery("SELECT ch.*, ui.user_name FROM consumption_history ch JOIN user_info ui  ON ch.consumer_id=ui.user_id  ORDER BY upd_time DESC LIMIT 5"), RowMappers.CONSUMPTION_HISTORY_MAPPER);
	}

	public List<ConsumptionHistory> getPersistedConsumptionHistoryForRecipient(int recipientId) {
		return RowMappers.mapAllRows(executeQuery("SELECT * FROM consumption_history WHERE recipientId = ? ORDER BY upd_time DESC LIMIT 5",recipientId), RowMappers.CONSUMPTION_HISTORY_MAPPER);
	}

	public List<ConsumptionHistory> getPersistedLastConsumptionHistory(int recipientId) {
		return RowMappers.mapAllRows(executeQuery("SELECT * FROM consumption_history WHERE recipientId = ? ORDER BY upd_time DESC LIMIT 1",recipientId), RowMappers.CONSUMPTION_HISTORY_MAPPER);
	}

	public boolean stalePendingCounsumptionRequestItem(int userId, String foodItem) {
		return 0 < executeUpdate("UPDATE pending_consumption_request_item SET upd_time_end=? WHERE user_id=? AND food_item=?", LocalDateTime.now(), userId, foodItem);
	}
	
//	public boolean updateA(int userId, String foodItem) {
//		return 0 < executeUpdate("UPDATE pending_consumption_request_item SET upd_time_end=? WHERE user_id=? AND food_item=?", LocalDateTime.now(), userId, foodItem);
//	}

	private static String getMD5Hash(String password) {
		return DigestUtils.md5Hex(password).toUpperCase();
	}

	private static Date getDate(java.util.Date date) {
		return new Date(date.toInstant().toEpochMilli());
	}

	public static FoodBankMySqlDAO getInstance() {
		return instance;
	}
}

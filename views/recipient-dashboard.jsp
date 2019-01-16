<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="foodbank.domain.Category,foodbank.services.dao.mysql.FoodBankMySqlDAO,java.util.List,foodbank.domain.ConsumptionRequest,foodbank.domain.ConsumptionRequestItem,org.apache.commons.lang3.tuple.Pair" %>
<% request.setAttribute("itemCount", 0); %>
<% int itemCount = 0; %>
<html>
 	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Recipient Dashboard</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<!-- Animate.css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">

	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/logincss.css" type="text/css" media="all">
	<link rel="stylesheet" href="../../resources/css/back.css">
	<link rel="stylesheet" href="../../resources/css/top.css">
	<link rel="stylesheet" href="../../resources/css/input_form.css">
	
	<script src="<%=request.getContextPath()%>/resources/js/modernizr-2.6.2.min.js"></script>

    <style>
    tr:nth-child(even) {
        background-color: #f2f2f2
    }
    </style>	
	</head>
	<body>

	<nav id="fh5co-main-nav" role="navigation">
		<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle active"><i></i></a>
		<div class="js-fullheight fh5co-table">
			<div class="fh5co-table-cell js-fullheight">
				<ul>
					<li><a href="about.html">About</a></li>
					<li><a href="contact.html">Contact</a></li>
					<li><a href="profile.html">Profile</a></li>
				</ul>
			</div>
		</div>
	</nav>
	 <div id="id01" class="modal">
 
		 <form class="modal-content animate" action="${contextPath}/user/login/" method="POST">
		   
		
		   <div class="container">
		     <label for="uname"><b>Username</b></label>
		     <input type="text" placeholder="Enter Username" name="username" required>
		
		     <label for="pwd"><b>Password</b></label>
		     <input type="password" placeholder="Enter Password" name="pwd" required>
		       
		     <button type="submit">Login</button>
		     <label>
		       <input type="checkbox" checked="checked" name="rememberme"> Remember me
		     </label>
		   </div>
		
		   <div class="container" style="background-color:#f1f1f1">
		     <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
		     <span class="psw">Forgot <a href="#">password?</a></span>
		   </div>
		 </form>
		</div>
		
	<div id="id02" class="modal"><h3>Sign Up Form</h3>
 
		 <form  class="modal-content animate" action="${contextPath}/user/register/" method="POST">
		   
		
		   <div class="container">
		     <label for="name"><b>Name</b></label>
		     <input type="text" placeholder="Enter Fullname" name="name" required>
		
		     <label for="pwd"><b>Passport</b></label>
		     <input type="text" placeholder="Enter Passport Number" name="passport" required>
		     
		     <label for="emailId"><b>Email Id</b></label>
		     <input type="text" placeholder="Enter Email" name="emailId" required>
		     
		     <label for="username"><b>UserName</b></label>
		     <input type="text" placeholder="Enter Username" name="username" required>
		     
		     <label for="pwd"><b>Password</b></label>
		     <input type="password" placeholder="Enter Password" name="pwd" required>
		     
		     <label for="contact"><b>Contact</b></label>
		     <input type="text" placeholder="Enter Contact" name="contact" required>
		    
		   <br><br>
		       
		     <button type="submit">Signup</button>
		     <label>
		       <input type="checkbox" checked="checked" name="agreement"> By Clicking this, I agree all terms and policies
		     </label>
		   </div>
		
		   <div class="container" style="background-color:#f1f1f1">
		     <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
		     <span class="psw">Forgot <a href="#">password?</a></span>
		   </div>
		 </form>
		</div>
		
    <div class="cornell_logo">
    	<img src="../../resources/images/logo/cornell.png" width="125" height="125">
    </div>
	<div class="site_name">
		<p class="site_name_text">Ithaca Foodbank</p>
	</div>
	<div id="fh5co-page">
		<header>
			<div class="container">
				<div class="fh5co-navbar-brand">
					<h1 class="text-center"><a class="fh5co-logo" href="index.html"><i class="icon-camera2"></i></a></h1>
					<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
				</div>
			</div>
		</header>
		<div id="fh5co-intro-section">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 animate-box text-center">
						<h2 class="intro-heading">Cornell Against Hunger!.</h2>
					</div>
				</div>
			</div>
		</div>
		
		
<div class="back_container">
  <img src="../../resources/images/back_recipient.png" alt="background" style="width:100%;">
  <div class="center-top">NURTURING THE DEPRIVED</div>
  <div class="center-center">The war against hunger is truly mankind's war of liberation!<br/>- John F Kennedy</div>
</div>
		<div id="fh5co-services-section">
			<div class="container">
				<form>
				<div class="row">
					<div class="col-md-4 text-center animate-box">
						<div class="services">
							<span><i class="icon-video-camera2"></i></span>
							<a onclick="selectTab('request-form');"><h3>Request Your Needs</h3></a>
						</div>
					</div>
					<div class="col-md-4 text-center animate-box">
						<div class="services">
							<span><i class="icon-cloud-download"></i></span>
							<a onclick="selectTab('upload-csv');"><h3>Upload CSV</h3></a>
						</div>
					</div>
					<div class="col-md-4 text-center animate-box">
						<div class="services">
							<span><i class="icon-camera2"></i></span>
							<a onclick="selectTab('request-table');"><h3>Check Request Status</h3></a>
						</div>
					</div>
				</div>
				</form>
			</div>
		</div>
        <div>
            
        <div id="request-form" style="visibility:hidden; width:80%; margin: 0 auto; padding: 5px; display: none;">
         <label for="requestForm" style="padding-left: 10%;"><b>Specify your request:</b></label>
         <form class="modal-content animate" action="consume" method="POST">

		   <div class="FormContainer">

		     <span id="itemCount" style="display: none; visibility=hidden;">0</span>

		     <label for="foodBank"><b>Food Bank</b></label>
		     <input type="text" placeholder="Enter Food Bank" name="foodBank" required>

		     <label for="preferredBeneficiary"><b>Preferred Beneficiary</b></label>
		     <input type="text" placeholder="Enter Preferred Beneficiary" name="preferredBeneficiary" value="">

		     <label for="appointmentTime"><b>Appointment Time</b></label><br>
		     <input type="datetime-local" placeholder="Enter Appointment Time" name="appointmentTime" required><br>
		     
		     <label for="frequency"><b>Frequency</b></label>
		     <input type="text" placeholder="Enter Frequency" name="frequency" required>

		     <label for="comments"><b>Comments</b></label>
		     <input type="text" placeholder="Enter Comments" name="comments" required>

		     <input type="hidden" id="foodItemCount" name="itemCount" />

		   <br><br>
		    
		     <label for="foodBank"><b>Request Items:</b></label>
             <br/><br/>
		     <div id="foodItemsContainter"></div>
		     <a class="FoodItemButton" onclick="addItem()">+</a>
		     <a class="FoodItemButton" onclick="removeItem()">-</a>
             <br><br>
		    
		    
			<div class="FoodItem" id="sampleFoodItem" style="display: none; visibility: hidden;">

		     <label for="category"><b>Category</b></label>
		     <select id="field0" name="category">
               <c:forEach var="categoryItem" items="${Category.values()}">
                 <option value="${categoryItem.categoryId}">${categoryItem.description}</option>
               </c:forEach>
		     </select>

		     <label for="foodItem"><b>Food Item</b></label>
		     <input id="field1" type="text" placeholder="Enter Food Item" name="foodItem" required>
		     
		     <label for="quantity"><b>Quantity</b></label>
		     <input id="field2" type="text" placeholder="Enter Quantity" name="quantity" required>
		     
		     <label for="unit"><b>Unit</b></label>
		     <input id="field3" type="text" placeholder="Enter Unit" name="unit" required>

		     <label for="Nutrition"><b>Nutrition</b></label>
		     <br/>
		     <input id="field4" type="text" placeholder="Enter Nutrition" name="nutrition" required>
		     <br/>

		     <label for="Expiration"><b>Expiration Date</b></label>
		     <br/>
		     <input id="field5" type="date" placeholder="Enter Expiration Date" name="expiration">
		     <br/>
			</div>

		   <br><br>
		       
		     <button onclick="submitFoodItemForm()" type="submit">Submit Request</button>
		   </div>
		</form>
		
        </div>
        
        <div id="request-table" style="visibility: hidden; width: 100%; margin: 0 auto; padding: 5px;">
		<%
		System.out.println("Building page for user " + request.getSession().getAttribute("userId"));
			System.out.println(FoodBankMySqlDAO.getInstance());
			List<Pair<ConsumptionRequest, List<ConsumptionRequestItem>>> consumptionRequestsData = FoodBankMySqlDAO.getInstance().getPersistedConsumptionRequests((Integer) request.getSession().getAttribute("userId"));
			System.out.println("Logged - " + consumptionRequestsData);
			request.setAttribute("consumptionRequestsData", consumptionRequestsData);
		%>
         <form class="modal-content animate">
            <table class="table table-striped table-hover">
              <thead style="background-color:NavajoWhite;">
                <tr>
                  <th>Request Id</th>
                  <th>Preferred Beneficiary</th>
                  <th>Appointment Time</th>
                  <th>Frequency</th>
                  <th>Comments</th>
                  <th>Requested On</th>
                  <th>View Requested Items</th>
                </tr>
              </thead>
              <tbody>
	          <c:forEach items="${consumptionRequestsData}" var="consumptionRequestData">
                 <tr>
                   <td>${consumptionRequestData.left.consumptionRequestID}</td>
                   <td>${consumptionRequestData.left.preferredBeneficiary}</td>
                   <td>${consumptionRequestData.left.appointmentTimeString}</td>
                   <td>${consumptionRequestData.left.frequency}</td>
                   <td>${consumptionRequestData.left.comments}</td>
                   <td>${consumptionRequestData.left.updTimeString}</td>
                   <td><a onclick="displayDonationData(${consumptionRequestData.left.consumptionRequestID})">View</a></td>
                 </tr>
              </c:forEach>
              </tbody>
            </table>
          </form>

			<span id="selectedConsumptionRequestedItem" style="display: none; visibility: hidden;"></span>
            <label id="consumptionRequestItemsTableLabel" style="padding-left: 10%;"></label>
            <c:forEach items="${consumptionRequestsData}" var="consumptionRequestData">
            <form id="consumptionItems${consumptionRequestData.left.consumptionRequestID}" style="display: none; visibility: hidden;" class="modal-content animate">
            <table class="table table-striped table-hover">
              <thead style="background-color:NavajoWhite;">
                <tr>
                  <th>Category</th>
                  <th>Food Item</th>
                  <th>Quantity</th>
                  <th>Unit</th>
                  <th>ExpirationDate</th>
                </tr>
              </thead>
              <tbody>
	            <c:forEach items="${consumptionRequestData.right}" var="consumptionRequestDataItem">
                 <tr>
                   <td>${consumptionRequestDataItem.categoryID}</td>
                   <td>${consumptionRequestDataItem.foodItem}</td>
                   <td>${consumptionRequestDataItem.quantity}</td>
                   <td>${consumptionRequestDataItem.units}</td>
                   <td>${consumptionRequestDataItem.expirationDate}</td>
	             </tr>
	            </c:forEach>
              </tbody>
            </table>
			</form>
            </c:forEach>
    
          </div>

        
           
        </div>	
        
        <div id="upload-csv" class="container" style="visibility: hidden; width: 100%; margin: 0 auto; padding: 5px; display: none;">
			<form class="modal-content animate" action="upload" method="POST" enctype="multipart/form-data">
				<br/>
				<label for="uploadCSV" style="padding-left: 10%;"><b>Upload CSV:</b></label>
				<input type="text" name="userType" value="recipient" style="visibility: hidden; display: none;" />
			    <input type="file" id="fileElem" name="bill_image" multiple accept="*.csv" onchange="handleFiles(this.files)" style="width: 80%; margin-left: 10%; padding-bottom: 10px;">
				<button type="submit" style="margin-left: 10%; margin-right: 10%; width: 80%; margin-bottom: 1%;" value="Upload">Upload</button>
			</form>
		</div>	
	</div>

	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.waypoints.min.js"></script>
	<!-- Counters -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.countTo.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>

	<script type="text/javascript">	
		
		function addItem() {
			var itemCount = parseInt(document.getElementById("itemCount").innerHTML);
			itemCount = 1 + itemCount;
			document.getElementById("itemCount").innerHTML = itemCount;
			var sampleItem = document.getElementById("sampleFoodItem");
			var newItem = sampleItem.cloneNode(true);
			newItem.id = "foodItem" + itemCount;
			newItem.style = ""
			
			// Change names for each field:
			newItem.querySelector("#field0").name = newItem.querySelector("#field0").name + itemCount;
			newItem.querySelector("#field1").name = newItem.querySelector("#field1").name + itemCount;
			newItem.querySelector("#field2").name = newItem.querySelector("#field2").name + itemCount;
			newItem.querySelector("#field3").name = newItem.querySelector("#field3").name + itemCount;
			newItem.querySelector("#field4").name = newItem.querySelector("#field4").name + itemCount;
			newItem.querySelector("#field5").name = newItem.querySelector("#field5").name + itemCount;

			document.getElementById("foodItemsContainter").appendChild(newItem);
		}

		function removeItem() {
			var itemCount = parseInt(document.getElementById("itemCount").innerHTML);
			if (itemCount == 0) {
				return;
			}
			var lastItemId = "foodItem" + itemCount;
			document.getElementById("foodItemsContainter").removeChild(document.getElementById(lastItemId));
			itemCount = itemCount - 1;
			document.getElementById("itemCount").innerHTML = itemCount;
		}

		function submitFoodItemForm() {
			document.getElementById("sampleFoodItem").parentElement.removeChild(document.getElementById("sampleFoodItem"));
			document.getElementById("foodItemCount").value = parseInt(document.getElementById("itemCount").innerHTML);
		}
		
		function displayDonationData(consumptionId) {
			document.getElementById("consumptionRequestItemsTableLabel").innerHTML = "<b>Consumption Items for Id " + consumptionId + "</b>";
			document.getElementById("consumptionItems" + consumptionId).style="visibility: visible; display: block;";
			if (document.getElementById("selectedConsumptionRequestedItem").innerHTML != "") {
				document.getElementById(document.getElementById("selectedConsumptionRequestedItem").innerHTML).style="visibility: hidden; display: none;";
			}
			document.getElementById("selectedConsumptionRequestedItem").innerHTML = "consumptionItems" + consumptionId;
		}
		
		function selectTab(tabId) {
			document.getElementById('request-table').style.visibility='hidden';
			document.getElementById('request-table').style.display='none';
			document.getElementById('request-form').style.visibility='hidden';
			document.getElementById('request-form').style.display='none';
			document.getElementById('upload-csv').style.visibility='hidden';
			document.getElementById('upload-csv').style.display='none';
			document.getElementById(tabId).style.visibility='visible';
			document.getElementById(tabId).style.display='block';
		}
		
	</script>

	</body>
</html>


<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="foodbank.domain.Category,foodbank.services.dao.mysql.FoodBankMySqlDAO,java.util.List,foodbank.domain.ConsumptionHistory,foodbank.domain.Donation,foodbank.domain.AvailableInventory,java.util.*,org.apache.commons.lang3.tuple.Pair" %>
<% request.setAttribute("itemCount", 0); %>
<% int itemCount = 0; %>
<html>
 	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>FoodBank Dashboard</title>
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
  <img src="../../resources/images/back_foodbank.jpg" alt="background" style="width:100%;">
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
							<a onclick="
								document.getElementById('allocate-by-item-container').style.visibility='hidden';
								document.getElementById('allocate-by-item-container').style.display='none';
								document.getElementById('request-table').style.display='block';
								document.getElementById('request-table').style.visibility='visible';
								document.getElementById('allocation-by-category-table').style.visibility='hidden';
								document.getElementById('allocation-by-category-table').style.display='none';
								document.getElementById('upload-csv').style.visibility='hidden';
								document.getElementById('upload-csv').style.display='none';">
								<h3>Allocate for Recipients</h3>
							</a>
						</div>
					</div>
					<div class="col-md-4 text-center animate-box">
						<div class="services">
							<span><i class="icon-cloud-download"></i></span>
							<a onclick="selectTab('upload-csv');"><h3>Upload Allocation CSV</h3></a>
						</div>
					</div>
					<div class="col-md-4 text-center animate-box">
						<div class="services">
							<span><i class="icon-camera2"></i></span>
							<a onclick="selectTab('allocation-by-category-table');"><h3>Allocate by Item</h3></a>
						</div>
					</div>
				</div>
				</form>
			</div>
		</div>
        <div>


        <div id="allocate-by-item-container" style="visibility:hidden; width:80%; margin: 0 auto; padding: 5px; display: none;">
         <label for="requestForm" style="padding-left: 10%;"><b>Select your category:</b></label>
         
        </div>

        <div id="request-table" style="visibility: hidden; width: 100%; margin: 0 auto; padding: 5px; display: none;">
         <label for="requestTable" style="padding-left: 10%;"><b>Allocate for Recipients:</b></label>
          <%
		System.out.println("Building page for user " + request.getSession().getAttribute("userId"));
			System.out.println(FoodBankMySqlDAO.getInstance());
			List<ConsumptionHistory> consumptionHistory = FoodBankMySqlDAO.getInstance().getPersistedConsumptionHistory();
			System.out.println("Logged - " + consumptionHistory);
			request.setAttribute("consumptionHistory", consumptionHistory);
		%>
         <form  class="modal-content animate" action="${contextPath}/user/register/" method="POST">
            <table class="table table-striped table-hover">
              <thead style="background-color:NavajoWhite;">
                <tr>
                  <th>Recipient Name</th>
                  <th>Fill Ratio</th>
                  <th>Recent Fill Ratio</th>
                  <th>Recent History</th>
                  <th>Allocate</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${consumptionHistory}" var="consumptionHistoryRow">
                <tr>
                  <td>${consumptionHistoryRow.consumerName}</td>
                  <td>${consumptionHistoryRow.ytdFulfilledAmount}/${consumptionHistoryRow.ytdRequestedQuantity}</td>
                  <td>0.8</td>
                  <td><a onclick="
                  			document.getElementById('recent_allocation_table').style.visibility='visible';
                  			document.getElementById('recent_allocation_table').style.display='inherit';
                  			document.getElementById('recent_allocation_label').style.visibility='visible';
                  			document.getElementById('recent_allocation_label').style.display='inherit';"
                  		>View</a></td>
                  <td><a onclick="
                  			document.getElementById('allocation_table').style.visibility='visible';
                  			document.getElementById('allocation_table').style.display='block';
                  			document.getElementById('allocation_label').style.visibility='visible';
                  			document.getElementById('allocation_label').style.display='block';"
                  		>Allocate</a></td>
                </tr>
                 </c:forEach>
              </tbody>
            </table>
         </form>

         <label id="recent_allocation_label" for="requestTable" style="padding-left: 10%; visibility: hidden; display: none;"><b>Recent History for Recipient Boys Home:</b></label>
         <form id="recent_allocation_table" class="modal-content animate" style="visibility: hidden; display: none;" action="${contextPath}/user/register/" method="POST">
            <table class="table table-striped table-hover">
              <thead style="background-color:NavajoWhite;">
                <tr>
                  <th>Allocation Date</th>
                  <th>Requested Units</th>
                  <th>Allocation Units</th>
                  <th>Fill Ratio</th>
                  <th>Cumulative Fill Ratio</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>2nd December, 2018</td>
                  <td>10</td>
                  <td>8</td>
                  <td>0.8</td>
                  <td>0.6</td>
                </tr>
                <tr>
                  <td>10th December, 2018</td>
                  <td>10</td>
                  <td>6</td>
                  <td>0.6</td>
                  <td>0.6</td>
                </tr>
                <tr>
                  <td>20th December, 2018</td>
                  <td>20</td>
                  <td>16</td>
                  <td>0.8</td>
                  <td>0.62</td>
                </tr>
                <tr>
                  <td>25th December, 2018</td>
                  <td>20</td>
                  <td>20</td>
                  <td>1.0</td>
                  <td>0.65</td>
                </tr>
              </tbody>
            </table>
            </form>


         <label id="allocation_label" for="requestTable" style="padding-left: 10%; visibility: hidden; display: none"><b>Allocate Items for the Recipient Boys Home:</b></label>
         <form id="allocation_table" class="modal-content animate" style="visibility: hidden; display: none" action="${contextPath}/user/register/" method="POST">
            <table class="table table-striped table-hover">
              <thead style="background-color:NavajoWhite;">
                <tr>
                  <th>Item</th>
                  <th>Requested Quantity</th>
                  <th>Allocation Quantity</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Cereal Boxes</td>
                  <td>10</td>
                  <td>
    <select name="allocation_units">
        <option value="0" selected>0</option>
        <%
        int availableQuantity = 10;
        for(int i=1;i<=availableQuantity;i++) {
        %>
        <option value="<%=i %>"><%=i %></option>
        <%} %>
    </select>
                  </td>
                </tr>
              </tbody>
            </table>
            <button type=submit style="margin-left: 10%; margin-right: 10%; width: 80%; margin-bottom: 1%;">Allocate</button>
            </form>
          </div>        
        </div>	
        
        <div id="upload-csv" class="container" style="visibility: hidden; width: 100%; margin: 0 auto; padding: 5px; display: none;">
			<form class="modal-content animate" action="upload" method="POST" enctype="multipart/form-data">
				<br/>
				<label for="uploadCSV" style="padding-left: 10%;"><b>Upload CSV:</b></label>
				<input type="text" name="userType" value="foodBank" style="visibility: hidden; display: none;" />
			    <input type="file" id="fileElem" name="bill_image" multiple accept="*.csv" onchange="handleFiles(this.files)" style="width: 80%; margin-left: 10%; padding-bottom: 10px;">
				<button type="submit" style="margin-left: 10%; margin-right: 10%; width: 80%; margin-bottom: 1%;" value="Upload">Upload</button>
			</form>
		</div>		
		
		
            
         <div id="allocation-by-category-table" style="visibility: hidden; width: 100%; margin: 0 auto; padding: 5px;">
         <label for="requestTable" style="padding-left: 10%;"><b>Allocate by Category:</b></label>
         
         <%
		System.out.println("Building page for user " + request.getSession().getAttribute("userId"));
			System.out.println(FoodBankMySqlDAO.getInstance());
			List<AvailableInventory> availableInventory = FoodBankMySqlDAO.getInstance().getPersistedAvailableInventory();
			System.out.println("Logged - " + availableInventory);
			request.setAttribute("availableInventory", availableInventory);
		%>
         <form  class="modal-content animate" action="allocate" method="POST">
            <table class="table table-striped table-hover">
              <thead style="background-color:NavajoWhite;">
                <tr>
                  <th>Category</th>
                  <th>Food Item</th>
                  <th>Available Quantity</th>
                  <th>Requested Quantity</th>
                  <th>Recipient</th>
                  <th>Quantity</th>
                </tr>
              </thead>
              <tbody>
              
	          <c:forEach items="${availableInventory}" var="availableItem">
                <c:forEach items="${availableItem.activeRequest}" var="activeRequest">
                 <tr>
                   <td>${availableItem.categoryName}</td>
                   <td>${availableItem.foodItem}</td>
                   <td>${availableItem.quantity} ${availableItem.unit}</td>
                  <td id="quantity_${availableItem.foodItem}">${activeRequest.quantity} ${activeRequest.units}</td>
                   <td>
                  	<select name="recipient_${availableItem.foodItem}" >
                  		<option onchange="document.getElementById('quantity_${availableItem.foodItem}').innerHTML='${activeRequest.quantity} ${activeRequest.units}';" value="${activeRequest.recipientId}">${activeRequest.recipientName}</option>
                  	</select>
                  </td>
                  <td><input type="text" name="quantity_${availableItem.foodItem}" style="width: 60%;"></input></td>
                 </tr>
                </c:forEach>
              </c:forEach>
            </tbody>
            </table>
            <button type=submit  style="margin-left: 10%; margin-right: 10%; width: 80%; margin-bottom: 1%;">Allocate</button>
            </form>
          </div>
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
		
		function selectTab(tabId) {
			document.getElementById('request-table').style.visibility='hidden';
			document.getElementById('request-table').style.display='none';
			document.getElementById('allocate-by-item-container').style.visibility='hidden';
			document.getElementById('allocate-by-item-container').style.display='none';
			document.getElementById('allocation-by-category-table').style.visibility='hidden';
			document.getElementById('allocation-by-category-table').style.display='none';
			document.getElementById('upload-csv').style.visibility='hidden';
			document.getElementById('upload-csv').style.display='none';
			document.getElementById(tabId).style.visibility='visible';
			document.getElementById(tabId).style.display='block';
		}
		
	</script>

	</body>
</html>



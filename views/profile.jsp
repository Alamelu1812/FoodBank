<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="foodbank.domain.Category" %>
<html>
 	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>FoodBank</title>
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
					<li><a href="services.html">Services</a></li>
					<li><a href="about">About</a></li>
					<li><a href="contact.html">Contact</a></li>
					<li><a href="profile.html">Profile</a></li>
				</ul>
			</div>
		</div>
	</nav>


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
  <img src="../../resources/images/back_profile.PNG" alt="background" style="width:100%; height:20%">
  <div class="center-top">Profile Information</div>
  <div class="center-center"><br/></div>
</div>

		
		<div id="profile">
 
		 <form  class="modal-content animate" action="${contextPath}/user/register/" method="POST">
		   
		
		   <div class="container">
		      <label for="name"><b>Name</b></label>
		     <input type="text" name="user_name" required>
		
		     <label for="email"><b>Email</b></label>
		     <input type="text" name="email" required>
		
		     <label for="pwd"><b>Password</b></label>
		     <input type="password" name="password" required>
		     
		     <label for="address_line"><b>Address Line</b></label>
		     <input type="text" name="address_line" required>
		     
		     <label for="city"><b>City</b></label>
		     <input type="text" name="city" required>
		     
		     <label for="state"><b>State</b></label>
		     <input type="text" name="state" required>
		     
		     <label for="country"><b>Country</b></label>
		     <input type="text" name="country" required>
		     
		     <label for="zip_code"><b>Zip Code</b></label>
		     <input type="text" name="zip_code" required>
		     
		     <label for="phone_number"><b>Phone Number</b></label>
		     <input type="text" name="phone_number" required>
		     
		     <label for="user_description"><b>Description</b></label>
		     <input type="text" name="user_description" required>
		     
		      <label for="user_type"><b>User Type</b></label>
		     <input type="text" name="user_type" required>
		     
		     <label for="transportation_method"><b>Transportation Method</b></label>
		     <input type="text" name="transportation_method" required>

		     <label for="population"><b>Population</b></label>
		     <input type="text" name="population" required>

		   <br><br>
		       
		     <button type="submit">Update Profile</button>
		   </div>
		
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


	</body>
</html>


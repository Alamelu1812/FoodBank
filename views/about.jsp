<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="foodbank.domain.Category" %>
<html>
 	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>FoodBank</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

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
  <img src="../../resources/images/back_aboutus.jpg" alt="background" style="width:100%;">
  <div class="center-top"></div>
  <div class="center-center"><br/></div>
</div>

		
		<div id="about_us">
			<div class="container">
			<h1><b>ABOUT US</b></h1>
			<p>We are a small organization based out of Ithaca and we try to meet the food demands of the people in our locality. Join us in our efforts to end hunger!!</p>		
			<br>
			<h3><b>Mission</b></h3>
			<p>Everyone should have access to good food. No one should have to go to bed hungry. </p>
			<br>
			<h3><b>Vision</b></h3>
			<p>Everyone should have access to sufficient nutritious food in future </p>
			<br>
			<h3><b>Values</b></h3>
			<ul>
					<li>We value respect, compassion and honesty</li>
					<li>We value listening and learning</li>
					<li>We value nutrition education and advocacy</li>
					<li>We value our staff and volunteers</li>
				</ul>
			</div>	
			</div>
		</div>
        <div>
            
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


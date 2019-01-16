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
  <img src="../../resources/images/back_contactus.jpg" alt="background" style="width:100%;">
  <div class="center-top"></div>
  <div class="center-center">Fighting hunger. Giving Hope.<br/></div>
</div>

		
		<div id="fh5co-services-section">
			<div class="container">
			<h1><b>CONTACT US</b></h1>
		
			<h3><b>H. Oliver Gao</b></h3>
			<p>Professor at Civil and Environmental Engineering<br>
			Director of Systems Engineering<br>
			Location - Hollister Hall, Room 314, Cornell University<br>
			Phone - +1-607-254-8334 <br>
			E-mail - hg55@cornell.edu</p>
			<br>
			
			<h3><b>Faisal M. M. Alkhannan Alkaabneh</b></h3>
			<p>PhD Student at Systems Engineering<br>
			Location - Upson Hall, Room 418, Cornell University<br>
			Phone - +1-000-000-000 <br>
			E-mail - fma34@cornell.edu</p>
			<br>
			
			<h3><b>Rajat Burmi</b></h3>
			<p>Masters Student in the Computer Science Department<br>
			Phone - +1-000-000-0000 <br>
			E-mail - rsb354@cornell.edu</p>
			<br>
			
			<h3><b>Alamelu Velappan Subramanian</b></h3>
			<p>Masters Student in the Computer Science Department<br>
			Phone - +1-000-000-0000 <br>
			E-mail - av377@cornell.edu</p>
			<br>
			
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


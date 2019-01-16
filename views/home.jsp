<!DOCTYPE html>

	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>FoodBank</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<link rel="stylesheet" href="./resources/css/animate.css">
	<link rel="stylesheet" href="./resources/css/icomoon.css">
	<link rel="stylesheet" href="./resources/css/bootstrap.css">
	<link rel="stylesheet" href="./resources/css/style.css">
	<link rel="stylesheet" href="./resources/css/gallery.css">
	<link rel="stylesheet" href="./resources/css/back.css">
	<link rel="stylesheet" href="./resources/css/top.css">
	<link rel="stylesheet" href="./resources/css/sponsors.css">

	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/logincss.css" type="text/css" media="all">
	
	<script src="./resources/js/modernizr-2.6.2.min.js"></script>
	
	</head>
	<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<nav id="fh5co-main-nav" role="navigation">
		<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle active"><i></i></a>
		<div class="js-fullheight fh5co-table">
			<div class="fh5co-table-cell js-fullheight">
				<ul>
					<li><a onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</a></li>
					<li><a onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Register</a></li>
				</ul>
			</div>
		</div>
	</nav>

	 <div id="id01" class="modal">
		 <form class="modal-content animate" action="${contextPath}/user/login/" method="POST">
		   <div class="container">
		     <label for="email"><b>Email Id</b></label>
		     <input type="text" placeholder="Enter Email Id" name="email" required>
		
		     <label for="password"><b>Password</b></label>
		     <input type="password" placeholder="Enter Password" name="password" required>
		       
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
		     <input type="text" placeholder="Enter Fullname" name="user_name" required>
		
		     <label for="email"><b>Email</b></label>
		     <input type="text" placeholder="Enter Email" name="email" required>
		
		     <label for="pwd"><b>Password</b></label>
		     <input type="password" placeholder="Enter password" name="password" required>
		     
		     <label for="address_line"><b>Address Line</b></label>
		     <input type="text" placeholder="Enter Address Line" name="address_line" required>
		     
		     <label for="city"><b>City</b></label>
		     <input type="text" placeholder="Enter City" name="city" required>
		     
		     <label for="state"><b>State</b></label>
		     <input type="text" placeholder="Enter State" name="state" required>
		     
		     <label for="country"><b>Country</b></label>
		     <input type="text" placeholder="Enter Country" name="country" required>
		     
		     <label for="zip_code"><b>Zip Code</b></label>
		     <input type="text" placeholder="Enter Zip Code" name="zip_code" required>
		     
		     <label for="phone_number"><b>Phone Number</b></label>
		     <input type="text" placeholder="Enter Phone Number" name="phone_number" required>
		     
		     <label for="user_description"><b>Description</b></label>
		     <input type="text" placeholder="Enter Description" name="user_description" required>

		     <label for="user_type"><b>User Type</b></label>
		     <select name="user_type" required>
		     	<option value="DONOR">Donor</option>
		     	<option value="FOODBANK">FoodBank</option>
		     	<option value="RECIPIENT">Recipient</option>
		     </select>
		     
		     <label for="transportation_method"><b>Transportation Method</b></label>
		     <input type="text" placeholder="Enter Transportation Method" name="transportation_method" required>

		     <label for="population"><b>Population</b></label>
		     <input type="text" placeholder="Enter Population" name="population" required>

		   <br><br>
		       
		     <button type="submit">Signup</button>
		     <label>
		       <input type="checkbox" checked="checked" name="agreement"> By Clicking this, I agree all terms and policies
		     </label>
		   </div>
		
		   <div class="container" style="background-color:#f1f1f1">
		     <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
		     <span class="psw"><a href="#">Forgot password?</a></span>
		   </div>
		 </form>
		</div>

    <div class="cornell_logo">
    	<img src="./resources/images/logo/cornell.png" width="125" height="125">
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
  <img src="./resources/images/back.jpg" alt="background" style="width:100%;">
  <div class="center-top">NURTURING THE DEPRIVED</div>
  <div class="center-center">If you can't feed a hundred people, feed just one!<br/>- Mother Teresa</div>
  <div class="center-bottom-left">
  	<button class="button button_white" onclick="document.getElementById('id01').style.display='block'">DONATE NOW</button>
  	<button class="button button_transparent" onclick="document.getElementById('id01').style.display='block'">ASK HELP</button>
  </div>
</div>


		<div id="fh5co-services-section">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 text-center animate-box ">
						<div class="heading-section">
							<h2>Our Services</h2>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 text-center animate-box">
						<div class="services">
							<span><i class="icon-video-camera2"></i></span>
							<h3><b>Donors</b></h3>
							<h3>Make Your Donations</h3>
						</div>
					</div>
					<div class="col-md-4 text-center animate-box">
						<div class="services">
							<span><i class="icon-cloud-download"></i></span>
							<h3><b>Recipients</b></h3>
							<h3>Seek Your Essentials</h3>
						</div>
					</div>
					<div class="col-md-4 text-center animate-box">
						<div class="services">
							<span><i class="icon-camera2"></i></span>
							<h3><b>Foodbanks</b></h3>
							<h3>Oversee The Inventory</h3>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

<div class="gallery_container">
<p style="font-family: 'monospace'; font-size: 50px;">EVENTS & SHOUTOUTS</p>

<div style="clear: both;"></div>
<script src="./resources/js/gallery.js"></script>
<div class="clearfix">
<div class="row">
  <div class="column">
    <img src="./resources/images/gallery/1.jpg" alt="1" onclick="openImg(this);">
  </div>
  <div class="column">
    <img src="./resources/images/gallery/2.jpg" alt="2" onclick="openImg(this);">
  </div>
  <div class="column">
    <img src="./resources/images/gallery/3.jpg" alt="3" onclick="openImg(this);">
  </div>
  <div class="column">
    <img src="./resources/images/gallery/4.jpg" alt="4" onclick="openImg(this);">
  </div>
  <div class="column">
    <img src="./resources/images/gallery/5.jpg" alt="5" onclick="openImg(this);">
  </div>
  <div class="column">
    <img src="./resources/images/gallery/6.jpg" alt="6" onclick="openImg(this);">
  </div>
  <div class="column">
    <img src="./resources/images/gallery/7.jpg" alt="7" onclick="openImg(this);">
  </div>
  <div class="column">
    <img src="./resources/images/gallery/8.jpg" alt="8" onclick="openImg(this);">
  </div>
</div>
</div>
<div style="clear: both;"></div>

<!-- The expanding image container -->
<div class="container">
  <!-- Close the image -->
  <span onclick="this.parentElement.style.display='block'" class="closebtn">&times;</span>

  <!-- Expanded image -->
  <img id="expandedImg" style="width:100%" src="./resources/images/gallery/1.jpg">

  <!-- Image text -->
  <div id="imgtext"></div>
</div>
</div>

<div class="top_donors">
	<p style="font-family: 'monospace'; font-size: 50px;">TOP SPONSORS</p>
	<marquee behavior="scroll" direction="left" scrollamount="10" style="text-align: justify;">
		<img src="./resources/images/top_donors/1.png" alt="1" class="sponsor_image">
		<img src="./resources/images/top_donors/2.png" alt="2" class="sponsor_image">
		<img src="./resources/images/top_donors/3.png" alt="3" class="sponsor_image">
		<img src="./resources/images/top_donors/4.png" alt="4" class="sponsor_image">
		<img src="./resources/images/top_donors/5.png" alt="5" class="sponsor_image">
		<img src="./resources/images/top_donors/6.png" alt="6" class="sponsor_image">
	</marquee>
</div>

	<script src="./resources/js/jquery.min.js"></script>
	<script src="./resources/js/jquery.easing.1.3.js"></script>
	<script src="./resources/js/bootstrap.min.js"></script>
	<script src="./resources/js/jquery.waypoints.min.js"></script>
	<script src="./resources/js/jquery.countTo.js"></script>
	<script src="./resources/js/main.js"></script>


	</body>
</html>


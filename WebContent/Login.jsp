<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Login</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="css/agency.min.css" rel="stylesheet">
  
   <!-- Custom Scripts -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="./js/login.js"></script>
  

</head>

<body id="page-top">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="HomePage.jsp"><img src="logo.svg" alt="Vultures Logo" class="navbar-brand js-scroll-trigger" href="HomePage.jsp"></a>
    </div>
  </nav>
  
   
  </section>

  <!-- Form -->
  <section class="page-section" id="Login">
  	<form id="login" name="login" method = "POST" action="TodaysDeals.jsp">
	    <div class="container">
	      <div class="row">
	        <div class="col-lg-12 text-center">
	          <h2 class="section-heading text-uppercase">Login</h2>
	          <h3 class="section-subheading text-muted">Login to your Vultures account</h3>
	        </div>
	      </div>
	      <div class="row">
	        <div class="col-lg-12">
	          <form id="contactForm" name="sentMessage" novalidate="novalidate">
	            <div class="row">
	              <div class="col-md-6">
	                <div class="form-group">
	                  <input class="form-control" id="name" type="text" placeholder="Username *" required="required" data-validation-required-message="Please enter your name.">
	                  <p class="help-block text-danger"></p>
	                </div>
	                <div class="form-group">
	                	User Type : 
		                <select onchange="changeAction()" id="dropdown" name = "Age">
							<option value="1"> Customer </option>
							<option value="2"> Restaurant </option>
				  		</select>
	                  <p class="help-block text-danger"></p>
		            </div>
	                
	              </div>
	              <div class="col-md-6">
	                <div class="form-group">
	                  <input class="form-control" id="password" type="password" placeholder="Password *" required="required" data-validation-required-message="Please enter a Password.">
	                  <p class="help-block text-danger"></p>
	                </div>
		                
	              </div>
	              <div class="clearfix"></div>
	              <div class="col-lg-12 text-center">
	                <div id="success"></div>
	            			    <button id="sendMessageButton" class="btn btn-primary btn-xl text-uppercase" type="submit">Login</button>
	              </div>
	              <p id="error-text"></p>
	            </div>
	          </form>
	        </div>
	      </div>
	    </div>
	</form>
  </section>
  
  <script>
  function changeAction() {
	var type = document.getElementById("login").dropdown.value;
	console.log(type);
	if (type == 1)
		document.getElementById("login").action = "TodaysDeals.jsp";
	else 
		document.getElementById("login").action = "ScheduledDeals.jsp";
	
	}
  </script>
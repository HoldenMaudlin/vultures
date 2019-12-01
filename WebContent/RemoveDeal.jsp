<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Today's Deals</title>

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

	<style>
	#myTable {
		width: 100%;
		padding-bottom: 5%;
  		padding-top: 5%;
  		border-collapse: separate;
	}
	#pastOrders {
		text-decoration: underline;
		margin-left: auto;
		margin-right: 0;
	}
	#removeDeal{
	text-decoration: underline;
	margin-left: 615px;
	
	}
	#logOut {
		text-decoration: underline;
		margin-left: 30px;
		margin-right: 0;
	}
	.firstCol {
		width: 15%;
		border: 1px solid black;
		background-color: #5bc8b3;
		font-weight: bold;
		color: white;
		text-align: center;
		position: relative;
		right: 200px;
	}
	.remove{
		width: 20%;
		height: 70px;
		border: 1px solid black;
		background-color: #5bc8b3;
		font-weight: bold;
		color: white;
		text-align: center;
		position: relative;
		left: 400px;
	
	}
	.break {
		height: 40px;
		padding: 0px;
		margin: 0px;
		border: 0;
	}
	.space {
		border: 1px solid white;
		width: 4%;
		position: relative;
		right: 200px;
		
	}
	.td {
		border: 1px solid black;
		width: 15%;
  		position: relative;
  		padding-bottom: 5%;
  		padding-top: 5%;
  		margin: 20px;
  		text-align: center;
  		right: 200px;
	}
	.tr {
		margin: 50px;
		text-align: center;
		vertical-align: middle;
	}
	.select{

	}
	</style>

</head>



<body id="page-top">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
    	<a class="navbar-brand js-scroll-trigger" href="HomePage.jsp"><img src="logo.svg" alt="Vultures Logo" class="navbar-brand js-scroll-trigger" onclick="window.location.href = 'HomePage.jsp';"></a>
		<a id="removeDeal" onclick="window.location.href = 'RemoveDeal.jsp';">Remove Deal</a> 
		<a id="pastOrders" onclick="window.location.href = 'AddDeal.jsp';">Add Deal</a>
		<a id="logOut" onclick="window.location.href = 'HomePage.jsp';">Log Out</a>
    </div>
  </nav>
  
  <!-- Table of past orders -->
  <section class="page-section">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-center">
          <h2 class="section-heading text-uppercase">Remove Deal</h2>
        </div>
        <!-- TO DO: Fetch this information from current logged in user's database of orders -->
      </div>
		<table id="myTable">
		  <tr>
		  	<td> <input type= "radio" name= "checked" class= "select" id= 0 value= "false" onclick= "changeVal(id)"/></td>
		    <td class="firstCol">Coffee</td>
		    <td class="space"></td>
		    <td class="td">$1</td>
		    <td class="space"></td>
		    <td class="td">9:00 PM 11/26</td>
		    <td class="space"></td>
		    <td class="td">10:00 PM 11/26</td>
		  </tr>

		  <tr>
		  	<td> <input type= "radio" name= "checked" class= "select" id= 1 value= "false" onclick= "changeVal(id)"/></td>
		    <td class="firstCol">Donut</td>
		    <td class="space"></td>
		    <td class="td">$2</td>
		    <td class="space"></td>
		    <td class="td">9:00 PM 11/27</td>
		    <td class="space"></td>
		    <td class="td">11:00 PM 11/27</td>
		  </tr>

		  <tr>
		  	<td> <input type= "radio" name= "checked" class= "select" id=2 value= "false" onclick= "changeVal(id)"/></td>
		  	<td class="firstCol">Latte</td>
		    <td class="space"></td>
		    <td class="td">$3</td>
		    <td class="space"></td>
		    <td class="td">9:00 PM 11/27</td>
		    <td class="space"></td>
		    <td class="td">11:00 PM 11/27</td>
		 </tr>
		</table>
		<button class= "remove" onclick="return remove();">
			Remove
		</button>
    </div>
  </section>
  
  <!-- TO DO: Removing the deal from the database as well -->
  <!-- Removes item from table -->
  <script>
  function remove(){

	  if(document.getElementById(0).value == "true"){
		  document.getElementById("myTable").deleteRow(0);
		  document.getElementById(1).id--;
		  document.getElementById(2).id--;
	  }
	  
	  else if(document.getElementById(1).value == "true"){
		  document.getElementById("myTable").deleteRow(1);  
		  document.getElementById(2).id--;
	  }
	  
	  else if(document.getElementById(2).value == "true"){
		  document.getElementById("myTable").deleteRow(2);  
	  }  
  }
  function changeVal(id){
	  document.getElementById(id).value = "true";
  }
  </script>
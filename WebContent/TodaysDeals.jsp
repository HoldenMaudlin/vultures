<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vultures.DatabaseDriver"%>
<%@ page import="vultures.Deal" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
DatabaseDriver dd = new DatabaseDriver();
dd.initConnection();
List<Deal> deals = new ArrayList<Deal>();
deals = dd.getAllDeals();
pageContext.setAttribute("deals", deals);
int id = Integer.parseInt(String.valueOf(session.getAttribute("userId")));
pageContext.setAttribute("userID", id);
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Past Orders</title>
	
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
  <script src="./js/order.js"></script>

	<style>
	#dealsTable {
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
	}
	.lastCol {
		border: 1px solid white;
		width: 19%;
  		position: relative;
  		padding-bottom: 5%;
  		padding-top: 5%;
  		margin: 20px;
  		text-align: center;
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
	}
	.td {
		border: 1px solid black;
		width: 15%;
  		position: relative;
  		padding-bottom: 5%;
  		padding-top: 5%;
  		margin: 20px;
  		text-align: center;
	}
	.tr {
		margin: 50px;
		text-align: center;
		vertical-align: middle;
	}
	</style>
</head>


<body id="page-top">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
    	<a class="navbar-brand js-scroll-trigger" href="HomePage.jsp"><img src="logo.svg" alt="Vultures Logo" class="navbar-brand js-scroll-trigger" onclick="window.location.href = 'HomePage.jsp';"></a>
		<a id="pastOrders" onclick="window.location.href = 'PastOrders.jsp';">Past Orders</a> 
		<a id="logOut" onclick="window.location.href = 'HomePage.jsp';">Log Out</a>
    </div>
  </nav>

  <!-- Table where users order from -->
  <section class="page-section">
	    <div class="container">
	        <div class="row">
	          <div class="col-lg-12 text-center">
	            <h2 class="section-heading text-uppercase">Today's Deals</h2>
	          </div>
	        </div>
			<table id="dealsTable">
			<c:forEach items="${deals}" var="deal">
			  <tr id="${deal.dealID}">
			  	<td class="firstCol">${deal.restaurantName}</td>
			    <td class="space"></td>
			    <td class="td" >${deal.name}</td>
			    <td class="space"></td>
			    <td class="td">$${deal.price}</td>
			    <td class="space"></td>
			    <td class="td">${deal.startTime}</td>
			    <td class="space"></td>
			    <td class="lastCol">  
			    	<button id="button-${deal.dealID}" class="btn btn-primary text-uppercase" onclick="order(${deal.dealID}, ${userID})">Order Now</button>  
			    </td>
			  </tr>
			  
			  <tr class="break"><td colspan="9"></td></tr>
			 </c:forEach>
			</table>
	    </div>
  </section>
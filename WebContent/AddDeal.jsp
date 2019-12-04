 <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
    	<a class="navbar-brand js-scroll-trigger" href="HomePage.jsp"><img src="logo.svg" alt="Vultures Logo" class="navbar-brand js-scroll-trigger" onclick="window.location.href = 'HomePage.jsp';"></a>
		<!-- <a id="removeDeal" onclick="window.location.href = 'RemoveDeal.jsp';">Remove Deal</a>  -->
		<a id="pastOrders" onclick="window.location.href = 'AddDeal.jsp';">Add Deal</a>
		<a id="logOut" onclick="window.location.href = 'HomePage.jsp';">Log Out</a>
    </div>
  </nav>
  
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
  <script src="./js/addDeal.js"></script>

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
	}
	.break {
		height: 40px;
		padding: 0px;
		margin: 0px;
		border: 0;
	}
	.add{
		width: 15%;
		height: 50px;
		border: 1px solid black;
		background-color: #5bc8b3;
		font-weight: bold;
		color: white;
		text-align: center;
		position: relative;
		left: 475px;
		top: 110px;
	
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
	
	.textbox1{
	width: 50%;
	position: relative;
	top: 20px;
	}
	.textbox2{
	width: 50%;
	position: relative;
	top: 40px;
	}
	.textbox3{
	width: 50%;
	position: relative;
	top: 60px;
	
	}
	.textbox4{
	width: 50%;
	position: relative;
	top: 80px;;
	}
	</style>
  
<!-- TODO: Access login information via cookies/session -->
  <section class="page-section">
    <div class="container">
      <div class="row">
      	<form id="addDeal" action="AddDeal.jsp">
	        <div class="col-lg-12 text-center">
				<h2 class="section-heading text-uppercase">Add Deal</h2>
				<input id="name" type="text" class= "textbox1" value="Food Name"></input> 
				<input id="start" type="datetime-local" class= "textbox2" value="Start Time"></input> 
				<input id="end"  type="datetime-local" class= "textbox3" value="End Time"></input> 
				<input id="price" type="text" class= "textbox4" value="Price"></input> 
				<input type="hidden" id="restaurantId" value="${sessionScope.userId}" />
			</div>
			<button class="add" type="submit"> Add </button>
		</form>
	  </div>
   </div>
 </section>
 
 <!--  TO DO: Functionality for adding deal to database -->


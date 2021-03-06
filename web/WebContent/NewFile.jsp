<%@page import="com.infy.bean.User"%>
<%@page import="com.infy.business.service.UserServiceImpl"%>
<%@page import="com.infy.business.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="style.css">

<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/angular.js"></script>
<script src="js/angular-route.js"></script>
<link rel="stylesheet" href="bootstrap.css">

<meta charset="ISO-8859-1">

<title>Insert title here</title>

<script type="text/javascript">
	var application = angular.module('Application', [ "ngRoute" ]);
	application
			.controller(
					'bookingcontroller',
					function($scope, $http) {

						$scope.fetch = function() {

							productid = document.getElementById("ProductId").value
$scope.$emit('LOAD')
							$http
									.get(
											'http://localhost:8050/web/api/Products/'
													+ productid)
									.then(
											function(response) {
												$scope.product = response.data;
											$scope.$emit('UNLOAD')
												document
														.getElementById("message").innerHTML = null;

											},
											function() {

												document
														.getElementById("message").innerHTML = "Resource not found";
											$scope.$emit('UNLOAD')
											});
						}
							
							$scope.fetch2 = function() {

								
								$scope.$emit('LOAD')
								$http
										.get(
												'http://localhost:8050/web/api/customer/allcustomer')
										.then(
												function(response) {
													$scope.customer = response.data;
													
													
													
													$scope.$emit('UNLOAD')
													document
															.getElementById("message").innerHTML = null;

												},
												function() {

													document
															.getElementById("message").innerHTML = "Resource not found";
													$scope.$emit('UNLOAD')
												});

						}
						$scope.fetch1 = function() {

						
							$scope.$emit('LOAD')
							$http
									.get(
											'http://localhost:8050/web/api/Products/getallproduct'
													)
									.then(
											function(response) {
												$scope.product1 = response.data;
												$scope.$emit('UNLOAD')
												document
														.getElementById("message").innerHTML = null;

											},
											function() {

												document
														.getElementById("message").innerHTML = "Resource not found";
												$scope.$emit('UNLOAD')
											});

						}

						$http
								.get("sexlist.txt")
								.then(
										function(response) {
											$scope.sexlist = response.data;
										},
										function() {

											document.getElementById("message").innerHTML = "Resource not found";

										});

						$http
								.get("data1.json")
								.then(
										function(response) {
											$scope.data1 = response.data;
										},
										function() {
											document.getElementById("message").innerHTML = "Resource not found";

										});

						$http
								.get("countrylist.txt")
								.then(
										function(response) {
											$scope.countrylist = response.data;
										},
										function() {
											document.getElementById("message").innerHTML = "Resource not found";

										});

						$scope.form1 = {};
						$scope.form1.userName= null;
						$scope.form1.userId = null;
						$scope.form1.userRole = null;
						$scope.form1.password = null;
						$scope.form1.email = null;
						$scope.form1.mobileNumber = null;
						$scope.form1.dateOfBirth = {};
						$scope.form1.dateOfBirth.year=null;
						$scope.form1.dateOfBirth.month=null;
						$scope.form1.dateOfBirth.dayOfMonth=null;
						$scope.form1.dateOfBirth.hourOfDay=null;
						$scope.form1.dateOfBirth.minute=null;
						$scope.form1.dateOfBirth.second=null;
						$scope.form1.address = null;
						$scope.form1.gender= null;
						$scope.form1.userType = null;
						$scope.form1.userStatus = null;
						
						$scope.dateOfBirth1=null;
						
						$scope.form1.submit = function() {
							
							console.log($scope.form1);
							$scope.form1.dateOfBirth.year=$scope.dateOfBirth1.getFullYear();
							$scope.form1.dateOfBirth.month=$scope.dateOfBirth1.getMonth();	
							$scope.form1.dateOfBirth.dayOfMonth=$scope.dateOfBirth1.getDate();
							$scope.form1.dateOfBirth.hourOfDay=$scope.dateOfBirth1.getHours();
							$scope.form1.dateOfBirth.minute=$scope.dateOfBirth1.getMinutes();
							$scope.form1.dateOfBirth.second=$scope.dateOfBirth1.getSeconds();
							
							var data =angular.toJson($scope.form1);
								
							$http.post('http://localhost:8050/web/api/Products' +'/adduser',data ).then(function(response){
								alert("ADDED USER_ID-" + response.data)
								document.getElementById("message").innerHTML = response.data;
								
							},function(response){
								document.getElementById("message").innerHTML = "Resource not found";;

							});
							

						};

					}

			);

	

	function myform() {
		var xmlhttp;
		var name = document.getElementById("uname").value;

		if (window.XMLHttpRequest) {
			var xmlhttp = new XMLHttpRequest();
		} else {
			var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var userName = xmlhttp.responseText;

				var userNameSplit = userName.split(",");

				var today = new Date();

				for (i = 0; i < userNameSplit.length; i++) {
					var userNameSplit1 = userNameSplit[i].split("-");
					if (name.toUpperCase() == userNameSplit1[0].toUpperCase()) {

						alert(document.getElementById("message").innerHTML = "Username already exists");

						alert(document.getElementById("address").value = userNameSplit1[1]);

					} else {
						continue;
					}

				}

			}
		}

		xmlhttp.open("GET", "demo.txt", false);
		xmlhttp.send();

	}
	application.config([ '$routeProvider', function($routeProvider) {
		$routeProvider.when('/data1', {
			templateUrl : 'data1.html'
		}).when('/data2', {
			templateUrl : 'data2.html'
		}).when('/data3', {
			templateUrl : 'data3.html'
		}).when('/data4', {
			templateUrl : 'data4.html'
		}).otherwise({
			redirectto : '/'
		});

	} ]);
	
	application.controller('loadcontroller',['$scope' ,function($scope){
		$scope.$on('LOAD',function(){$scope.loader=true});
		$scope.$on('UNLOAD',function(){$scope.loader=false});
	}]);
</script>
</head>
<body ng-app="Application" ng-controller="loadcontroller">

<%
String user = null;
String usern=(String)session.getAttribute("uName");
if(usern==null){

	response.sendRedirect("Signin.html");
    return;
}
else user = (String) session.getAttribute("uName");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
 %>

	<div class="container-fluid" ng-controller="bookingcontroller">
<div ng-show="loader" ><div class ="loader" ></div></div>
		<h1 align="center">Customer Registration</h1>


		<nav class="navbar navbar-default">

			<div class="navbar-header">
				<a href="#" class="navbar-brand">ASquareJ</a>
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#mycollapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

			</div>
			<div class="collapse navbar-collapse" id="mycollapse">
				<ul class="nav navbar-nav ">
<li class="active"><a href="#">Home</a></li>
					<% 
							UserService service= new UserServiceImpl();
				User user2=	service.findUser(usern);
						if(user2.getUserRole().name().equals("ADMIN")){ 
						%>
						
						
						<li><a href="#data3"><button class="search1" ng-click="customer=fetch2()">Customer</button></a></li>
						<li><a href="#data4" >SIGN UP </a></li>
						<% } %>
					
					<li><a href="#data1"><button class="search1" ng-click="product1=fetch1()">All Products</button></a></li>
					

					<li>
						<form class="form-inline mr-auto">
							<input class="search form-control" type="number"
								ng-model="pruductid" id="ProductId"
				name="pruductid" placeholder="Search" aria-label="Search">&nbsp;
						<a href="#data2"><button class="submit"
								type="submit" ng-click="product=fetch()"></button></a>
						</form>
					</li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Careers</a></li>
					<li><a href="#">About us </a></li>
					<li><a href="logout">Logout</a></li>
				</ul>
			</div>



		</nav>
		
		<div class="col-lg-6 col-lg-offset-2 " style="color: black;">
					
				<div  ng-view></div>


			</div>

		
		<div id="message" style="color: blue; font-weight: bolder;"></div>
	</div>

</body>
</html>
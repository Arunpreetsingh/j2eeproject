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

							$http
									.get(
											'http://localhost:8030/web/api/Products/'
													+ productid)
									.then(
											function(response) {
												$scope.product = response.data;
												document
														.getElementById("message").innerHTML = null;

											},
											function() {

												document
														.getElementById("message").innerHTML = "Resource not found";

											});
						}
							
							$scope.fetch2 = function() {

								

								$http
										.get(
												'http://localhost:8030/web/api/customer/allcustomer')
										.then(
												function(response) {
													$scope.customer = response.data;
													document
															.getElementById("message").innerHTML = null;

												},
												function() {

													document
															.getElementById("message").innerHTML = "Resource not found";

												});

						}
						$scope.fetch1 = function() {

						

							$http
									.get(
											'http://localhost:8030/web/api/Products/getallproduct'
													)
									.then(
											function(response) {
												$scope.product1 = response.data;
												document
														.getElementById("message").innerHTML = null;

											},
											function() {

												document
														.getElementById("message").innerHTML = "Resource not found";

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
						$scope.form1.name = null;
						$scope.form1.address1 = null;
						$scope.form1.sextype1 = null;
						$scope.form1.country = null;

						$scope.form1.age = null;

						$scope.form1.submit = function() {

							alert("NAME-" + $scope.form1.name + "ADDRESS-"
									+ $scope.form1.address1 + "SEX-"
									+ $scope.form1.sextype1 + "AGE-"
									+ $scope.form1.age + "COUNTRY-"
									+ $scope.form1.country);

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
		$routeProvider.when('/countries', {
			templateUrl : 'Countries.html'
		}).when('/data1', {
			templateUrl : 'data1.html'
		}).when('/data2', {
			templateUrl : 'data2.html'
		}).when('/data3', {
			templateUrl : 'data3.html'
		}).otherwise({
			redirectto : '/'
		});

	} ]);
	
	
</script>
</head>
<body ng-app="Application">
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
						
						if(usern.equals("A101")){ 
						%>
						<li><a href="#data1"><button class="search1" ng-click="product1=fetch1()">All Products</button></a></li>
						
						<% } %>
					
					<li><a href="#data3"><button class="search1" ng-click="customer=fetch2()">Customer</button></a></li>
					<li><a href="#countries">Details You Entered </a></li>

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

		<form ng-submit="form1.submit();">

			<div class="col-lg-3 col-lg-offset-2" style="color: black;">
					
				<div  ng-view></div>


			</div>


			<div align="center" class="col-lg-5 col-lg-offset-2 container-fluid">




				<div class="container-fluid">



					<div align="left" class="form-group">
						<p class="text-left" style="font-weight: bolder;">Name</p>
						<input class="text-left form-control" type="text"
							required="required"
							oninvalid="setCustomValidity('naam jruri aa prna');"
							pattern="[a-zA-Z]+" placeholder="Enter Name" name="Name"
							id="uname" ng-model="form1.name" onchange="myform();">
					</div>




					<div align="left" class="form-group">
						<p class="text-left" style="font-weight: bolder;">Address</p>
						<input ng-model="form1.address1" name="address1"
							class="text-left form-control" id="address" type="text">

					</div>
				


					<div class="form-group">
						<p class="text-left" style="font-weight: bolder;">Sex</p>
						<label ng-repeat="k in sexlist" class="radio-inline"> <input
							type="radio" ng-model="form1.sextype1" ng-value="k"
							name="sextype1" required="required"> <span
							style="font-weight: bolder;">{{k}}</span><br>
					</div>
					</label>
					
					<div class="form-group">
						<p class="text-left" style="font-weight: bolder;">Age</p>

						<input type="number" min="18" max="25" name="age"
							class="form-control" ng-model="form1.age" required="required">

					</div>
					



					<div align="left" class="form-group" countrylist=[ng-init=
						"countrylist.txt"]>
						<p class="text-left" style="font-weight: bolder;">Country</p>
						<select class="form-control" name="country"
							ng-model="form1.country" ng-value="country">
							<option>--select--</option>
							<option ng-repeat="country in countrylist">{{country}}</option>

						</select>
					</div>

					<div align="center" class="form-group">
						<input class=" btn btn-success" type="submit" value="Submit">

					</div>

					<div align="center" class="form-group">
						<input class=" btn btn-success" type="reset">
					</div>


				</div>

				<div id="message" style="color: blue; font-weight: bolder;"></div>


			</div>






		</form>
		
	</div>

</body>
</html>
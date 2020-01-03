<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<link rel="stylesheet" href="/resources/css/style.css">

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="ISO-8859-1">

</head>
<body>
	<nav class="navbar navbar-inverse">
		<a class="active" href="">Home</a>
		<div class="container-fluid">
			<div class="navbar-header" header="welcome">
				<a class="navbar-brand"></a>
			</div>
		</div>
	</nav>

	<div class="wrapper">
		<!-- Sidebar -->
		<nav id="sidebar">
			<div class="container">
				<img
					src="${pageContext.request.contextPath}/resources/images/images.png"
					 alt="Norway" style="width: 100%;">


				<!-- 	<ul class="list-unstyled components">
				<p>Actions</p>

			</ul> -->
				<div class="top-left">
					<input type="button" class="btn btn-primary"
						onclick="location.href='/addBlockpage'" value="RegisterBlock"><br><br>

					<input type="button" class="btn btn-primary"
						onclick="location.href='/addshopepage'" value="RegisterShopes"><br><br>
					<input type="button" class="btn btn-primary"
						onclick="location.href='/adddishpage'" value="Register dishes"><br><br>
					<input type="button" class="btn btn-primary"
						onclick="location.href='/getallshop'"
						value="View All
						Shopes"><br><br>

					<!-- <button type = "submit" value = "class" onclick = "form.action = 'addBlockpage';">RegisterBlock</button>
				<li><a href="addBlockpage" style="font-size: 1.2em">Register
						Block</a></li>
				<br>
				
				
				
				<li><a href="addshopepage" style="font-size: 1.2em">Register
						Shopes</a></li>
				<br>
				<li><a href="adddishpage" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle"
					style="font-size: 1.2em">Register dishes</a></li>
				<br>
				<li><a href="getallshops" style="font-size: 1.2em">View All
						Shopes</a></li>

				
			</ul> -->
				</div>

			</div>
		</nav>






	</div>
</body>
</html>
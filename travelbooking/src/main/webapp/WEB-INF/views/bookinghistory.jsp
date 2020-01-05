<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
	<br>
	<br>
	<br>
<div class = "container">
<div class = "jumbotron">

	
	
	Booking Succesfull<br>
	Total price is: "${price}"

	<br>
	<br>
	<br>
	<br>

	<a href="http://localhost:8086">Back</a>
	</div>
	</div>
<%-- 	<div class= "container">
  <img class="img-responsive"src="${pageContext.request.contextPath}/images/image2.jpg"  style="width:80%;">
  </div> --%>
</body>
</html>
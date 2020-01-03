
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script type="text/javascript" src="/resources/js/validate.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/style.css">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-12">
		<table class=" table table-bordered">
			<thead class="thead-dark">
				<tr>
					
					<th scope="col">Dish ID</th>
					<th scope="col">Dish Name</th>
					<th scope="col">Dish Type</th>

					<th scope="col">Price</th>

				</tr>
			</thead>
			<tbody>
				<tr>

					<c:forEach var="dishDtos" items="${dishDtos}">
						<tr>
							
							<td>${dishDtos.dishId}</td>
							<td>${dishDtos.dishName}</td>
							<td>${dishDtos.dishType}</td>
							<td>${dishDtos.price}</td>
							




						</tr>
					</c:forEach>



				</tr>



			</tbody>
		</table>


	

		<br>


	</div>

	<a href="http://localhost:8086/getallshops">Back</a>
</body>
</html>
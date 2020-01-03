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
	<br>
	
	<div class="form-group">
	<form action = "getshopbyblockname" method = "GET">
		<label class="control-label col-sm-2" for="shopname">select
			One Block </label>
		<div class="col-sm-10">
			<select name="kallingaBlockName">
				<c:forEach var="kallingaBlockDtos" items="${kallingaBlockDtos}">
					<tr>
						<td>
							<option value="${ kallingaBlockDtos.getKallingaBlockName()}"
								name="kallingaBlockName" id="kallingaBlockName">${ kallingaBlockDtos.getKallingaBlockName()}</option>
						</td>
					</tr>
				</c:forEach>
			</select>
		</div>
		</form>
	</div>
	
	<c:if test="${ shopDtos!=null}">

		<div class="col-md-12">
			<table class=" table table-bordered">
				<thead class="thead-dark">
					<tr>
						<th>Select</th>
						<th scope="col">Shop ID</th>
						<th scope="col">Shop Name</th>
						<th scope="col">ShopType</th>

						<th scope="col">Rating</th>

					</tr>
				</thead>
				<tbody>
					<tr>

						<c:forEach var="shopDtos" items="${shopDtos}">
							<tr>
								<td>${shopDtos.kallingaShopId}</td>
								<td>${shopDtos.kallingaShopName}</td>
								<td>${shopDtos.kallingaShopType}</td>
								<td>${shopDtos.rating}</td>
								<td><a href="showdishes">Show Dishes</a></td>




							</tr>
						</c:forEach>



					</tr>



				</tbody>
			</table>


			<button type="submit" id="submit" class="btn btn-default">Click
				anyone</button>

			<br>


		</div>

		</form>
	</c:if>
	</form>
	</div>






	<a href="http://localhost:8086">Back</a>
	</div>
	< /div>
	</div>
	</div>

</body>
</html>
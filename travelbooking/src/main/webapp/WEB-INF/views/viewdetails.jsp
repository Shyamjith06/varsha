<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/additional-methods.min.js"
	integrity="sha256-vb+6VObiUIaoRuSusdLRWtXs/ewuz62LgVXg2f1ZXGo="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/validate.js"></script>
	<script>
	$(document).ready(function(){
		  $("#submit").click(function(){
		    $("#table1").fadeIn("3000");
		  });
		});
	</script>
</head>
<body style="background-color: bisque">
	<br>
	<br>
	<div class = "container">
	<div class="jumbotron">
		<form action="/bookingdetails" class="registrationformstudent"
			method="post" id="myForm">
			<div class="container" >

				<div class="form-group" style="width: 800px; margin: auto">
					<div class="row">
						<div class="col-md-4">
							<label class="control-label col-sm-2" for="type">Select One
							</label>
							<div class="well">
								<!-- <select name="userName" id="userName" onchange="document.getElementById('myForm').submit()"> -->
								<select name = "userName" id = "userName">
									<option value="">Select</option>
									<c:forEach var="userDto" items="${userDtos}">
										<option value="${userDto.userName}">${userDto.userName}</option>
									</c:forEach>
								</select>
							</div>
						</div>

					</div>
				</div>




				<div class="form-group" style="width: 800px; margin: auto">
					<div class="row">
						<div class="col-md-4">
							<div class="well">
								<label>Source</label> <input type="Date" class="form-control"
									id="fromDate" name = "fromDate">

							</div>
						</div>


					</div>

				</div>
				
				<button type="submit" id="submit" 
					value="submit">Submit</button>
				
			</div>
		</form>
	</div>
	</div>

 	<c:if test="${bookingDtos !=null }"> 



		<table class=" table table-bordered" allign="center" id = "table1">
			<thead class="thead-dark">
				<tr>


					<th scope="col">User Name</th>
					<th scope="col">Travelling To</th>
					<th scope="col">Travelling From</th>
					<th scope="col">Price</th>
					<th scope="col">Update</th>



				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="bookingDtos" items="${bookingDtos}">
						<tr>
							<td>${bookingDtos.getUser().getUserName()}</td>
							<td>${bookingDtos.bookingFrom}</td>
							<td>${bookingDtos.bookingTo}</td>
							<td>${bookingDtos.price}</td>
							<td><a href="update/${bookingDtos.bookingId}">Update</a></td>
							

						</tr>


					</c:forEach>
					
			</tbody>
		</table>
 	</c:if> 

	<br>


	<button><a href="/">Back</a></button>

</body>
<script>
	$.validator.addMethod("fromDate", function(value, element) {
		var curDate = new Date();
		var inputDate = new Date(value);
		if (inputDate >= curDate)
			return true;
		return false;
	}, "Invalid Date!");
	$('form').validate({
		rules : {
			userName : {
				required : true,

			},
			fromDate : {
				required : true,
				fromDate : true

			},
		},

	});
</script>
</html>
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
</head>
<body style="background-color: bisque">
	<br>
	<br>

	
		<form action="/book" class="registrationformstudent" method="post">
			<div class="container" style="background-color: lightbrown">

				<div class="form-group" style="width: 800px; margin: auto">
					<div class="row">
						<div class="col-md-4">
							<label class="control-label col-sm-2" for="type">selectOne
							</label>
							<div class="well">
								<select name="userName" id="userName">
									<option value="">SELECT</option>
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
								<label>From </label> <input type="text" class="form-control"
									id="bookingFrom" name="bookingFrom">

							</div>
						</div>


					</div>

				</div>
				<div class="form-group" style="width: 800px; margin: auto">
					<div class="row">
						<div class="col-md-4">
							<div class="well">
								<label>To</label> <input type="text" class="form-control"
									id=bookingTo name="bookingTo">

							</div>
						</div>


					</div>

				</div>
				<div class="form-group" style="width: 800px; margin: auto">
					<div class="row">
						<div class="col-md-4">
							<div class="well">
								<label>Date of Journey</label> <input type="Date"
									class="form-control" id="dateOfJourney" name="dateOfJourney">

							</div>
						</div>


					</div>

				</div>
				<div class="form-group" style="width: 800px; margin: auto">
					<div class="row">
						<div class="col-md-4">
							<div class="well">
								<label>Distance</label> <input type="text" class="form-control"
									id="distance" name="distance">

							</div>
						</div>


					</div>

				</div>
				<div class="form-group" style="width: 800px; margin: auto">
					<div class="row">
						<div class="col-md-4">

							<label>Food Preferences: </label>
							<div class="radio">
								<label><input type="radio" id="foodType" name="foodType"
									value="Vegetarian">Vegetarian</label>
							</div>
							<div class="radio">
								<label><input type="radio" id="foodType" name="foodType"
									value="Non-Vegetarian">Non-Vegetaria</label>
							</div>





						</div>


					</div>

				</div>
				<div class="form-group" style="width: 800px; margin: auto">
					<div class="row">
						<div class="col-md-4">

							<label>Travelling With:   </label> <label class="checkbox-inline"><input
								type="checkbox" name="modeOfTravelling" value="Visa">Visa</label>
							<label class="checkbox-inline"><input type="checkbox"
								id="modeOfTravelling" name="modeOfTravelling" value="Passport">Passport</label>


							<!-- <input type="checkbox" class="form-control"
									id="modeOfTravelling" name="modeOfTravelling" value = "Visa">Visa
									<input type="checkbox" class="form-control"
									id="modeOfTravelling" name="modeOfTravelling" value = "Passport">Passport -->


						</div>


					</div>

				</div>
				<button type="submit" id="submit" value="submit">Book</button>

				<button>
					<a href="http://localhost:8086">Back</a>
				</button>
			</div>
		</form>
	</div>
</body>
<script>
$.validator.addMethod("dateOfJourney", function(value, element) {
	var curDate = new Date();
	var inputDate = new Date(value);
	if (inputDate >= curDate)
		return true;
	return false;
}, "Invalid Date!");
	$('form').validate({
		rules : {
			userName : {
				required : true
			},
			dateOfJourney : {
				required : true,
				dateOfJourney: true
			},
			distance : {
				required : true
			},
			foodType : {
				required : true
			},
			modeOfTravelling : {
				required : true
			},
			bookingFrom : {
				required : true

			},
			bookingTo : {
				required : true

			},
			distance : {
				required : true
			},
		},

	});
</script>



</html>
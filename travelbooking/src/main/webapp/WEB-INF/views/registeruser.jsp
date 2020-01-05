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
<link rel="stylesheet" href="css/style.css">
</head>
<body style="background-color: bisque">
	<br>
	<br>
	<br>

	<div class="container">

		<div class="jumbotron">
			<form action="/adduser" class="registrationformstudent" method="post">
				<div class="container">

					<div class="form-group" style="width: 800px; margin: auto">
						<div class="row">
							<div class="col-md-4">
								<label>User Name</label>
								<div class="well">
									<input type="text" name="userName"
										placeholder="enter user name"></input>
								</div>
								<div id="result" style="color: red"></div>
							</div>

						</div>
					</div>




					<div class="form-group" style="width: 800px; margin: auto">
						<div class="row">
							<div class="col-md-4">
								<div class="well">
									<label>Age</label> <input type="number" class="form-control"
										id="age" name="age" placeholder=" age">
								</div>
							</div>


						</div>

					</div>

					<br>
					<br>


					<button type="submit" id="submit" value="submit">Submit</button>

					<button>
						<a href="/">Back</a>
					</button>
				</div>
			</form>
		</div>
	</div>
</body>
<script>
	$.validator.addMethod("alphabetnspace", function(value, element) {

		return this.optional(element)
				|| /^[a-zA-Z]+(\s{0,1}[a-zA-Z])*$/.test(value);

	}, "enter only characters including space");
	$('form').validate({
		rules : {
			userName : {
				required : true,
				alphabetnspace: true,
				maxlength : 20
			},
			
			age: {
				required : true,
				min :18
			},
		},

	});
</script>
</html>
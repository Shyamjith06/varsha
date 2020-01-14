<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body id="college">
	<div class="login-form">
		<form action="/addbank" method="post" name="form">

			<h2 class="text-center">Add Bank</h2>

			<div class="form-group">
				<label id="lb">Bank Name</label> <input type="text"
					class="form-control" name="bankName" id="bankName">
			</div>
			<div class="form-group">
				<label id="lb">Location</label> <input type="text"
					class="form-control" name="bankLocation" id="bankLocation">
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-lg btn-block">Add</button>
			</div>


		</form>

	</div>

</body>
<script>
	$.validator.addMethod("alphabetsnspace", function(value, element) {
		return this.optional(element) || /^[a-zA-Z ]*$/.test(value);

	});
	$('form').validate({
		rules : {
			bankName : {
				required : true,
				
				maxlength:12,
				alphabetsnspace : true,
			},
			bankLocation : {
				required : true

			}

		},
		messages : {
			"bankName" : {
				required : "Please enter bank name",
				alphabetsnspace : "Enter only letters",
			},
			"bankLocation" : {
				required : "Please enter valid location",
				alphabetsnspace : "Enter only letters",

			}
		}
	});
</script>
</html>
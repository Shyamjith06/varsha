
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> 
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/additional-methods.min.js"
	integrity="sha256-vb+6VObiUIaoRuSusdLRWtXs/ewuz62LgVXg2f1ZXGo="
	crossorigin="anonymous"></script>

</head>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<form class="registerblock" align = "center" action="/addblock" method="POST"
		 font-size="30px"; width: 50%;">
		<div class="container">
		<div class="jumbotron">
			<div class="row">
				<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
					<div class="form">
						<!--   <div class="form-group">
    <label class="control-label col-sm-2" for="blockname">Block Name:</label>
    <div class="col-sm-10"> -->
						<p align="center" ><font size="6">
							Enter BlockName: <span class="glyphicon glyphicon-home"></span>
						</font></p>
						<input  type="text" name="kallingaBlockName" class="form-control"
							id="blockname" placeholder="Enter block name" size="35">
					</div>
				</div>
			</div>
			<br><br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10"></div>
				<button type="submit" class="btn btn-default"><font size="3">SUBMIT</font></button>
				
				<a href="http://localhost:8086/ " style="font-size: 1.2em"><font size="3">BACK</font></a>
			</div>
		</div>
		</div>
	</form>





</body>
<script>
	$('form').validate({
		rules : {

			kallingaBlockName : {
				required : true,
				alphabetsonly : true
			},
		}

	});
</script>
</html>
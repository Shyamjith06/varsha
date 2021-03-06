<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="ISO-8859-1">
</head>
<body>
<form class="form-horizontal"id="registershopform" action="addshop" method = "POST">
  <div class="form-group">
    <label class="control-label col-sm-2" for="shopname">select One Block </label>
    <div class="col-sm-10">
    <select name = "kallingaBlockName">
    <c:forEach var = "kallingaBlockDtos" items = "${kallingaBlockDtos}">
    <tr>
    <td>
    <option value = "${ kallingaBlockDtos.getKallingaBlockName()}" name = "kallingaBlockName" id = "kallingaBlockName">${ kallingaBlockDtos.getKallingaBlockName()}</option>
    </td>
    </tr>
    </c:forEach>
    </select>
    </div>
   </div>
     <div class="form-group">
    <label class="control-label col-sm-2" for="kallingaShopName">Shop Name:</label>
    <div class="col-sm-10">
      <input type="text" name = "kallingaShopName"class="form-control" id="kallingaShopName" placeholder="Enter shop name" maxlength = "7">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="rating">Rating:</label>
    <div class="col-sm-10">
      <input type="number"  step=".01" name = "rating"class="form-control" id="rating" maxlength = "7" placeholder="Enter Rating" >
    </div>
  </div>
 
  
  <fieldset class="form-group">
    <div class="row">
      <label class="control-label col-sm-2" for="shopType">Choose One</label>
      <div class="col-sm-10">
        <div class="form-check">
          <input class="form-check-input" type="radio" name="kallingaShopType" id="gridRadios1" value="chineese" checked>
          <label class="form-check-label" for="gridRadios1">
            Chineese
          </label>
        </div>
        <div class="form-check">
          <input class="form-check-input" type="radio" name="kallingaShopType" id="gridRadios2" value="south">
          <label class="form-check-label" for="gridRadios2">
            South
          </label>
        </div>
        <div class="form-check ">
          <input class="form-check-input" type="radio" name="kallingaShopType" id="gridRadios3" value="north" >
          <label class="form-check-label" for="gridRadios3">
            North
          </label>
        </div>
      </div>
    </div>
  </fieldset>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</form>

<li><a href="http://localhost:8086/ " style="font-size: 1.2em">Back</a></li>


<script>
$(document).ready(function(){
	$("#registershopform").validate({
		rules:{
			
			
			kallingaShopName:{
				required: true,
			},
			rating:{
				required: true,
			},
			
			
		}
		
	});
	
});
</script>
</body>
</html>
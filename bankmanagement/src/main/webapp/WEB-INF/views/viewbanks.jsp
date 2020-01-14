<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table>

<c:forEach var="bank" items="${banks }">
<tr>
<td>Bank Name
</td>
<td>Balance
</td>
<tr>
<td>${bank.bankName}</td>
<td>${bank.balance }

</tr>
</c:forEach>
</table>

<a class="nav-link" href="http://localhost:8080/">Back
          </a>
</body>
</html>
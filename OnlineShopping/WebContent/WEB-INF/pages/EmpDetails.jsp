<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>EmpDetails</title>
</head>
<body>
	<h1>L&T Infotech</h1>
	<table>
		<tr>
			<th>Employee ID</th>
			<td>${emp.empId}</td>
		</tr>
		<tr>
			<th>FirstName</th>
			<td>${emp.firstName}</td>
		</tr>
		<tr>
			<th>LastName</th>
			<td>${emp.lastName}</td>
		</tr>
	</table>
	
	<a href="empList.hr">Go back to listwa</a> ||
	<a href="home.hr">Ghari jaa</a>
</body>
</html>
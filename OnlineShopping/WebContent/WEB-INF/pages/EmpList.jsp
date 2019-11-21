<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmpList</title>
</head>
<body>
<h1>Larson and Toubro Information Services</h1>
<table border="1">
<tr>
 <th> Employee_Id</th>
 <th>first_name</th>
 <!-- <th> last_name</th>
 <th> email</th>
 <th> hire_date</th>
 <th> job_id</th> -->
 <th>View Details</th>
 
</tr>

<c:forEach items="${empList}" var="emp">
<tr>
<td>${emp.empId}</td>
<td>${emp.firstName}</td>
<%-- <td>${emp.lastName}</td>
<td>${emp.mailId}</td>
<td>${emp.hireDate}</td>
<td>${emp.jobId}</td> --%>
<td><a href = "empDetails.hr?id=${emp.empId}">Ajun Bagha</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>
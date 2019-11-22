<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProductList</title>
</head>
<body>
<h1>SoleMates Products</h1>
<table border="1">
<tr>
 <th> Product_Id</th>
 <th>Product_name</th>
 <th>brand</th>
 <th>productPrice</th>
 <th>productDesc</th>
 <th>category</th>
 <th>productStatus</th>
 <th> quantity</th>
 <th>productImage</th>
 </tr>
 
 <c:forEach items="${productList}" var="prods">
 <tr>
 <td>${prods.productId }</td>
 <td>${prods.productName }</td>
 <td>${prods.brand }</td>
 <td>${prods.productPrice }</td>
 <td>${prods.productDesc }</td>
 <td>${prods.category }</td>
 <td>${prods.productStatus }</td>
 <td>${prods.quantity}</td>
 <td><img src="<c:url value="/resource/images/${prods.productId}.jpg"/>" width="40%" alt="${prods.productName}" /></td>
 </tr>
 </c:forEach>
 </table>
 <br><br>
</body>
</html>
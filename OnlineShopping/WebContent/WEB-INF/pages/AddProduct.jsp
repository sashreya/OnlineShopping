<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: #380B61;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 08px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password], input[type=number] {
  width: 100%;
  padding: 08px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus ,input[type=number]:focus{
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 10px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color:black;
  color: white;
  padding: 10px 10px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #380B61;
  color: #f9f9f9;
  text-align: center;
}
</style>
</head>
<body>

<form action="addProduct.shop" method="post">
  <div class="container">
    <h1>Add Product</h1>
    <p>Please fill in the required product details.</p>
    <hr>
    <label for="PRODUCTID"><b>Product Id</b></label>
    <input type="number" maxlength="10" placeholder="Enter your product ID" name="productId"  id="productId" required>

    <label for="PRODUCTNAME"><b>Product Name</b></label>
    <input type="text" maxlength="20" placeholder="Enter your product Name" name="productName"   id="productName"required>

    <label for="BRAND"><b>Brand</b></label>
    <input type="text" maxlength="20" placeholder="Enter your product Brand" name="brand"  id="brand" required>

    <label for="PRODUCTPRICE"><b>Product Price</b></label>
    <input type="number" maxlength="20" placeholder="Enter your product Price" name="productPrice"   id="productPrice"required>

    <label for="PRODUCTDESC"><b>Product Description</b></label>
    <input type="text" maxlength="90" placeholder="Enter your product Description" name="productDesc"   id="productDesc"required>

    <label for="CATEGORY"><b>Category</b></label>
    <input type="text" maxlength="20" placeholder="Enter your product Category" name="category"  id="category" required>

    <label for="PRODUCTSTATUS"><b>Product Status</b></label>
    <input type="text" maxlength="20" placeholder="Enter your product Status" name="productStatus"   id="productStatus"required>

    <label for="QUANTITY"><b>Quantity</b></label>
    <input type="number" maxlength="20" placeholder="Enter number of items" name="quantity"   id="quantity"required>
  
	<label for="productImage">Product Image</label>
	<input type="file" id="productImage"/>
 	 </div>

    <button type="submit" class="registerbtn" value="addProduct" >Add Product</button>
</form>
</body>
</html>
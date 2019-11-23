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


<script>

  function ValidateForm()
{
  var x=document.myForm.email.value;  
var atposition=x.indexOf("@");  
var dotposition=x.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
  alert("Please enter a valid e-mail address");  
  return false;  
  }  

  var password=document.getElementById("customerPassword").value;
        var confirmPassword=document.getElementById("ps2").value;
        if (password != confirmPassword) {
            alert("Password do not match.");
           return false;
        }
}


</script>

<form action="registration.shop" method="post" name="myForm" onsubmit="return ValidateForm()">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
    <label for="customerId"><b>Name</b></label>
    <input type="text" placeholder="Enter Your Id" name="customerId" id="customerId" required>
    
    <label for="customerName"><b>Name</b></label>
    <input type="text" placeholder="Enter Your Name" name="customerName" id="customerName" required>

    <label for="customerPhoneNumber"><b>Mobile Number</b></label><br>
    <input type="Number" placeholder="Enter Your Mobile Number" name="customerPhoneNumber" id="customerPhoneNumber" required><br>

    <label for="customerMail"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="customerMail" id="customerMail" required>

    <label for="customerAddress"><b>Address</b></label>
    <input type="text" placeholder="Enter Address" name="customerAddress" id="customerAddress" required>

    <label for="customerPassword"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="customerPassword" id="customerPassword" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" id="ps2" required>
    <hr>
    

    <button type="submit" class="registerbtn" >Register</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>
</form>


</body>
</html>
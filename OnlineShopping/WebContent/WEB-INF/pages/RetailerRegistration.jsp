<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retailer Registration</title>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: #FF5733;
}

* {
  box-sizing: border-box;
}

.container {
  padding: 08px;
  background-color: white;
}

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

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 10px;
}

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

a {
  color: dodgerblue;
}

.signin {
  background-color: #FF5733;
  color:black;
  text-align: center;
}
</style>
</head>
<body>
<form action="retailerRegistration.shop"  method="post" "myForm" onsubmit="return ValidateForm()">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
    
       <label for="id"><b>RetailerId</b></label>
    <input type="text" placeholder="Enter Your Id" name="retailerId" required>
    
    <label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter Your Name" name="retailerName" required>

    <label for="phone"><b>Mobile Number</b></label><br>
    <input type="Number" placeholder="Enter Your Mobile Number" name="retailerPhoneNumber" required><br>
    
    <label for="address"><b>Address</b></label><br>
    <input type="text" placeholder="Enter Your Address" name="retailerAddress" required><br>
    

<label for="status"><b>Status</b></label>
    <input type="Number" placeholder="Enter Status" name="retailerStatus" required>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="retailerMail" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="retailerPassword" id="ps1" required>
      
       <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" id="ps2" required>
   
    <hr>
    

    <button type="submit" class="registerbtn">Register</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>
</form>
<script>
   function ValidateForm()
{
  var x=document.myForm.email.value;  
var atposition=x.indexOf("@");  
var dotposition=x.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>= x.length){  
  alert("Please enter a valid e-mail address");  
  return false;  
  }  

  var password=document.getElementById("ps1").value;
        var confirmPassword=document.getElementById("ps2").value;
        if (password != confirmPassword) {
            alert("Password do not match.");
           return false;
        }
}
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>

body{
    margin: 0;
    padding: 0;
    background-position: center;
    background-size: cover;
    height: 90vh;
    font-family: sans-serif;
    background-image: url(business-futuristic-skyscraper-banner-23850748.jpg);
}

.login{
    width: 380px;
    height: 400px;
    background-image: url(testimonial_background_dubai_1920x800.jpg);
    color:black;
    top:50%;
    left: 50%;
    position: absolute;
    transform: translate(-50%,-50%);
    box-sizing: border-box;
    padding: 40px 25px;
    border-radius: 10px;    
}
h1{
    margin: 0;
    padding: 0 0 20px;
    text-align: center;
    font-size: 22px;
}
.login h1{
    background-color: #333399;
    border-radius: 6px;
    margin: 0;
    padding: 10px;
    font-weight: bold;
}
.login h2{
    margin: 0;
    text-align: center;
}
.login select
{
    width: 100%;
    margin-bottom: 18px;
    border-radius: 4px;

}
.login input{
    width: 100%;
    margin-bottom: 18px;
    border-radius: 4px;
}
.login input[type="text"],input[type="password"]
{
    border: none;
    border-bottom: 2px solid black;
    background: transparent;
    color: black;
    outline: none;
    height: 20px;
    font-size: 16px;
}

.login input[type="submit"]
{
    border: none;
    outline: none;
    height: 30px;
    color: #fff;
    background: #000;
    font-size: 17px;
    border-radius: 20px;
}
.login input[type="submit"]:hover
{
    cursor: pointer;
    background:#333399;
    color: #000;
    font-weight: bold;
}
.login a{
    text-decoration: none;
    font-size: 14px;
    line-height: 18px;
    color:#333399;
}
.login a:hover{
    color: #fff;
}


</style>
<meta charset="ISO-8859-1">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Login</title>
</head>
<body>
  <!DOCTYPE html>
<html>
    <head>
        <title>LOGIN FORM</title>
        <link rel="stylesheet" href="style.css"> 
    </head>
    
   <%
	if(session.getAttribute("wrong_uname_pass") != null){
	%>
	<script>
	
	alert("Wrong Username And Password!!");
	</script>
    <% } %>
    
    <body>
        <div class="login">
            <h1>Builder Flat Booking System</h1>
            <br>
            <h2>Login</h2>
            <br>
            <form action="LoginBuilderServlet" method="post" >
                <select name="name">
                    <option value="Builder" >Builder</option>
                    <option value="SalesPerson">SalesPerson</option>
                </select>
                <input type="text" name="uname" placeholder="Enter Username"><br>
                <input type="password" name="pwd" placeholder="Enter Password"><br>
                <input type="submit" name="" value="Login"><br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">Forgot Your Password?</a><br>
                
            </form>
        </div>
    </body>
</html>
</body>
</html>
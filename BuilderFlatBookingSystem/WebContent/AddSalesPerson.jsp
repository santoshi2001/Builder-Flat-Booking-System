<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
<style>
body
{
 background-image: url('images/PAdd.jpg');
 background-repeat: no-repeat;
 background-size: cover;
}
</style>

</head>
<%@include file="builderheader.jsp" %>
<br>
<body class="container">
 
 
 
 
    <center><h1>Add SalesPerson</h1></center>
    <form action="AddSalesPersonServlet" method="post">
   
      
      <div class="form-group">
      <label class="form-label mt-4">Enter SalesPerson Name</label>
      <input type="text" class="form-control" name="sname" placeholder="Enter SalesPerson Name">
      </div>
      
      <div class="form-group">
      <label  class="form-label mt-4">Enter Username</label>
      <input type="text" class="form-control" name="suname" placeholder="Enter Email ">
      </div>
      
      <div class="form-group">
      <label class="form-label mt-4">Enter Password</label>
      <input type="password" class="form-control" name="spassword" placeholder="Enter Password">
      </div>
      
      <div class="form-group">
      <label class="form-label mt-4">Enter Contact No.</label>
      <input type="text" class="form-control" name="scontact" placeholder="Enter Contact No.">
      </div>
      
      <div class="form-group">
      <label class="form-label mt-4">Enter Property Number</label>
      <input type="number" class="form-control" name="spno" placeholder="Enter Property No.">
      </div>
      
      <div class="form-group">
      <label class="form-label mt-4">Enter Floor Number</label>
      <input type="number" class="form-control" name="sfloorno" placeholder="Enter Floor No.">
      </div>
      
       <div class="form-group">
      <label class="form-label mt-4">Enter Flat Number</label>
      <input type="number" class="form-control" name="sflatno" placeholder="Enter Flat No.">
      </div>
      
      <div class="form-group">
      <label for="exampleInputPassword1" class="form-label mt-4">Enter Membership</label>
      
      <select name="smembership" class="form-control">
                    <option value="Basic">Basic</option>
                    <option value="Platinum" >Gold</option>
                    <option value="Gold">Platinum</option>
                    <option value="Silver">Silver</option>
      </select>
      
      </div>
      
     
       <center>
       <div class="form-group">
      <input class="btn btn-primary btn-lg active" role="button" aria-pressed="true" type="Submit" value="Submit">
      </div>
      </center>
     
    
  </form>
    
</body>
</html>
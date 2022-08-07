<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Flat</title>

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
 
 
 
 
    <center><h1>Add Flat</h1></center>
    <form action="AddFlatServlet" method="post">
   
      

      
      <div class="form-group">
      <label class="form-label mt-4">Flat Type</label>
      <select name="ftype" class="form-control">
                    <option value="1BHK">1 BHK</option>
                    <option value="2BHK" >2 BHK</option>
                    <option value="3BHK">3 BHK</option>
      </select>
      </div>
      
      
      
      
      <div class="form-group">
      <label class="form-label mt-4">Flat Details</label>
      <input type="text" class="form-control" name="fdetails" placeholder="Enter Flat Details">
      </div>
      
      <div class="form-group">
      <label class="form-label mt-4">Flat Location</label>
      <input type="text" class="form-control" name="flocation" placeholder="Enter Flat Location">
      </div>
      
      <div class="form-group">
      <label  class="form-label mt-4">Flat Area</label>
      <input type="text" class="form-control" name="farea" placeholder="Enter Property Area">
      </div>
      
      <div class="form-group">
      <label  class="form-label mt-4">Flat image</label>
      <input type="file" class="form-control" name="fimage" placeholder="flat image">
      </div>
      
       <div class="form-group">
      <label class="form-label mt-4">Membership</label>
      <select name="fmembership" class="form-control">
                    <option value="Basic">Basic</option>
                    <option value="Platinum" >Gold</option>
                    <option value="Gold">Platinum</option>
                    <option value="Silver">Silver</option>
      </select>
      </div>
      
      <br/><br/>
      <input type="hidden" name="p_no" value="<%= session.getAttribute("p_no") %>">
      <input type="hidden" name="f_no" value="<%= session.getAttribute("f_no") %>">
      
       <center>
       <div class="form-group">
      <input class="btn btn-primary btn-lg active" role="button" aria-pressed="true" type="Submit" name="Submit" value="Submit">
      </div>
      </center>
     
    
  </form>
    
</body>
</html>
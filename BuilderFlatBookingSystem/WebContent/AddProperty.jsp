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
 
 
 
 
    <center><h1>Add Property</h1></center>
    <form action="AddPropertyServlet" method="post">
   
      
      <div class="form-group">
      <label  class="form-label mt-4">Property Name</label>
      <input type="text" class="form-control" name="pname" placeholder="Enter Property Name">
      </div>
      
      <div class="form-group">
      <label class="form-label mt-4">Property Type</label>
      <select name="ptype" class="form-control">
                    <option value="Building">Building</option>
                    <option value="Villa" >Villa</option>
                    <option value="Plot">Plot</option>
                    <option value="RowHouse">RowHouse</option>
      </select>
      </div>
      
      
      
      
      <div class="form-group">
      <label class="form-label mt-4">Property Details</label>
      <input type="text" class="form-control" name="pdetails" placeholder="Enter Property Details">
      </div>
      
      <div class="form-group">
      <label class="form-label mt-4">Property Location</label>
      <input type="text" class="form-control" name="plocation" placeholder="Enter Property Location">
      </div>
      
      <div class="form-group">
      <label  class="form-label mt-4">Property Area</label>
      <input type="text" class="form-control" name="parea" placeholder="Enter Property Area">
      </div>
      
      <div class="form-group">
      <label  class="form-label mt-4">No. Of Floors in Property</label>
      <input type="text" class="form-control" name="pfloors" placeholder="Enter No. of Floors">
      </div>
      
       <div class="form-group">
      <label class="form-label mt-4">Add Image</label>
      <input type="file" class="form-control" name="pimage" placeholder="Add Image">
      </div>
      
      <br/><br/>
      
       <center>
       <div class="form-group">
      <input class="btn btn-primary btn-lg active" role="button" aria-pressed="true" type="Submit" value="Submit">
      </div>
      </center>
     
    
  </form>
    
</body>
</html>
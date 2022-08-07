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
 
 
 
 
    <center><h1>Update Flat</h1></center>
    <form action="UpdateFlatServlet" method="post">
   
      

      
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
      <input type="text" class="form-control" name="fdetails" value="<%= request.getParameter("fdetail")%>">
      </div>
      
      <div class="form-group">
      <label class="form-label mt-4">Flat Location</label>
      <input type="text" class="form-control" name="flocation" value="<%= request.getParameter("flocation") %>">
      </div>
      
      <div class="form-group">
      <label  class="form-label mt-4">Flat Area</label>
      <input type="text" class="form-control" name="farea" value="<%= request.getParameter("farea") %>">
      </div>
      
      <div class="form-group">
      <label  class="form-label mt-4">Flat image</label>
      <input type="file" class="form-control" name="fimage" >
      </div>
      
       <div class="form-group">
      <label class="form-label mt-4">Membership</label>
      <select name="fmembership" class="form-control" value="<%= request.getParameter("fmembership")%>">
                    <option value="Basic">Basic</option>
                    <option value="Platinum" >Gold</option>
                    <option value="Gold">Platinum</option>
                    <option value="Silver">Silver</option>
      </select>
      </div>
      
      <br/><br/>
      <input type="hidden" name="flatno" value="<%= request.getParameter("flatno") %>">
      <input type="hidden" name="f_no" value="<%= request.getParameter("fno") %>">
      <input type="hidden" name="p_no" value="<%= request.getParameter("pno") %>">
      
       <center>
       <div class="form-group">
      <input class="btn btn-primary btn-lg active" role="button" aria-pressed="true" type="Submit" name="Submit" value="Update ">
      </div>
      </center>
     
    
  </form>
    
</body>
</html>
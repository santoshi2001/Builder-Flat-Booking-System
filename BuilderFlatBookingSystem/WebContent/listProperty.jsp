<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  
 <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.entity.Property" %>    
    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Property List</title>
  <meta charset="utf-8">
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
<body>

<% if((session.getAttribute("name").equals("Builder"))) 
{ %>
  <%@include file="builderheader.jsp" %>
  <%
}
else if((session.getAttribute("name").equals("SalesPerson"))) {
  %>
  <%@include file="Salesheader.jsp" %>
  <% } %> 
<div class="container mt-3">
  <center><h2>Properties</h2></center>
  <br>  
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Property No</th>
        <th>Name</th>
        <th>Type</th>
        <th>Details</th>
        <th>Location</th>
        <th>Area</th>
        <th>No of Floors</th>
        <th>Details</th>
      </tr>
    </thead>
    <tbody>
    
    <% 
      ArrayList<Property> properties=(ArrayList<Property>)request.getAttribute("propertyData");
    
      for(Property property:properties)
      {
    %>
    
      <tr>
        <td><%= property.getP_no() %></td>
        <td><%= property.getP_name() %></td>
        <td><%= property.getP_type() %></td>
        <td><%= property.getP_details() %></td>
        <td><%= property.getP_location() %></td>
        <td><%= property.getP_area() %></td>
        <td><%= property.getNo_of_floors() %></td>
       <form action="PropertyDetailServlet" method="post" >
        <input type="hidden" name="p_no" value="<%=property.getP_no() %>">
        <td><input class="btn btn-secondary" type="Submit" name="submit" value="See Details"></td></form>
        
        
        <% if((session.getAttribute("name").equals("Builder"))) 
{ %>
 <td><a href="UpdatePropertyForm.jsp?pno=<%= property.getP_no() %>&pname=<%= property.getP_name() %>&ptype=<%= property.getP_type() %>&pdetail=<%= property.getP_details() %>&plocation=<%= property.getP_location() %>&parea=<%= property.getP_area() %>&pNoFloors=<%= property.getNo_of_floors() %>"><button class="btn btn-primary">Update</button></a></td>
        <td><a href="DeletePropertyServlet?pno=<%= property.getP_no() %>"><button class="btn btn-danger">Delete</button></a></td>
  <%
}
  %>
 
        
       
      </tr>
      
      <%
      }
      %>
    </tbody>
  </table>
</div>
</body>
</html>

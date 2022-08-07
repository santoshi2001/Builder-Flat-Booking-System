<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.entity.SalesPerson" %>    
    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>SalesPerson List</title>
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

<%@include file="builderheader.jsp" %>
<div class="container mt-3">
  <center><h2>SalesPersons</h2></center>
  <br>          
  <table class="table table-hover">
    <thead>
      <tr>
        <th>SalesPerson No</th>
        <th>Name</th>
        <th>Email</th>
        <th>Contact No.</th>
        <th>Property No</th>
        <th>Floor No</th>
        <th>Booked Flat No</th>
        <th>MemberShip</th>
      </tr>
    </thead>
    <tbody>
    
    <% 
      ArrayList<SalesPerson> persons=(ArrayList<SalesPerson>)request.getAttribute("salesPersonsData");
    
      for(SalesPerson person:persons)
      {
    %>
    
      <tr>
        <td><%= person.getsNo() %></td>
        <td><%= person.getName() %></td>
        <td><%= person.getUserName() %></td>
        <td><%= person.getContactNo() %></td>
        <td><%=person.getSp_no() %></td>
        <td><%= person.getSfloor_no() %></td>
        <td><%= person.getBookedFlatNo() %></td>
        <td><%= person.getMembership() %></td>
        
      </tr>
      
      <%
      }
      %>
    </tbody>
  </table>
</div>
</body>
</html>

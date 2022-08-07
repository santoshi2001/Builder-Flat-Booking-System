<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.entity.Flat" %>    
    
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
  <center><h2>Floors Details</h2></center>
  <br>
  <%
  session.setAttribute("p_no",request.getAttribute("p_no"));
  session.setAttribute("f_no",request.getAttribute("f_no"));
  %>
  
  <% if((session.getAttribute("name").equals("Builder"))) 
{ %>
  <div align="right">
  <form action="AddFlat.jsp" method="post">
  <input type="hidden" name="p_no" value="${p_no}">
  <input type="hidden" name="f_no" value="${f_no }">
  <input class="btn btn-primary" type="Submit" name="Submit" value="Add Flat">
  </form>
  </div> 
  <% }  %>
  <br/>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Flat No</th>
        <th>Floor No</th>
        <th>Flat type</th>
        <th>Details</th>
        <th>Location</th>
        <th>Area</th>
        <th>Membership</th>
      </tr>
    </thead>
    <tbody>
    
    <%    
      int i=1;
      ArrayList<Flat> flats=(ArrayList<Flat>)request.getAttribute("flatData");
    
      for(Flat f:flats)
      {
    %>
    
      <tr>
        <td><%= i %></td>
        <td><%= f.getFloor_no() %></td>
        <td><%= f.getF_type() %></td>
        <td><%= f.getF_details() %></td>
        <td><%= f.getF_location() %></td>
        <td><%= f.getF_area() %></td>
        <td><%= f.getF_membership() %></td>
        
        <% if((session.getAttribute("name").equals("Builder"))) 
{ %>
 <td><a href="UpdateFlatForm.jsp?flatno=<%= f.getF_no() %>&pno=<%= f.getP_no() %>&fno=<%= f.getFloor_no()%>&ftype=<%= f.getF_type() %>&fdetail=<%= f.getF_details() %>&flocation=<%= f.getF_location() %>&farea=<%= f.getF_area() %>&fmembership=<%= f.getF_membership() %>"><button class="btn btn-primary">Update</button></a></td>
        <td><a href="DeleteFlatServlet?flatno=<%= f.getF_no() %>&pno=<%= f.getP_no() %>&fno=<%= f.getFloor_no()%>"><button class="btn btn-danger">Delete</button></a></td>
      
  <%
}
  %>
 
        
        </tr>
      
      <%
      i++;
      }
      %>
      
    </tbody>
  </table>
  
  
</div>
</body>
</html>

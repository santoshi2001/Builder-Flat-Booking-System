<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.entity.Property" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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
     <% 
      ArrayList<Property> properties=(ArrayList<Property>)request.getAttribute("propertyData");
    %>
  
  
      
 
  <%
      for(Property property:properties)
      {
    	  %>
    	  <img src="data:image/jpg;base64,${property.getBase64Image() }" width="240" height="300"/>
    	 <% 
    	 for(int i=1;i<property.getNo_of_floors();i++)
    	  {
    		
    		  %>
    		 <form action="/BuilderFlatBookingSystem/FloorDetailsServlet" method="post" >
    		 
	        <input type="hidden" name="p_no" value="<%=property.getP_no() %>">
	        <input type="hidden" name="f_no" value="<%= i %>">
	        <input type="Submit" class="btn btn-dark" name="submit" value="floor <%= i %>">
	        </form>

     <%
    	  }
      }
     %>
</div>
</body>
</html>
package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginBuilderDao 
{
   
	String username="root";
	String password="";
	String connectionUrl="jdbc:mysql://localhost:3306/buildersystem";
	String jdbcDriver="com.mysql.jdbc.Driver";
	
	
	public boolean checkSalesPerson(String uname,String pwd)
	{
		try
		{
			Class.forName(jdbcDriver);
			Connection con=DriverManager.getConnection(connectionUrl,username,password);
			PreparedStatement stmt=con.prepareStatement("select * from salesperson where Email_id=? and Password=?");
		    stmt.setString(1, uname);
			stmt.setString(2, pwd);
			
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}

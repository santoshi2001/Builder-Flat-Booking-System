package com.dao;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import java.io.InputStream;
import java.io.FileInputStream;

import com.entity.Property;

public class PropertyDao {

	String username="root";
	String password="";
	String connectionUrl="jdbc:mysql://localhost:3306/buildersystem";
	String jdbcDriver="com.mysql.jdbc.Driver";
	
	public List<Property> getProperty()
	{
		List<Property> properties=new ArrayList<Property>();
		
		String sql="SELECT * FROM property";
		
		try
		{
			Class.forName(jdbcDriver);
			Connection con=DriverManager.getConnection(connectionUrl,username,password);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println("Success");
			while(rs.next())
			{
				Property p1=new Property();
				p1.setP_no(rs.getInt(1));
				p1.setP_name(rs.getString(2));
				p1.setP_type(rs.getString(3));
				p1.setP_details(rs.getString(4));
				p1.setP_location(rs.getString(5));
				p1.setP_area(rs.getInt(6));
				p1.setNo_of_floors(rs.getInt(8));
				
				properties.add(p1);
			}
			con.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return properties;
	}
	
	public List<Property> showDetails(int p_no)
	{
        List<Property> properties=new ArrayList<Property>();
		
		try
		{
			System.out.println("Image ser------------&&&&&&&&&&--------------------------------");
			Class.forName(jdbcDriver);
			Connection con=DriverManager.getConnection(connectionUrl,username,password);
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM property where P_no=?");
			stmt.setInt(1,p_no);
			ResultSet rs=stmt.executeQuery();
			System.out.println("Image ser---------------------------------------------");
			while(rs.next())
			{
				System.out.println("Image ser");
				Property p1=new Property();
				p1.setP_no(rs.getInt(1));
				p1.setP_name(rs.getString(2));
				p1.setP_type(rs.getString(3));
				p1.setP_details(rs.getString(4));
				p1.setP_location(rs.getString(5));
				p1.setP_area(rs.getInt(6));
				
				
//				Blob blob = rs.getBlob(7);
//				 
//				InputStream inputStream = blob.getBinaryStream();
//				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//				byte[] buffer = new byte[4096];
//      			int bytesRead = -1;
//				 
//				while ((bytesRead = inputStream.read(buffer)) != -1) {
//				    outputStream.write(buffer, 0, bytesRead);
//				}
//			 
//				byte[] imageBytes = outputStream.toByteArray();
//				 
//	        	String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//				 
//				inputStream.close();
//				outputStream.close();
//
//				
//				p1.setBase64Image(base64Image);
				
				p1.setNo_of_floors(rs.getInt(8));
				
				properties.add(p1);
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return properties;
	}
	
	public void addProperty(String pname,String ptype,String pdetails,String plocation,int parea,int pfloors,String pimage)
	{
		
		System.out.println("Inside getpro");
		try
		{
			System.out.println("Inside ");
			Class.forName(jdbcDriver);
			Connection con=DriverManager.getConnection(connectionUrl,username,password);
			PreparedStatement stmt=con.prepareStatement("Insert into Property(P_name,P_type,P_details,P_location,P_area,P_image,No_of_floors) values(?,?,?,?,?,?,?)");
			stmt.setString(1, pname);
			stmt.setString(2, ptype);
			stmt.setString(3, pdetails);
			stmt.setString(4,plocation);
			stmt.setInt(5, parea);
			
			FileInputStream fis=null;
			File image= new File(pimage);
			fis=new FileInputStream(image);
			

            stmt.setBinaryStream(6, (InputStream) fis, (int) (image.length()));
			stmt.setInt(7, pfloors);
			int i=stmt.executeUpdate();
			System.out.println(i+"Record Inserted");
			con.commit();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void updateProperty(int p_no,String Pname,String Ptype,String Pdetails,String Plocation,int Parea,int Pfloors,String myimg)
	{
		try
		{
			Class.forName(jdbcDriver);
			Connection con=DriverManager.getConnection(connectionUrl,username,password);
			PreparedStatement stmt=con.prepareStatement("update Property set P_name=?,P_type=?,P_details=?,	P_location=?,P_area=?,P_image=?,No_of_floors=? where P_no=?");
		
			stmt.setString(1, Pname);
			stmt.setString(2, Ptype);
			stmt.setString(3, Pdetails);
			stmt.setString(4, Plocation);
			stmt.setInt(5, Parea);

			FileInputStream fis=null;
			File image= new File(myimg);
			fis=new FileInputStream(image);
			

            stmt.setBinaryStream(6, (InputStream) fis, (int) (image.length()));
            stmt.setInt(7, Pfloors);
            stmt.setInt(8, p_no);
			int i=stmt.executeUpdate();
			System.out.println(i+"Record Updated");
			con.commit();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteProperty(int p_no)
	{
		try
		{
			Class.forName(jdbcDriver);
			Connection con=DriverManager.getConnection(connectionUrl,username,password);
			PreparedStatement stmt=con.prepareStatement("delete from Property where P_no=?");
		
			stmt.setInt(1, p_no);
			int i=stmt.executeUpdate();
			System.out.println(i+"Record Updated");
			con.commit();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	

}

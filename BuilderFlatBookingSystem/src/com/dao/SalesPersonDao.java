package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.entity.Flat;
import com.entity.Property;
import com.entity.SalesPerson;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SalesPersonDao 
{
   
	String username="root";
	String password="";
	String connectionUrl="jdbc:mysql://localhost:3306/buildersystem";
	String jdbcDriver="com.mysql.jdbc.Driver";
	
	public List<SalesPerson> getSalesPerson()
	{
		List<SalesPerson> Persons=new ArrayList<SalesPerson>();
		
		String sql="SELECT * FROM salesperson";
		
		try
		{
			Class.forName(jdbcDriver);
			Connection con=DriverManager.getConnection(connectionUrl,username,password);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println("Success");
			while(rs.next())
			{
				SalesPerson s1=new SalesPerson();
				
				s1.setsNo(rs.getInt(1));
				s1.setName(rs.getString(2));
				s1.setUserName(rs.getString(3));
				s1.setPassword(rs.getString(4));
				s1.setContactNo(rs.getString(5));
				s1.setSp_no(rs.getInt(6));
				s1.setSfloor_no(rs.getInt(7));
				s1.setBookedFlatNo(rs.getInt(8));
				s1.setMembership(rs.getString(9));
				
				
				Persons.add(s1);
			}
			con.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Persons;
	}
	
	
	
	public void addSalesPerson(String sname,String suname,String spassword,String scontact,String smembership,int flatno,int p_no,int floor_no)
	{
		
		try
		{
			System.out.println("Inside AddSal");
			Class.forName(jdbcDriver);
			Connection con=DriverManager.getConnection(connectionUrl,username,password);
			PreparedStatement stmt=con.prepareStatement("Insert into salesperson(Email_id,Password,Name,Contact_no,P_No,Floor_No,Booked_flat_no,Membership) values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, suname);
			stmt.setString(2, spassword);
			stmt.setString(3, sname);
			stmt.setString(4,scontact);
			stmt.setInt(5, p_no);
			stmt.setInt(6, floor_no);
			stmt.setInt(7, flatno);
			stmt.setString(8,smembership);
			
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
	
	public List<Flat> bookedFlats(String uname,String pwd)
	{
		List<Flat> flats=new ArrayList<Flat>();
		try
		{
			Class.forName(jdbcDriver);
			Connection con=DriverManager.getConnection(connectionUrl,username,password);
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM flats where P_no=(select P_No from salesperson where Email_id=? and Password=?)"
					+ " and floor_no=(select Floor_No from salesperson where Email_id=? and Password=?)"
					+ "and F_No=(select F_No from salesperson where Email_id=? and Password=?)");
			stmt.setString(1,uname);
			stmt.setString(2,pwd);
			stmt.setString(3,uname);
			stmt.setString(4,pwd);
			stmt.setString(5,uname);
			stmt.setString(6,pwd);
			ResultSet rs=stmt.executeQuery();
			System.out.println("Success flat");
			while(rs.next())
			{
				Flat f1=new Flat();
				f1.setF_no(rs.getInt(1));
				f1.setF_type(rs.getString(2));
				f1.setFloor_no(rs.getInt(3));
				f1.setP_no(rs.getInt(4));
				f1.setF_details(rs.getString(5));
				f1.setF_location(rs.getString(6));
				f1.setF_area(rs.getInt(7));
				
				f1.setF_membership(rs.getString(9));
				
				flats.add(f1);
			}
			con.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flats;

	}
	
}

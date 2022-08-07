package com.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Flat;
import com.entity.Property;

public class FlatDao {
	String username="root";
	String password="";
	String connectionUrl="jdbc:mysql://localhost:3306/buildersystem";
	String jdbcDriver="com.mysql.jdbc.Driver";
	

	public void addFlat(int p_no,int f_no,String ftype,String fdetails,String flocation,int farea,String fimage,String fmembership)
	{
		
		try
		{
			System.out.println("Inside addflatdao");
			Class.forName(jdbcDriver);
			Connection con=DriverManager.getConnection(connectionUrl,username,password);
			PreparedStatement stmt=con.prepareStatement("Insert into flats(F_type,floor_no,P_no,F_details,F_location,F_area,F_image,F_membership) values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, ftype);
			stmt.setInt(2, f_no);
			stmt.setInt(3, p_no);
			stmt.setString(4,fdetails);
			stmt.setString(5, flocation);
			stmt.setInt(6, farea);
			
			FileInputStream fis=null;
			File image= new File(fimage);
			fis=new FileInputStream(image);
			

            stmt.setBinaryStream(7, (InputStream) fis, (int) (image.length()));
			stmt.setString(8, fmembership);
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

	public List<Flat> getFlat(int p_no, int f_no) 
	{
        List<Flat> flats=new ArrayList<Flat>();
        System.out.println("Success flat before");
		System.out.println("Success flat afters");
		try
		{
			Class.forName(jdbcDriver);
			Connection con=DriverManager.getConnection(connectionUrl,username,password);
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM flats where P_no=? and floor_no=?");
			stmt.setInt(1,p_no);
			stmt.setInt(2,f_no);
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
	
	public void updateFlat(int flat_no,int f_no,int p_no,String f_type,String f_details,String f_location,int f_area,String f_image,String f_membership)
	{
		try
		{
			Class.forName(jdbcDriver);
			Connection con=DriverManager.getConnection(connectionUrl,username,password);
			PreparedStatement stmt=con.prepareStatement("update flats set F_type=?,F_details=?,F_location=?,F_area=?,F_image=?,F_membership=? where F_no=? and P_no=? and floor_no=?");
		
			stmt.setString(1, f_type);
			stmt.setString(2, f_details);
			stmt.setString(3, f_location);
			stmt.setInt(4, f_area);
			
			FileInputStream fis=null;
			File image= new File(f_image);
			fis=new FileInputStream(image);

            stmt.setBinaryStream(5, (InputStream) fis, (int) (image.length()));
            
			stmt.setString(6, f_membership);
			stmt.setInt(7, flat_no);
			stmt.setInt(8, p_no);
			stmt.setInt(9, f_no);
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
	
	public void deleteFlat(int flat_no)
	{
		try
		{
			Class.forName(jdbcDriver);
			Connection con=DriverManager.getConnection(connectionUrl,username,password);
			PreparedStatement stmt=con.prepareStatement("delete from flats where F_no=?");
		
			stmt.setInt(1, flat_no);
			int i=stmt.executeUpdate();
			System.out.println(i+"Record deleted");
			con.commit();
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}

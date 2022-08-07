package com.entity;

import java.util.List;

import javax.servlet.RequestDispatcher;

import com.dao.SalesPersonDao;

public class SalesPerson
{
	  private int sNo;
	  private String Name;
	  private String UserName;
	  private String Password;
	  private String contactNo;
	  private int sp_no;
	  private int sfloor_no;
	  private int bookedFlatNo;
	  private String membership;
	  
	public int getsNo() 
	{
		return sNo;
	}
	public void setsNo(int sNo) 
	{
		this.sNo = sNo;
	}
	public String getName() 
	{
		return Name;
	}
	public void setName(String name) 
	{
		Name = name;
	}
	public String getUserName() 
	{
		return UserName;
	}
	public void setUserName(String userName) 
	{
		UserName = userName;
	}
	public String getPassword() 
	{
		return Password;
	}
	public void setPassword(String password) 
	{
		Password = password;
	}
	public String getContactNo() 
	{
		return contactNo;
	}
	public void setContactNo(String contactNo) 
	{
		this.contactNo = contactNo;
	}
	public int getBookedFlatNo() 
	{
		return bookedFlatNo;
	}
	public void setBookedFlatNo(int bookedFlatNo) 
	{
		this.bookedFlatNo = bookedFlatNo;
	}
	public String getMembership() 
	{
		return membership;
	}
	public void setMembership(String membership) 
	{
		this.membership = membership;
	}
	public int getSp_no() {
		return sp_no;
	}
	public void setSp_no(int sp_no) {
		this.sp_no = sp_no;
	}
	public int getSfloor_no() {
		return sfloor_no;
	}
	public void setSfloor_no(int sfloor_no) {
		this.sfloor_no = sfloor_no;
	}
	
	
	
	
	
	  
}
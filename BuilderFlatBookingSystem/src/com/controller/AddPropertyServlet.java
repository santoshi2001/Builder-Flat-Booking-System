package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.PropertyDao;
import com.entity.Property;

/**
 * Servlet implementation class AddPropertyServlet
 */
@WebServlet("/AddPropertyServlet")
public class AddPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPropertyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String Pname=request.getParameter("pname");
			String Ptype=request.getParameter("ptype");
			String Pdetails=request.getParameter("pdetails");
			String Plocation=request.getParameter("plocation");
			System.out.println("Pname : "+Pname);
			int Parea=Integer.parseInt(request.getParameter("parea"));
			int Pfloors=Integer.parseInt(request.getParameter("pfloors"));
			String myimg=request.getParameter("pimage");
			
			
						 
			 PropertyDao prop=new PropertyDao();
			 prop.addProperty(Pname,Ptype,Pdetails,Plocation,Parea,Pfloors,myimg);
			 
		}
		catch (NumberFormatException e)
		{
			System.out.println(e);
		}
         response.sendRedirect("DisplayPropertyServlet");
		
	}

}

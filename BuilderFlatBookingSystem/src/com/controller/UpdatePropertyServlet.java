package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FlatDao;
import com.dao.PropertyDao;

/**
 * Servlet implementation class UpdatePropertyServlet
 */
@WebServlet("/UpdatePropertyServlet")
public class UpdatePropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePropertyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Inside updateProperty");
		   int p_no=Integer.parseInt(request.getParameter("p_no"));
		   System.out.println(p_no);
			String Pname=request.getParameter("pname");
			String Ptype=request.getParameter("ptype");
			String Pdetails=request.getParameter("pdetails");
			String Plocation=request.getParameter("plocation");
			System.out.println("Pname : "+Pname);
			int Parea=Integer.parseInt(request.getParameter("parea"));
			int Pfloors=Integer.parseInt(request.getParameter("pfloors"));
			String myimg=request.getParameter("pimage");
			
			PropertyDao prop=new PropertyDao();
			prop.updateProperty(p_no,Pname,Ptype,Pdetails,Plocation,Parea,Pfloors,myimg);
			

			RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayPropertyServlet");
			dispatcher.forward(request, response);
	}
}

package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PropertyDao;
import com.entity.Property;


/**
 * Servlet implementation class DisplayPropertyServlet
 */
@WebServlet("/DisplayPropertyServlet")
public class DisplayPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DisplayPropertyServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PropertyDao prop=new PropertyDao();
		List<Property> properties=prop.getProperty();
		
		request.setAttribute("propertyData", properties);
		RequestDispatcher rd=request.getRequestDispatcher("listProperty.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PropertyDao prop=new PropertyDao();
		List<Property> properties=prop.getProperty();
		
		request.setAttribute("propertyData", properties);
		RequestDispatcher rd=request.getRequestDispatcher("listProperty.jsp");
		rd.forward(request, response);
	}

	

}

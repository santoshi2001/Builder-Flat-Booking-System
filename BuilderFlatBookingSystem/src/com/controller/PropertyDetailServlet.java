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
 * Servlet implementation class PropertyDetailServlet
 */
@WebServlet("/PropertyDetailServlet")
public class PropertyDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		PropertyDao prop=new PropertyDao();
		int p_no=Integer.parseInt(request.getParameter("p_no"));
		System.out.println("p_no  : "+p_no);
		List<Property> properties=prop.showDetails(p_no);
		
		request.setAttribute("propertyData", properties);
		RequestDispatcher rd=request.getRequestDispatcher("PropertyDetails.jsp");
		rd.forward(request, response);
	}

}

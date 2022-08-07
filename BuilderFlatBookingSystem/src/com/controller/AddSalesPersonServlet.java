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
import com.dao.SalesPersonDao;
import com.entity.SalesPerson;

/**
 * Servlet implementation class AddSalesPersonServlet
 */
@WebServlet("/AddSalesPersonServlet")
public class AddSalesPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSalesPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String sname=request.getParameter("sname");
			String suname=request.getParameter("suname");
			String spassword=request.getParameter("spassword");
			String scontact=request.getParameter("scontact");
			String smembership=request.getParameter("smembership");
			int flatno=Integer.parseInt((String)request.getParameter("sflatno"));
			int sp_no=Integer.parseInt((String)request.getParameter("spno"));
			int sfoor_no=Integer.parseInt((String)request.getParameter("sfloorno"));
			System.out.println("Inside Post");
			
			 SalesPersonDao sales=new SalesPersonDao();
			 sales.addSalesPerson(sname,suname,spassword,scontact,smembership,flatno,sp_no,sfoor_no);
			 
		}
		catch (NumberFormatException e)
		{
			System.out.println(e);
		}
        response.sendRedirect("DisplaySalesPersonServlet");
	}

	

}

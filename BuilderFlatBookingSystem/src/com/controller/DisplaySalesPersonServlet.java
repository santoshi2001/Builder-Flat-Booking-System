package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SalesPersonDao;
import com.entity.SalesPerson;

/**
 * Servlet implementation class DisplaySalesPersonServlet
 */
@WebServlet("/DisplaySalesPersonServlet")
public class DisplaySalesPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplaySalesPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		SalesPersonDao sales=new SalesPersonDao();
		List<SalesPerson> salesPersons=sales.getSalesPerson();
		
		request.setAttribute("salesPersonsData", salesPersons);
		RequestDispatcher rd=request.getRequestDispatcher("listSalesPerson.jsp");
		rd.forward(request, response);
	}

	

}

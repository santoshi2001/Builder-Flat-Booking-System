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
 * Servlet implementation class AddFlatServlet
 */
@WebServlet("/AddFlatServlet")
public class AddFlatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			int p_no=Integer.parseInt(request.getParameter("p_no"));
			int f_no=Integer.parseInt(request.getParameter("f_no"));
			String ftype=request.getParameter("ftype");
     		String fdetails=request.getParameter("fdetails");
			String flocation=request.getParameter("flocation");
			int farea=Integer.parseInt(request.getParameter("farea"));
			String fmembership=request.getParameter("fmembership");
			String myimg=request.getParameter("fimage");
			System.out.println("p_no : " +p_no+"f_no : "+f_no+"Ftype : "+ftype+"Fedetails : "+fdetails+" Flocation : " +flocation+" Farea : "+farea+" Myimg :"+myimg+" Fmembership : "+fmembership)	;		 
			FlatDao flat=new FlatDao();
			flat.addFlat(p_no,f_no,ftype,fdetails,flocation,farea,myimg,fmembership);
			request.setAttribute("p_no", p_no);
			request.setAttribute("f_no", f_no);

			RequestDispatcher dispatcher = request.getRequestDispatcher("FloorDetailsServlet");
			dispatcher.forward(request, response);
	        //response.sendRedirect("FloorDetailsServlet");
			 
		}
		catch (NumberFormatException e)
		{
			System.out.println(e);
		}
		
		
	}

}

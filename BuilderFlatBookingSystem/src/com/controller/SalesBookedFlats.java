package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SalesPersonDao;
import com.entity.Flat;

/**
 * Servlet implementation class SalesBookedFlats
 */
@WebServlet("/SalesBookedFlats")
public class SalesBookedFlats extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesBookedFlats() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		String uname=String.valueOf(s.getAttribute("uname"));
		String pwd=String.valueOf(s.getAttribute("pwd"));
		SalesPersonDao sales=new SalesPersonDao();
		List<Flat> flats=sales.bookedFlats(uname,pwd);
		
		request.setAttribute("flatData", flats);
	

	
	RequestDispatcher rd=request.getRequestDispatcher("listFlat.jsp");
	rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FlatDao;

/**
 * Servlet implementation class DeleteFlatServlet
 */
@WebServlet("/DeleteFlatServlet")
public class DeleteFlatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFlatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flatno=Integer.parseInt(request.getParameter("flatno"));
		int p_no=Integer.parseInt(request.getParameter("pno"));
		int f_no=Integer.parseInt(request.getParameter("fno"));
		
		FlatDao flat=new FlatDao();
		flat.deleteFlat(flatno);
		
		request.setAttribute("p_no", p_no);
		request.setAttribute("f_no", f_no);

		//response.sendRedirect("FloorDetailsServlet");
		RequestDispatcher dispatcher = request.getRequestDispatcher("FloorDetailsServlet");
		dispatcher.forward(request, response);
	}

}

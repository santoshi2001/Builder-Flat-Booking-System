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
 * Servlet implementation class UpdateFlatServlet
 */
@WebServlet("/UpdateFlatServlet")
public class UpdateFlatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFlatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter pw=response.getWriter();
		int flat_no=Integer.parseInt(request.getParameter("flatno"));
		int f_no=Integer.parseInt(request.getParameter("f_no"));
		int p_no=Integer.parseInt(request.getParameter("p_no"));
		
		String f_type=request.getParameter("ftype");
		String f_details=request.getParameter("fdetails");
		String f_location=request.getParameter("flocation");
		int f_area=Integer.parseInt(request.getParameter("farea"));
		String f_image=request.getParameter("fimage");
		String f_membership=request.getParameter("fmembership");
		
		FlatDao flat=new FlatDao();
		flat.updateFlat(flat_no,f_no,p_no,f_type,f_details,f_location,f_area,f_image,f_membership);
		request.setAttribute("p_no", p_no);
		request.setAttribute("f_no", f_no);

		RequestDispatcher dispatcher = request.getRequestDispatcher("FloorDetailsServlet");
		dispatcher.forward(request, response);
	}

}

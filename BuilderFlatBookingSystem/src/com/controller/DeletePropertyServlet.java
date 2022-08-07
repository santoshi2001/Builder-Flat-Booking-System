package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PropertyDao;

/**
 * Servlet implementation class DeletePropertyServlet
 */
@WebServlet("/DeletePropertyServlet")
public class DeletePropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePropertyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int p_no =Integer.parseInt(request.getParameter("pno"));
		
		PropertyDao prop=new PropertyDao();
		prop.deleteProperty(p_no);
		
		response.sendRedirect("DisplayPropertyServlet");
	}


}

package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginBuilderDao;

/**
 * Servlet implementation class LoginBuilderServlet
 */
@WebServlet("/LoginBuilderServlet")
public class LoginBuilderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginBuilderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 String name=request.getParameter("name");
		 String username=request.getParameter("uname");
		 String password=request.getParameter("pwd");
		 

		 HttpSession s=request.getSession();
		 s.setAttribute("name", name);
		 if(name.equals("Builder"))
		 {
			 if(username.equals("Admin") && password.equals("Admin"))
			 {
				 response.sendRedirect("DisplayPropertyServlet");
			 }
			 else
			 {
				 s.setAttribute("wrong_uname_pass", 1);
				 response.sendRedirect("Login.jsp");
			 }
		 }
		 else if(name.equals("SalesPerson"))
		 {
			 LoginBuilderDao ld=new LoginBuilderDao();
			 if(ld.checkSalesPerson(username,password))
			 {
				 s.setAttribute("uname",username);
				 s.setAttribute("pwd", password);
				 response.sendRedirect("DisplayPropertyServlet");
			 }
			 else
			 {
				 s.setAttribute("wrong_uname_pass", 1);
				 response.sendRedirect("Login.jsp");
			 }
		 }
		 else 
		 {
			 
			 response.sendRedirect("Login.jsp");
		 }
		 
		 
		 
	}

}

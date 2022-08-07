package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FlatDao;
import com.dao.PropertyDao;
import com.entity.Flat;

/**
 * Servlet implementation class FloorDetailsServlet
 */
@WebServlet("/FloorDetailsServlet")
public class FloorDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FloorDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int f_no=(Integer)request.getAttribute("f_no");
		int p_no=(Integer)request.getAttribute("p_no");
		System.out.println("pno ="+p_no+" fno = "+f_no);
		if(f_no==0 && p_no==0)
		{
			request.setAttribute("p_no",request.getAttribute("p_no"));
			request.setAttribute("f_no",request.getAttribute("f_no"));

			FlatDao fl=new FlatDao();
			List<Flat> flats=fl.getFlat(p_no,f_no);

			request.setAttribute("flatData", flats);
		}
		else
		{
			request.setAttribute("p_no",p_no);
			request.setAttribute("f_no",f_no);
			FlatDao fl=new FlatDao();
			List<Flat> flats=fl.getFlat(p_no,f_no);

			request.setAttribute("flatData", flats);
		}
		
		
		RequestDispatcher rd=request.getRequestDispatcher("listFlat.jsp");
		rd.forward(request, response);
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int f_no=Integer.parseInt(request.getParameter("f_no"));
		int p_no=Integer.parseInt(request.getParameter("p_no"));
		System.out.println("pno ="+p_no+" fno = "+f_no);
		if(f_no==0 && p_no==0)
		{
			request.setAttribute("p_no",request.getAttribute("p_no"));
			request.setAttribute("f_no",request.getAttribute("f_no"));

			FlatDao fl=new FlatDao();
			List<Flat> flats=fl.getFlat(p_no,f_no);

			request.setAttribute("flatData", flats);
		}
		else
		{
			request.setAttribute("p_no",p_no);
			request.setAttribute("f_no",f_no);
			FlatDao fl=new FlatDao();
			List<Flat> flats=fl.getFlat(p_no,f_no);

			request.setAttribute("flatData", flats);
		}
		
		
		RequestDispatcher rd=request.getRequestDispatcher("listFlat.jsp");
		rd.forward(request, response);
	}

}

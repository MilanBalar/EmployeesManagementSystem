package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.EmpBean;
import com.dao.EmpDAO;


public class SaveServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String a=request.getParameter("action");
		
		if(a.equalsIgnoreCase("register"))
		{
		EmpBean b=new EmpBean();
		b.setEname(request.getParameter("ename"));
		b.setEdegree(request.getParameter("edegree"));
		b.setEemail(request.getParameter("eemail"));
		
		EmpDAO.SaveData(b);
		response.sendRedirect("Show.jsp");
		}
		
		
		if(a.equalsIgnoreCase("Delete"))
		{
			
			Long eid=Long.parseLong(request.getParameter("eid"));
			EmpDAO.deleteData(eid);
			response.sendRedirect("Show.jsp");
			
			
		}
		
		if(a.equalsIgnoreCase("Update"))
		{
			
			
			request.getRequestDispatcher("Edit.jsp").forward(request, response);
			
			
		}
		
		if(a.equalsIgnoreCase("Update_Data"))
		{
			EmpBean b=new EmpBean();
			b.setEid(Long.parseLong(request.getParameter("eid")));
			b.setEname(request.getParameter("ename"));
			b.setEdegree(request.getParameter("edegree"));
			b.setEemail(request.getParameter("eemail"));
			
			EmpDAO.Edit2Data(b);
			response.sendRedirect("Show.jsp");
			
			
			
		}
	}

}

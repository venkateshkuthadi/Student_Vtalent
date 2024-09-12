package com.Student_Vtalent.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.bean.Student_details;

/**
 * Servlet implementation class StudentServlet1
 */
@WebServlet("/StudentServlet1")
public class StudentServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		
		Object obj=session.getAttribute("Studentobject");
		Student_details st=null;
		if(obj!=null) {
			st=(Student_details)obj;
		}
		RequestDispatcher emp=request.getRequestDispatcher("/Studentdata");
		session.setAttribute("Student", emp);
		PrintWriter out=response.getWriter();
		out.print("<html><body><table>");
		out.print("<button>");
		out.print("<a href='Studentdata'>Data</a>");
		out.print("</button>");
		out.print("</table></body></html>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

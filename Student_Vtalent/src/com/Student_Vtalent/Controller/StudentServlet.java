package com.Student_Vtalent.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Student_Vtalent.Bean.Student_details;
import com.Student_Vtalent.DAO.Dao;
import com.student.dao.DAO;


/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
System.out.println("form submitter on GET");
		
		String std_id=request.getParameter("std_id");
		int s=0;
		try {
			s=Integer.parseInt(std_id);
		}catch(Exception e) {
			s =0;
		}
		String std_name=request.getParameter("std_name");
		String std_branch=request.getParameter("std_branch");
		String std_gender=request.getParameter("std_gender");
		String std_number=request.getParameter("std_number");
		long sn = 0;
		try {
		sn=Long.parseLong(std_number);
		}catch(Exception e) {
			sn=0;
		}
		
		Student_details sd = new Student_details();
		sd.setStd_id(std_id);
		sd.setStd_name(std_name);
		sd.setStd_branch(std_branch);
		sd.setStd_gender(std_gender);
		
		Dao d = new Dao();
		int result=d.insertDataWithpreparedStatement(sd);
		HttpSession session= request.getSession();
		session.setAttribute("Studentobject", sd);
		
		RequestDispatcher studentdataservlet=request.getRequestDispatcher("/Studentdata");
		RequestDispatcher failure=request.getRequestDispatcher("Fail.html");
		if(result>0) {
			studentdataservlet.forward(request, response);
		}else {
			failure.forward(request, response);
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("form submitted on post");
		String std_id = request.getParameter("std_id");
		Student_details st = new Student_details();
		st.setStd_id(std_id);
		
		Dao da = new Dao();
		int result = da.deleteDataWithpreparedStatement(st);
		RequestDispatcher success1=request.getRequestDispatcher("Success.html");
		RequestDispatcher failure1=request.getRequestDispatcher("Fail.html");
		if(result>0) {
			success1.forward(request, response);
		}else {
				failure1.forward(request, response);
		}
//		doGet(request, response);
	}

}

package com.Student_Vtalent.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student.bean.Student_details;

/**
 * Servlet implementation class StudentData
 */
@WebServlet("/StudentData")
public class StudentData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession session= request.getSession();
		Object obj=session.getAttribute("Studentobject");
		Student_details st=null;
		if(obj!=null) {
			st=(Student_details)obj;
		}
		PrintWriter out=response.getWriter();
		out.print("<html><body><table>");
		out.print("<tr><th>Std_id</th><th>Std_name</th><th>Std_branch</th><th>Std_gender</th><th>Std_number</th></tr>");
		out.print("<tr><td>"+st.getStd_id()+"</td>");
		out.print("<td>"+st.getStd_name()+"</td>");
		out.print("<td>"+st.getStd_branch()+"</td>");
		out.print("<td>"+st.getStd_gender()+"</td>");
		out.print("<td>"+st.getStd_number()+"</td></tr>");
		out.print("<tr><td><button><a href='Index.html'>index</a></td></tr>");
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

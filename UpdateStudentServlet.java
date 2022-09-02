package studentmanagement.controller;

import java.io.IOException;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagement.model.StudentBean;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
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
		StudentBean studentbean=new StudentBean();
		String code=request.getParameter("studentId");
		studentbean.setStudentId(code);
		studentbean.setStudentName(request.getParameter("studentName"));
		studentbean.setStudentDob(request.getParameter("studentDob"));
		studentbean.setStudentGender(request.getParameter("studentGender"));
		studentbean.setStudentPhone(request.getParameter("studentPhone"));
		studentbean.setStudentEducation(request.getParameter("studentEducation"));
		studentbean.setStudentCourse(request.getParameter("studentCourse"));
//		if(studentbean.getStudentId().equals("") || studentbean.getStudentName().equals("") || studentbean.getStudentDob().equals("") || studentbean.getStudentGender().equals("") || studentbean.getStudentPhone().equals("") || studentbean.getStudentEducation().equals("") || studentbean.getStudentCourse().equals(""))
//		{
//			request.setAttribute("error","File not blank!");
//			request.setAttribute("bean", studentbean);
//			request.getRequestDispatcher("STU002.jsp").forward(request, response);
//		}
//		else
//		{
		
			List<StudentBean> slist=(List<StudentBean>) request.getServletContext().getAttribute("slist");
			Iterator<StudentBean>itr=slist.iterator();
			while(itr.hasNext())
			{
				if(itr.next().getStudentId().equals(code))
				{
					itr.remove();
				}
			}
			
			slist.add(studentbean);
			System.out.println("s"+slist.get(1).getStudentPhone());
			request.getServletContext().setAttribute("slist",slist);
			request.getRequestDispatcher("STU003.jsp").forward(request,response);

	}
}




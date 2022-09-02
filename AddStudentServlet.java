package studentmanagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagement.model.StudentBean;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
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
		studentbean.setStudentId(request.getParameter("studentId"));
		studentbean.setStudentName(request.getParameter("studentName"));
		studentbean.setStudentDob(request.getParameter("studentDob"));
		studentbean.setStudentGender(request.getParameter("studentGender"));
		studentbean.setStudentPhone(request.getParameter("studentPhone"));
		studentbean.setStudentEducation(request.getParameter("studentEducation"));
		studentbean.setStudentCourse(request.getParameter("studentCourse"));
		
			List<StudentBean> slist=(List<StudentBean>) request.getServletContext().getAttribute("slist");
			if(slist==null)
			{
				slist=new ArrayList<StudentBean>();
			}
			slist.add(studentbean);
			request.getServletContext().setAttribute("slist", slist);
			request.getRequestDispatcher("STU003.jsp").forward(request, response);
		}
	}



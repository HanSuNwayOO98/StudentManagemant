package studentmanagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagement.model.CourseBean;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseBean coursebean=new CourseBean();
		coursebean.setCourseId(request.getParameter("courseId"));
		coursebean.setCourseName(request.getParameter("courseName"));
		
			List<CourseBean> clist=(List<CourseBean>) request.getServletContext().getAttribute("clist");
			if(clist==null)
			{
				clist=new ArrayList<CourseBean>();
			}
			clist.add(coursebean);
			request.getServletContext().setAttribute("clist", clist);
			
			request.getRequestDispatcher("STU001.jsp").forward(request, response);
		

	}
}

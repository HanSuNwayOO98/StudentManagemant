package studentmanagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagement.model.UserBean;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		UserBean userbean=new UserBean();
		userbean.setUserId(request.getParameter("userId"));
		userbean.setUserName(request.getParameter("userName"));
		userbean.setEmail(request.getParameter("email"));
		userbean.setPassword(request.getParameter("password"));
		userbean.setConfirmPassword(request.getParameter("confirmPassword"));
		userbean.setUserRole(request.getParameter("userRole"));
		
	
		
			List<UserBean> list=(List<UserBean>) request.getServletContext().getAttribute("list");
			if(list==null)
			{
				list=new ArrayList();
			}
			list.add(userbean);
			request.getServletContext().setAttribute("list", list);
			request.getRequestDispatcher("USR003.jsp").forward(request, response);
		}
	
	
}


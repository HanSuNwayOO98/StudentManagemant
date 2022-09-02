package studentmanagement.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagement.model.UserBean;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		String id=request.getParameter("id");
		userbean.setUserId(id);
		userbean.setUserName(request.getParameter("userName"));
		userbean.setEmail(request.getParameter("email"));
		userbean.setPassword(request.getParameter("password"));
		userbean.setConfirmPassword(request.getParameter("confirmPassword"));
		userbean.setUserRole(request.getParameter("userRole"));
		
	
		
			List<UserBean> list=(List<UserBean>) request.getServletContext().getAttribute("list");
			Iterator<UserBean> itr=list.iterator();
			while(itr.hasNext())
			{
				if(itr.next().getUserId().equals("id"))
					{
						itr.remove();
					}
					
			
			list.add(userbean);
			request.getServletContext().setAttribute("list", list);
			request.getRequestDispatcher("USR003.jsp").forward(request, response);
		}
	}
}



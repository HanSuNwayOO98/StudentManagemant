package studentmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagement.model.LoginBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
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
		LoginBean bean=new LoginBean();
		bean.setUserId(request.getParameter("userId"));
		bean.setPassword(request.getParameter("password"));
		
		if(bean.getUserId().equals("") || bean.getPassword().equals(""))
		{
			request.setAttribute("error", "Fill the blank");
			//request.setAttribute("bean", bean);
			request.getRequestDispatcher("LGN001.jsp").forward(request, response);
			}
		else
		{
			request.setAttribute("Welcome", "Please Check your connection");
			request.getRequestDispatcher("MNU001.jsp").forward(request, response);
		}
	}

}

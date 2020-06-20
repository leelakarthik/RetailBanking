package servlet;

import bean.*;
import service.userService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("empId");
		String password = request.getParameter("empPassword");
		Employee user = new Employee();
		user.setUsername(username);
		user.setPassword(password);
		userService svc = new userService();
		PrintWriter out = response.getWriter();
		try {
			boolean status = svc.EgetUserService(user);
			if (status) {
				HttpSession session = request.getSession();
				ServletContext servletContext = session.getServletContext();
				servletContext.setAttribute("Role", user.getRole());
				session.setAttribute("Role", user.getRole());
				request.setAttribute("name", user.getName());
				out.write("<script language='javascript'>window.alert('Login Sucessful');window.location='Welcome.jsp';</script>");
				//request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
			} else {
				out.write("<script language='javascript'>window.alert('Login Un-sucessful');window.location='index.jsp';</script>");
				//request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
			out.write("<script language='javascript'>window.alert('Error Occured');window.location='Logout.jsp';</script>");
		}
	}
}

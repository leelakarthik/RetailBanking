package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Customer;
import service.CustomerService;

/**
 * Servlet implementation class CustomerUpdate
 */
public class Transmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Transmit() {
		super();
		// 
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		Customer user = new Customer();
		String page = (String)request.getAttribute("page");
		String cusID = (String)request.getAttribute("cusID");
		String cusAID = (String)request.getAttribute("cusAID");
		if(!cusAID.isEmpty() && !cusAID.equals("empty")) {
			user.setAadharId(Integer.parseInt(cusAID));
		}
		else {
			user.setAadharId(-1);
		}
		if(!cusID.isEmpty() && !cusID.equals("empty")) {
			user.setCusId(Integer.parseInt(cusID));
		}
		else {
			user.setCusId(-1);
		}/*
		System.out.println("In page: "+page);
		System.out.println("a--cusAID : "+(user.getAadharId()));
		System.out.println("a--cusID : "+(user.getCusId()));*/
		CustomerService svc = new CustomerService();
		PrintWriter out = response.getWriter();
		try{
			boolean status = svc.C_getUserService(user);
			if(status) {
				request.setAttribute("cusAID", user.getAadharId());
				request.setAttribute("cusID", user.getCusId());
				request.setAttribute("age", user.getCusAge());
				request.setAttribute("address", user.getCusAddress());
				request.setAttribute("name", user.getCusName());
				if(page.equals("update"))
					getServletContext().getRequestDispatcher("/CustomerUpdate.jsp").forward(request, response);
				else if(page.equals("delete")){
					getServletContext().getRequestDispatcher("/CustomerDelete.jsp").forward(request, response);
				}
			}
			else {
				out.write("<script language='javascript'>window.alert('No Customer Found');window.location='Welcome.jsp';</script>");	
			}
		}catch (Exception e) {
			System.out.println("Exception "+e);
			out.write("<script language='javascript'>window.alert('Error Occured');window.location='Logout.jsp';</script>");
		}
	}

}

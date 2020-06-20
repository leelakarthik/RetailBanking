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
 * Servlet implementation class CustomerDelete
 */
public class CustomerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerDelete() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer user = new Customer(); 
		String aadhar = request.getParameter("cusAID");
		String id = request.getParameter("cusID");
		user.setAadharId(Integer.parseInt( aadhar));
		user.setCusId(Integer.parseInt(id));
		user.setCusStatus("deleted");
		user.setCusMessage("customer deleted sucessfully");
		CustomerService svc = new CustomerService(); 
		PrintWriter out = response.getWriter(); 
		try {
			boolean status = svc.C_deleteUserService(user); 
			if(status) { 
				out.write("<script language='javascript'>window.alert('Customer Deleted');window.location='Welcome.jsp';</script>"); 
			} 
			else { 
				out.write("<script language='javascript'>window.alert('Customer Not Deleted');window.location='Welcome.jsp';</script>"); 
			}
		}catch (Exception e) {
			System.out.println("Exception "+e);
			out.write("<script language='javascript'>window.alert('Error Occured');window.location='Logout.jsp';</script>");
		}
	}

}

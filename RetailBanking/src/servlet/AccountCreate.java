package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.Customer;
import service.AccountService;
import service.CustomerService;

/**
 * Servlet implementation class AccountCreate
 */
public class AccountCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountCreate() {
		super();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String cusID = request.getParameter("cusID");
		String accType = request.getParameter("accType");
		String depAmt = request.getParameter("depAmt");
		Account user = new Account();
		Customer s = new Customer();
		s.setCusId(Integer.parseInt(cusID));
		user.setCustomerID(Integer.parseInt(cusID));
		user.setAccountType(accType);
		AccountService usv = new AccountService();
		CustomerService ss = new CustomerService();
		try {
			boolean status = ss.C_getUserService(s);
			if(status) {
				user.setAccountType(accType);
				user.setCustomerID(s.getCusId());
				user.setAccountBalance(Double.parseDouble(depAmt));
				user.setAccountID(usv.get_AccID());
				user.setAccountStatus("Active");
				user.setMessage("Account created Sucessfully");
				status = usv.A_insertUserService(user);
				if (status) {
					out.write("<script language='javascript'>window.alert('Account Created ');window.location='Welcome.jsp';</script>");
				} else {
					out.write("<script language='javascript'>window.alert('Account Not-Created');window.location='Welcome.jsp';</script>");
				}
			}
			else {
				out.write("<script language='javascript'>window.alert('No Customer Found with given id');window.location='Welcome.jsp';</script>");	
			}
		}catch (Exception e) {
			System.out.println("Exception "+e);
			out.write("<script language='javascript'>window.alert('Error Occured');window.location='Logout.jsp';</script>");
		}
	}

}

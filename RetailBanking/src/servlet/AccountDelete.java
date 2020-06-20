package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import service.AccountService;

/**
 * Servlet implementation class AccountDelete
 */
public class AccountDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AccountDelete() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account user = new Account();
		String accID = request.getParameter("accID");
		user.setAccountID(Integer.parseInt(accID));
		String accType = request.getParameter("accType");
		user.setAccountType(accType);
		AccountService usv = new AccountService();
		PrintWriter out = response.getWriter(); 
		try {
			boolean status = usv.A_SearchCustomer_Service(user);
			if(status) {
				status = usv.A_deleteCustomer_Service(user);
				if(status) { 
					out.write("<script language='javascript'>window.alert('Account Deleted');window.location='Welcome.jsp';</script>"); 
				}
				else { 
					out.write("<script language='javascript'>window.alert('Account Not Deleted');window.location='Welcome.jsp';</script>"); 
				}
			}
			else { 
				out.write("<script language='javascript'>window.alert('Account Not Deleted');window.location='Welcome.jsp';</script>"); 
			}
		}catch (Exception e) {
			System.out.println("Exception "+e);
			out.write("<script language='javascript'>window.alert('Error Occured');window.location='Logout.jsp';</script>");
		}
	}

}

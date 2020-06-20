package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import service.AccountService;

public class AccountSearch extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public AccountSearch() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account user = new Account();
		String page = request.getParameter("page");
		String accID = (request.getParameter("accID"));
		String cusID = (request.getParameter("cusID"));
		if(!accID.isEmpty()) {
			user.setAccountID(Integer.parseInt(accID));
		}
		else {
			user.setAccountID(-1);
		}
		if(!cusID.isEmpty()) {
			user.setCustomerID(Integer.parseInt(cusID));
		}
		else {
			user.setCustomerID(-1);
		}
		AccountService svc = new AccountService();
		PrintWriter out = response.getWriter();
		try {
			boolean status = svc.A_GetCustomer_Service(user);
			if(status) {
				request.setAttribute("accID", user.getAccountID());
				request.setAttribute("cusID", user.getCustomerID());
				request.setAttribute("accType", user.getAccountType());
				request.setAttribute("accBalance", user.getAccountBalance());
				if(page.equals("delete"))
					getServletContext().getRequestDispatcher("/AccountDelete.jsp").forward(request, response);
				else if(page.equals("deposit"))
					getServletContext().getRequestDispatcher("/Deposit.jsp").forward(request, response);
				else if(page.equals("withdraw"))
					getServletContext().getRequestDispatcher("/Withdraw.jsp").forward(request, response);
				else if(page.equals("transfer"))
					getServletContext().getRequestDispatcher("/Transfer.jsp").forward(request, response);
			}
			else {
				out.write("<script language='javascript'>window.alert('No Account Found');window.location='Welcome.jsp';</script>");	
			}
		}catch (Exception e) {
			System.out.println("Exception "+e);
			out.write("<script language='javascript'>window.alert('Error Occured');window.location='Logout.jsp';</script>");
		}
	}
}

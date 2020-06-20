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
 * Servlet implementation class Transaction
 */
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Transaction() {
		super(); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account user = new Account();
		String accID = (request.getParameter("accID"));
		String page = (request.getParameter("page"));
		//System.out.println(page+" " +accID);
		user.setAccountID(Integer.parseInt(accID));
		AccountService svc = new AccountService();
		PrintWriter out = response.getWriter();
		try {
			boolean status = svc.A_GetCustomer_Service(user);
			if(status) {
				request.setAttribute("accID", user.getAccountID());
				System.out.println(page);
				if(page!=null)
					request.setAttribute("page", page);
				if(page.equals("last")) {
					String x = request.getParameter("numberT");
					System.out.println("length= "+x); 
					request.setAttribute("length", x);
				}
				else if(page.equals("date")) {
					request.setAttribute("sdate", request.getParameter("sDate"));
					request.setAttribute("edate", request.getParameter("eDate"));
				}
				getServletContext().getRequestDispatcher("/Transactions.jsp").forward(request, response);
			}
		}
		catch (Exception e) {
			
			System.out.println("Exception "+e);
			out.write("<script language='javascript'>window.alert('Error Occured');window.location='Logout.jsp';</script>");
		}


	}

}

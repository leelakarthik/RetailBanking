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
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Transfer() {
		super();
		// 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accID = (request.getParameter("accID"));
		String cusID = (request.getParameter("cusID"));
		String NaccID = request.getParameter("TaccID");
		String TaccType = (request.getParameter("TaccType"));
		String Tamt = request.getParameter("depAmt");
		PrintWriter out = response.getWriter();
		CustomerService csv = new CustomerService();
		Customer user = new Customer();
		Account sender = new Account();
		Account receiver = new Account();
		sender.setAccountID(Integer.parseInt(accID));
		sender.setAccountType(TaccType);
		sender.setMessage("transfer sent");
		user.setCusId(Integer.parseInt(cusID));
		double Abal, Dbal;
		try {
			boolean status = csv.C_getUserService(user);
			if(status) {
				AccountService asv= new AccountService();
				receiver.setAccountID(Integer.parseInt(NaccID));
				receiver.setAccountType(TaccType);
				receiver.setMessage("transfer recieved");
				try {
					status = asv.A_SearchCustomer_Service(receiver);
					boolean s_Status = asv.A_GetCustomer_Service(sender);
					if(status && s_Status) {
						if(Double.parseDouble(Tamt) < sender.getAccountBalance()) {
							Abal = receiver.getAccountBalance()+Double.parseDouble(Tamt);
							Dbal = sender.getAccountBalance()-Double.parseDouble(Tamt);
							receiver.setAccountBalance(Abal);
							sender.setAccountBalance(Dbal);
							try {
								status = asv.A_updateBalance(receiver);
								boolean s_status = asv.A_updateBalance(sender);
								if(status && s_status) {
									out.write("<script language='javascript'>window.alert('Transfer Sucessful');window.location='Welcome.jsp';</script>");
								}
							}
							catch(Exception e) {
								throw new Exception(e);
							}
						}
						else {
							out.write("<script language='javascript'>window.alert('Transfer Not-Sucessful Insufficient Funds');window.location='Welcome.jsp';</script>");
						}
					}
				}
				catch(Exception e) {
					throw new Exception(e);
				}
			}
		}catch (Exception e) {
			System.out.println("Exception "+e);
			out.write("<script language='javascript'>window.alert('Error Occured');window.location='Logout.jsp';</script>");
		}
	}

}

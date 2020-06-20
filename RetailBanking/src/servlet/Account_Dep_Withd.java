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
 * Servlet implementation class Account_Dep_Withd
 */
public class Account_Dep_Withd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Account_Dep_Withd() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account user = new Account();
		String page = request.getParameter("page");
		String accID = (request.getParameter("accID"));
		String amount = request.getParameter("balance");
		String u_amount =  request.getParameter("Amt");
		String Message = "";
		PrintWriter out = response.getWriter();
		int flag = 0;
		double balance = Double.parseDouble(amount);
		if(page.equals("deposit")) {
			user.setMessage("deposit");
			boolean x = Double.parseDouble(u_amount)>0;
			if(x) { 
				flag = 1;
				balance += Math.abs(Double.parseDouble(u_amount));
				Message = "<script language='javascript'>window.alert('Amount Deposited');</script>";
				Message +="<script language='javascript'>window.alert('Current balance is: "+ balance +" ');window.location='Welcome.jsp';</script>";
			}else {
				Message = "<script language='javascript'>window.alert('Amount Not-Deposited');</script>";
			}
			
		}
		else if(page.equals("withdraw")) {
			if(balance > Double.parseDouble(u_amount)) {
				flag=1;
				user.setMessage("withdraw");
				balance-=Math.abs(Double.parseDouble(u_amount));
				Message="<script language='javascript'>window.alert('Amount Withdrawed');</script>";
				Message+="<script language='javascript'>window.alert('current balance "+ balance +" after Withdraw');window.location='Welcome.jsp';</script>";
			}
			else {
				Message="<script language='javascript'>window.alert('insufficient balance');window.location='Search_Withdraw.jsp';</script>";
				out.write(Message);
			}
		}
		if(flag==1) {
			user.setAccountID(Integer.parseInt(accID));
			user.setAccountBalance(balance);
			AccountService usv = new AccountService();
			try {
				boolean status = usv.A_updateBalance(user);
				if(status) { 
					out.write(Message); 
				} 
				else { 
					out.write(Message); 
				}
			}catch(Exception e){
				e.printStackTrace();
				out.write("<script language='javascript'>window.alert('Error Occured');window.location='Logout.jsp';</script>");
			}
		}
		else {
			out.write(Message); 
		}

	}

}

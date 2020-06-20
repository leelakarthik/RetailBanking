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
 * Servlet implementation class createCustomer
 */
public class CustomerCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerCreate() {
		super();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		int Customer_Aadhar_Id = Integer.parseInt(request.getParameter("aadharid"));
		String Customer_Name = request.getParameter("cusname");
		int Customer_Age = Integer.parseInt(request.getParameter("cusage"));

		String Customer_Address = request.getParameter("cusaddress");
		String Customer_State = request.getParameter("cusstate");
		String Customer_City = request.getParameter("cuscity");

		CustomerService svc = new CustomerService();
		int Customer_Id = svc.get_CusID();
		String Customer_Status = "";
		if(Customer_Id >= 100000000) {
			Customer_Status = "Active";
		}
		else if(Customer_Aadhar_Id < 100000000) {
			Customer_Status = "";
		}
		String Customer_Message = "customer created sucessfully ";
		Customer user = new Customer();

		user.setAadharId(Customer_Aadhar_Id);
		user.setCusAddress(Customer_Address);
		user.setCusAge(Customer_Age);

		user.setCusCity(Customer_City);
		user.setCusId(Customer_Id);
		user.setCusMessage(Customer_Message);

		user.setCusName(Customer_Name);
		user.setCusState(Customer_State);
		user.setCusStatus(Customer_Status);
		PrintWriter out = response.getWriter();
		try {
			boolean status = svc.C_insertUserService(user);

			if (status) {
				out.write("<script language='javascript'>window.alert('Customer Created ');window.location='Welcome.jsp';</script>");
			} else {
				out.write("<script language='javascript'>window.alert('Customer Not-Created');window.location='CustomerCreate.jsp';</script>");
			}
		}catch (Exception e) {
			System.out.println("Exception "+e);
			out.write("<script language='javascript'>window.alert('Error Occured');window.location='index.jsp';</script>");
		}
	}

}

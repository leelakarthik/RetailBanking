package servlet;
import java.io.IOException; 
import java.io.PrintWriter; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpServletResponse; 
import bean.Customer;
import service.CustomerService;

public class CustomerUpdate extends HttpServlet { 

	private static final long serialVersionUID = 1L;
	/** * @see HttpServlet#HttpServlet() */ 
	public CustomerUpdate() { 
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer user = new Customer(); 

		String aadhar = request.getParameter("cusAID");
		String id = request.getParameter("cusID");
		String age = request.getParameter("uage");  
		String address = request.getParameter("uaddress"); 
		String name = request.getParameter("uname");  

		user.setAadharId(Integer.parseInt( aadhar));
		user.setCusId(Integer.parseInt( id));
		user.setCusName(name);
		user.setCusAge(Integer.parseInt(age));
		user.setCusAddress(address); 
		user.setCusStatus("Active");
		user.setCusMessage("customer details updated sucessfully");
		CustomerService svc = new CustomerService(); 
		PrintWriter out = response.getWriter(); 
		try {
			boolean status = svc.C_updateUserService(user); 
			if(status) { 
				out.write("<script language='javascript'>window.alert('Updated');window.location='Welcome.jsp';</script>"); 
			} 
			else { 
				out.write("<script language='javascript'>window.alert('Not Updated');window.location='Welcome.jsp';</script>"); 
			}
		}catch (Exception e) {
			System.out.println("Exception "+e);
			out.write("<script language='javascript'>window.alert('Error Occured');window.location='Logout.jsp';</script>");
		}
	}
}
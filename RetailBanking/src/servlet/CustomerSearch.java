package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerSearch extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public CustomerSearch() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page="";
		String dcusAID = request.getParameter("dcusAID");
		String cusAID = (request.getParameter("cusAID"));
		String cusID = (request.getParameter("cusID"));
		if(!cusID.isEmpty())
			request.setAttribute("cusID",cusID);
		else {
			request.setAttribute("cusID","empty");
		}
		if(dcusAID==null) {
			page = "update";
			if(!cusAID.isEmpty())
				request.setAttribute("cusAID",cusAID);
			else {
				request.setAttribute("cusAID","empty");
			}
		}
		else {
			page = "delete";
			if(!dcusAID.isEmpty())
				request.setAttribute("cusAID",dcusAID);
			else {
				request.setAttribute("cusAID","empty");
			}
		}
		request.setAttribute("page",page);
		RequestDispatcher rd = request.getRequestDispatcher("/Transmit");
		rd.forward(request,response);
	}
}

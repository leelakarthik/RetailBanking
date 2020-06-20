<%@page import="java.sql.*"%>
<%@page import="util.Db_Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer Status</title>
<link rel="stylesheet" type="text/css" href="CSS/table.css">
<link rel="stylesheet" type="text/css" href="CSS/ss.css">
<link rel="stylesheet" type="text/css" href="CSS/navi.css">
<link rel="stylesheet" type="text/css" href="CSS/drop.css">
</head>
<body>
	<header></header>
	<%
		ServletContext servletContext = getServletContext();
	try{
		if(session.getAttribute("Role")==null){
			response.sendRedirect("index.jsp");
		}else{
	String role = servletContext.getAttribute("Role").toString();
	System.out.println(role);
	
	if (role.equals("cashier")) {
	%>
	<script>
		alert("This Employee Can't perform this Operation");
		window.location = 'Welcome.jsp';
	</script>
	<%
	}
}
}
catch(Exception e){
	e.printStackTrace();
	out.write("<script>alert('Error Occured');window.location = 'Error.jsp';</script>");
}
	%>
	<div id="div">
		<table id="customers">
			<tr>
				<th>Customer ID</th>
				<th>Customer Aadhar ID</th>
				<th>Customer Status</th>
				<th>Message</th>
				<th>Last Updated</th>
			</tr>
			<%
			
				Connection con = Db_Connection.open_Connection();
			String q = "select * from customerstatus where timestamp in(SELECT  MAX(TIMESTAMP) FROM customerstatus GROUP BY customerID ORDER BY TIMESTAMP DESC) ORDER by timestamp desc limit 15";
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet r = ps.executeQuery(q);
			int counter = 1;
			ResultSetMetaData metaData = r.getMetaData();
			int columnsNumber = metaData.getColumnCount();
			%>
			<%
				while (r.next()) {
			%>
			<tr>
				<%
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
				%>
				<td><%=r.getString(i)%></td>

				<%
					}
				%>
				
			</tr>
			<%
				}
			%>
		</table>
	</div>
	<script type="text/javascript" src="JS/event.js"></script>

	<script type="text/javascript" src="JS/navigationBar.js"></script>
</body>
</html>

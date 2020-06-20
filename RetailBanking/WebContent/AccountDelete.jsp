<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<title>Delete Account</title>

<link rel="stylesheet" type="text/css" href="CSS/ss.css">
<link rel="stylesheet" type="text/css" href="CSS/navi.css">
<link rel="stylesheet" type="text/css" href="CSS/drop.css">
<body>
	<header> </header>
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
	<%!
	int accID;
	String type;
	String page;
	double balance;
	%>
	<%
	accID = (int) request.getAttribute("accID");
	balance = (double)request.getAttribute("accBalance");
	type = (String) request.getAttribute("accType");
	System.out.println(request.getParameter("page"));
	%>
	<div class="main">
		<form class="pure-form pure-form-aligned" action="AccountDelete" method="post">
			<fieldset>
				<h1>Delete Account Screen</h1>
				<input id="nameId" type="hidden" name="page" value="JavaCodeGeek" />
				<div class="pure-control-group">
					<label for="aligned-id">Account Id</label> <input type="number"
						id="aligned-id" name="accID" required readonly="readonly" value="<%=accID %>" />
				</div>
				<div class="pure-control-group">
					<label for="aligned-id">Account Type</label> <input type="text"
						id="aligned-id" name="accType" required readonly="readonly" value="<%=type %>" />
				</div>
				<div class="pure-control-group">
					<label for="aligned-id">Account Balance</label> <input type="number"
						id="aligned-id" name="balance" required readonly="readonly" value="<%=balance %>" />
				</div>
				<div class="pure-controls">
					<button class="button-success "type="submit">Delete</button>
					<button class="button-error "type="reset" onclick="fall_back('Account Delete')">Cancel</button>
				</div>
			</fieldset>
		</form>
	</div>
	<p></p>
	<script type="text/javascript" src="JS/test.js"></script>
	<script type="text/javascript" src="JS/eve.js"></script>
	<script type="text/javascript" src="JS/event.js"></script>
	<script type="text/javascript" src="JS/navigationBar.js"></script>
</body>
</html>
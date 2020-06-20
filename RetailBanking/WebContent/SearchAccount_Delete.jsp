<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Search Account</title>
<link rel="stylesheet" type="text/css" href="CSS/ss.css">
<link rel="stylesheet" type="text/css" href="CSS/navi.css">
<link rel="stylesheet" type="text/css" href="CSS/drop.css">
</head>
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
	<div class="main">
		<form class="pure-form pure-form-aligned" action="AccountSearch"
			method="post">
			<fieldset>
				<h1>Search Account Screen</h1>
				<input type="hidden" name="page" value="delete" />
				<div class="pure-control-group">
					<label>Customer ID</label> <input type="number"
						placeholder="Enter Customer ID" name="cusID" />
				</div>
				<br>
				<p style="text-align: left; padding-left: 200px">
					<b>OR</b>
				</p>
				<br>
				<div class="pure-control-group">
					<label>Account ID</label> <input type="number"
						placeholder="Enter Account ID" name="accID" />
				</div>
				<div class="pure-controls">
					<button class="button-success" type="submit">Search</button>
					<button class="button-error" type="reset"
						onclick="fall_back('Account Search')">Cancel</button>
				</div>
			</fieldset>
		</form>
	</div>
	<script type="text/javascript" src="JS/test.js"></script>
	<script type="text/javascript" src="JS/eve.js"></script>
	<script type="text/javascript" src="JS/event.js"></script>
	<script type="text/javascript" src="JS/navigationBar.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<title>Transfer</title>

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
	if (role.equals("executive")) {
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
		<%!int accID;
	int cusID;
	String type;
	String page;
	double balance;
	%>
	<%
	cusID = (int)request.getAttribute("cusID");
	accID = (int) request.getAttribute("accID");
	balance = (double)request.getAttribute("accBalance");
	type = (String) request.getAttribute("accType");
	%>
	<div class="main">
		<form class="pure-form pure-form-aligned" action="Transfer" method="post">
			<fieldset>
				<h1>Transer Money Screen</h1>
				<div class="pure-control-group">
					<label for="aligned-name" style="text-align: left;">Customer
						Id</label> <input type="text" id="aligned-name" placeholder=""
						name="cusID" required readonly="readonly" value="<%=cusID%>">
				</div>
				<div class="pure-control-group">
					<label for="aligned-name" style="text-align: left;">Account
						Id</label> <input type="text" id="aligned-name" placeholder=""
						name="accID" required readonly="readonly" value="<%=accID%>">
				</div>
				<div class="pure-control-group">
					<label for="aligned-id">Account Type</label> <input type="text"
						id="aligned-id" name="accType" required readonly="readonly"
						value="<%=type%>"
						 />
				</div>
				<div class="pure-control-group">
					<label for="aligned-name" style="text-align: left;">Target Account
						Id</label> <input type="text" id="aligned-name" placeholder=""
						name="TaccID" required >
				</div>
				<div class="pure-control-group">
					<label for="aligned-state" style="text-align: left;">Target
						Account Type</label> <select id="state" class="pure-contorl-group"
						name="TaccType" required>
						<option>Savings</option>
						<option>Current</option>
					</select>
				</div>
				<div class="pure-control-group">
					<label for="aligned-name" style="text-align: left;">
						Transfer Amount</label> <input type="text" id="aligned-name"
						placeholder="Enter Transfer Amount" name="depAmt" required>
				</div>
				<div class="pure-controls">
					<button class="button-success " type="submit">Transfer</button>
					<button class="button-error "type="reset" onclick="fall_back('Transfer')">Cancel</button>
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
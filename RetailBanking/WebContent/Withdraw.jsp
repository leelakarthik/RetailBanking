<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<title>Withdraw</title>

<link rel="stylesheet" type="text/css" href="CSS/ss.css">
<link rel="stylesheet" type="text/css" href="CSS/navi.css">
<link rel="stylesheet" type="text/css" href="CSS/drop.css">
<body>
	<header>
	</header>
	<%
		ServletContext servletContext = getServletContext();try{
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
	String message;
	double balance;
	%>
	<%
	message = "Withdraw";
	cusID = (int)request.getAttribute("cusID");
	accID = (int) request.getAttribute("accID");
	balance = (double)request.getAttribute("accBalance");
	type = (String) request.getAttribute("accType");
	System.out.println(request.getParameter("page"));
	%>
	<div class="main">
		<form class="pure-form pure-form-aligned" action="Account_Dep_Withd" method="post">
			<fieldset>
				<h1>Withdraw Money Screen</h1>
				<input
						type="hidden" id="aligned-name"
						 name="page" value="withdraw"/>
				<div class="pure-control-group">
					<label for="aligned-name">Customer Id</label> <input
						type="number" id="aligned-name"
						 name="cusID" readonly="readonly"value="<%=cusID%>" />
				</div>
				<div class="pure-control-group">
					<label for="aligned-password">Account Id</label> <input
						type="number" id="aligned-password"
						 name="accID" readonly="readonly" value="<%=accID%>"/>
				</div>
				<div class="pure-control-group">
					<label for="aligned-password">Account Type</label> <input
						type="text" id="aligned-password"
						 name="accType" readonly="readonly" value="<%=type%>"/>
				</div>
				<div class="pure-control-group">
					<label for="aligned-password">Balance</label> <input
						type="number" step="0.01" id="aligned-password"
						 name="balance" readonly="readonly" value="<%=balance%>"/>
				</div>
				<div class="pure-control-group">
					<label for="aligned-depAmt">Withdraw Amount</label> <input
						type="number" step="0.01" id="aligned-depAmt"
						placeholder="Enter Withdraw Amount" name="Amt" required />
				</div>
				<div class="pure-controls">
					<button class="button-success"type="submit">Withdraw</button>
					<button class="button-error "type="reset" onclick="fall_back('Withdrawl')" >Cancel</button>
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
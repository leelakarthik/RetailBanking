<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<title>Create Account</title>

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
	<div class="main">
		<form class="pure-form pure-form-aligned" action="AccountCreate"
			method="post">
			<fieldset>
				<h1>Create Account Screen</h1>
				<div class="pure-control-group">
					<label for="aligned-id">Customer Id</label> <input type="number"
						id="aligned-id" placeholder="Enter Customer Id" name="cusID"
						required />
				</div>
				<div class="pure-control-group">
					<label for="aligned-type">Account Type</label> <select
						id="aligned-type" class="pure-contorl-group" name="accType"
						required>
						
						<option>Savings</option>
						<option>Current</option>
					</select>
				</div>
				<div class="pure-control-group">
					<label for="aligned-dep">Deposit Amount</label> <input
						type="number" id="aligned-dep" placeholder="Enter Deposit Amount"
						name="depAmt" step="0.01" required />
				</div>
				<div class="pure-controls">
					<button class="button-success " type="submit">Submit</button>
					<button class="button-error " onclick="fall_back('Account Create')">Cancel</button>
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
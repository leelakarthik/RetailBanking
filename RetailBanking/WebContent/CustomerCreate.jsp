<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
</head>
<title>Create Customer</title>
<link rel="stylesheet" type="text/css" href="CSS/ss.css">
<link rel="stylesheet" type="text/css" href="CSS/navi.css">
<link rel="stylesheet" type="text/css" href="CSS/drop.css">
<body>
	<%
		ServletContext servletContext = getServletContext();
	try{
	if(session.getAttribute("Role")==null){
		response.sendRedirect("index.jsp");
	}else{
	String role = servletContext.getAttribute("Role").toString();
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
	<header> </header>
	<div class="main">
		<form class="pure-form pure-form-aligned" action="CustomerCreate"
			method="post">
			<fieldset>
				<h1>Create Customer Screen</h1>
				<div class="pure-control-group">
					<label for="aligned-name">Customer Aadhar Id</label> <input
						id="aligned-name"
						oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
						type="number" maxlength="9" placeholder="Enter Aadhar Id"
						name="aadharid" required />
				</div>
				<div class="pure-control-group">
					<label for="aligned-password">Customer Name</label> <input
						type="text" id="aligned-password"
						placeholder="Enter Customer Name" name="cusname" required />
				</div>
				<div class="pure-control-group">
					<label for="aligned-age">Age</label> <input
						oninput="javascript: if (this.value.length > this.maxLength)
						 this.value = this.value.slice(0, this.maxLength);"
						type="number" maxlength="3" id="aligned-age"
						placeholder="Enter Age" name="cusage" required />
				</div>
				<div class="pure-control-group">
					<label for="aligned-foo">Address</label>
					<textarea name="cusaddress" rows="3" cols="22"
						placeholder="Enter Address" required></textarea>
				</div>
				<div class="pure-control-group">
					<label for="aligned-state">State</label> <select id="state"
						class="pure-contorl-group" onchange="random_function()"
						name="cusstate" required>
						<option>Andhrapradesh</option>
						<option>Maharastra</option>
						<option>Tamilnadu</option>
						<option>Karnataka</option>
					</select>
				</div>
				<div class="pure-control-group">
					<label for="aligned-city">City</label> <select id="city"
						class="pure-contorl-group" name="cuscity" required>
						<option>select option</option>
					</select>
				</div>
				<div class="pure-controls">
					<button class="button-success" type="submit">Submit</button>
					<button class="button-error" type="reset" onclick="fall_back('Create Customer')">Cancel</button>
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
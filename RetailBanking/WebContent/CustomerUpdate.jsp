
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Customer</title>

<link rel="stylesheet" type="text/css" href="CSS/ss.css">
<link rel="stylesheet" type="text/css" href="CSS/navi.css">
<link rel="stylesheet" type="text/css" href="CSS/drop.css">
</head>
<title>Update Customer</title>
<body>
	<header> </header>
	<%try{
		if(session.getAttribute("Role")==null){
			response.sendRedirect("index.jsp");
		}
}
catch(Exception e){
	e.printStackTrace();
	out.write("<script>alert('Error Occured');window.location = 'Error.jsp';</script>");
}
	%>
	<%!int cusAID;
	int cusID;
	int age;
	String name;
	String address;%>
	<%
		cusAID = (int) request.getAttribute("cusAID");
	cusID = (int) request.getAttribute("cusID");
	age = (int) request.getAttribute("age");
	name = (String) request.getAttribute("name");
	address = (String) request.getAttribute("address");
	%>
	<div class="main">
		<form class="pure-form pure-form-aligned" action="CustomerUpdate"
			method="post">
			<fieldset>
				<h1>Update Customer Screen</h1>
				<div class="pure-control-group">
					<label for="aligned-name">Customer Aadhar Id</label> <input
						type="number" id="aligned-name" name="cusAID" value="<%=cusAID%>"
						readonly="readonly" />
				</div>
				<div class="pure-control-group">
					<label for="aligned-name">Customer Id</label> <input type="number"
						id="aligned-name" name="cusID" value="<%=cusID%>"
						readonly="readonly" />
				</div>
				<div class="pure-control-group">
					<label for="aligned-password">Customer Name</label> <input
						type="text" id="aligned-password" name="name" value="<%=name%>"
						readonly="readonly" />
				</div>
				<div class="pure-control-group">
					<label for="aligned-password">Update Customer Name</label> <input
						type="text" id="aligned-password" placeholder="Enter Updated Name"
						name="uname" required />
				</div>
				<div class="pure-control-group">
					<label for="aligned-age">Age</label> <input type="text"
						id="aligned-age" name="age" value="<%=age%>" readonly="readonly" />
				</div>
				<div class="pure-control-group">
					<label for="aligned-age">Update Age</label> <input type="number"
						oninput="javascript: if (this.value.length > this.maxLength)
						 this.value = this.value.slice(0, this.maxLength);"
						maxlength="3" id="aligned-age" placeholder="Enter Updated Age"
						name="uage" required />
				</div>
				<div class="pure-control-group">
					<label for="aligned-foo">Customer Address</label>
					<textarea name="address" rows="2" cols="22" readonly="readonly"><%=address%></textarea>
				</div>
				<div class="pure-control-group">
					<label for="aligned-foo">New Address</label>
					<textarea name="uaddress" rows="2" cols="22"
						placeholder="Enter Updated Address" required></textarea>
				</div>
				<div class="pure-controls">
					<button class="button-success" type="submit">Submit</button>
					<button class="button-error" type="reset" onclick="fall_back('Update Customer')">Cancel</button>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Delete Customer</title>

<link rel="stylesheet" type="text/css" href="CSS/ss.css">
<link rel="stylesheet" type="text/css" href="CSS/navi.css">
<link rel="stylesheet" type="text/css" href="CSS/drop.css">
</head>
<body>
	<header> </header>
	
	<%try{
		if(session.getAttribute("Role")==null){
			response.sendRedirect("index.jsp");
		}else{
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
		<form class="pure-form pure-form-aligned" action="CustomerDelete"
			method="post">
			<fieldset>
				<h1>Delete Customer Screen</h1>
				<div class="pure-control-group">
					<label for="aligned-name">Customer Aadhar Id</label> <input
						type="text" id="aligned-name" name="cusAID" value="<%=cusAID%>"
						readonly="readonly" />
				</div>
				<div class="pure-control-group">
					<label for="aligned-name">Customer Id</label> <input type="text"
						id="aligned-name" value="<%=cusID%>" name="cusID"
						readonly="readonly" />
				</div>
				<div class="pure-control-group">
					<label for="aligned-password">Customer Name</label> <input
						type="text" id="aligned-password" value="<%=name%>" name="name"
						readonly="readonly" />
				</div>
				<div class="pure-control-group">
					<label for="aligned-age">Age</label> <input type="number"
						id="aligned-age" name="age" value="<%=age%>" readonly="readonly" />
				</div>
				<div class="pure-control-group">
					<label for="aligned-foo">Address</label>
					<textarea name="address" rows="3" cols="22" readonly="readonly"><%=address%></textarea>
				</div>
				<div class="pure-controls">
					<button class="button-success" type="submit">Delete</button>
					<button class="button-error" type="reset" onclick="fall_back('Delete Customer')">Cancel</button>
				</div>
			</fieldset>
		</form>
	</div>
	<script type="text/javascript" src="JS/eve.js"></script>
	<script type="text/javascript" src="JS/test.js"></script>
	<script type="text/javascript" src="JS/event.js"></script>
	<script type="text/javascript" src="JS/navigationBar.js"></script>
</body>
</html>
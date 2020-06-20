<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="CSS/ss.css">
<link rel="stylesheet" type="text/css" href="CSS/navi.css">
<link rel="stylesheet" type="text/css" href="CSS/drop.css">
<body>
	<header>
	</header>
	<%

response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Expires", "0");
try{
	if(session.getAttribute("Role")==null){
		response.sendRedirect("index.jsp");
	}
}
catch(Exception e){
	e.printStackTrace();
	out.write("<script>alert('Error Occured');window.location = 'Error.jsp';</script>");
}
	%>
	<div class="main">
		<form class="pure-form pure-form-aligned">
			<fieldset>
				<h1 style="align:center;">Welcome to Coders Bank</h1>
			</fieldset>
		</form>
	</div>
	<script type="text/javascript" src="JS/test.js"></script>
	<script type="text/javascript" src="JS/event.js"></script>
	<script type="text/javascript" src="JS/navigationBar.js"></script> 
</body>
</html>
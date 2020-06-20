<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Logout</title>
</head>

<link rel="stylesheet" type="text/css" href="CSS/ss.css">
<link rel="stylesheet" type="text/css" href="CSS/navi.css">
<link rel="stylesheet" type="text/css" href="CSS/drop.css">
<body>

<%
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Expires", "0");
session.removeAttribute("Role");
session.invalidate();
response.sendRedirect("index.jsp");
%>
</body>
</html>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="util.Db_Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="table2excel.js" type="text/javascript"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
  
<meta http-equiv="content-type" content="text/plain; charset=UTF-8"/>
<title>Transaction Statement</title>
<link rel="stylesheet" type="text/css" href="CSS/table.css">
<link rel="stylesheet" type="text/css" href="CSS/ss.css">
<link rel="stylesheet" type="text/css" href="CSS/navi.css">
<link rel="stylesheet" type="text/css" href="CSS/drop.css">
</head>
<body>
	<header></header>
	<%	
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
	<%
		Connection con = Db_Connection.open_Connection();
	int accID = (int) (request.getAttribute("accID"));
	String pageName = (String)request.getAttribute("page");
	String length = (String)request.getAttribute("length");
	PreparedStatement ps = null;
	System.out.println("length = "+length);
	String Sdate, Edate;
	System.out.println("in JSP "+pageName);
	String q = null;
	int counter = 1;
	if (pageName.equals("hello")) {
		q = "SELECT accountID, transactionID, description, date, amount FROM transactions WHERE accountID = " + accID + " ORDER by time desc limit 10";
	} else if (pageName.equals("date")) {
		Sdate = request.getAttribute("sdate").toString();
		Edate = request.getAttribute("edate").toString();
		q = "SELECT accountID, transactionID, description, date, amount FROM transactions WHERE accountID = " + accID + " and date BETWEEN " + "'"+Sdate+"'" + " and "
		+ "'"+Edate+"'"+" ORDER by time desc";
	} else if (pageName.equals("last")) {
		q = "SELECT accountID, transactionID, description, date, amount FROM transactions WHERE accountID = " + accID + " ORDER by time desc limit "+ length;
	}
	String query = q;
	ps = con.prepareStatement(q);
	ResultSet r = ps.executeQuery(q);
	ResultSetMetaData metaData = r.getMetaData();
	int columnsNumber = metaData.getColumnCount();
	%>
	<div class="main">
		<form class="pure-form pure-form-aligned">
			<fieldset>
				<h1 style="font-size: 34px;">Account Statement Screen</h1>
				<input type="hidden" name="page" value="delete" />
				<div class="pure-control-group">
					<label for="aligned-name" style="text-align: left;">Account
						Id</label> <input type="number" id="aligned-name"
						placeholder="Enter Customer Id" name="accID" value="<%=accID%>"
						readonly />
				</div>
				<input type="hidden" id="aligned-name"
						placeholder="Enter Customer Id" name="length" value="<%=request.getAttribute("length")%>"
						readonly />
				<input type="hidden" id="aligned-name"
						placeholder="Enter Customer Id" name="length" value="<%=request.getAttribute("length")%>"
						readonly />
			</fieldset>
		</form>
	</div>
	<div id="divs">
		
		<table id="customers">
			<tr>
				<th>Sno</th>
				<th>Account ID</th>
				<th>Transaction ID</th>
				<th>Description</th>
				<th>Date of Transcation</th>
				<th>Amount</th>
			</tr>
			<%
				while (r.next()) {
					
			%>
			<tr>
				<td><%=counter%></td>
				<%
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
				%>

				<td><%=r.getString(i)%></td>

				<%} 
				counter++;%>
				<%} %>
			</tr>
			
		</table>
		<input type="hidden" name="obj" value="<%=query %>">
		<div class="pure-controls"
			style="text-align: center; padding-top: 20px">
			<button  class="button-success " id="btnExport" value="Export" onclick="ExportExcell()">(Excel)</button>
			<button class="button-success " id="btnExport" value="Export" onclick="ExportPDF()">(PDF)</button>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
    <script type="text/javascript">
        function ExportPDF() {
            html2canvas(document.getElementById('customers'), {
                onrendered: function (canvas) {
                    var data = canvas.toDataURL();
                    var docDefinition = {
                        content: [{
                            image: data,
                            width: 500
                        }]
                    };
                    pdfMake.createPdf(docDefinition).download("Transactions.pdf");
                }
            });
        }
    </script>
    <script type="text/javascript">
        function ExportExcell() {
            $("#customers").table2excel({
                filename: "Transactions.xls"
            });
        }
    </script>
		</div>
	</div>
	<script src="JS/table2excel.js" type="text/javascript"></script>
	<script type="text/javascript" src="JS/event.js"></script>
	<script type="text/javascript" src="JS/navigationBar.js"></script>
</body>
</html>

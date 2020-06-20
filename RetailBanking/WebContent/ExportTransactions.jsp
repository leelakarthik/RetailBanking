<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="util.Db_Connection"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
		document.getElementById('ifYes').style.display = 'none';
		document.getElementById('ifNo').style.display = 'none';
	function yesnoCheck(obj) {
		if (document.getElementById('yesCheck').checked) {
			document.getElementById('ifNo').style.display = 'none';
			document.getElementById('ifYes').style.display = 'block';
			document.getElementById('state').required;
			obj.form.elements['page'].value = obj.value;
		} else if (document.getElementById('noCheck').checked) {
			document.getElementById('ifNo').style.display = 'block';
			document.getElementById('ifYes').style.display = 'none';
			document.getElementById('page').value = 'date';
			obj.form.elements['page'].value = obj.value;
		}
	}
</script>
<link rel="stylesheet" type="text/css" href="CSS/radio.css">
<link rel="stylesheet" type="text/css" href="CSS/ss.css">
<link rel="stylesheet" type="text/css" href="CSS/navi.css">
<link rel="stylesheet" type="text/css" href="CSS/table.css">
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
	<div class="main">
		<form class="pure-form pure-form-aligned" action="Transaction"
			method="post">
			<fieldset>
				<h1 style="font-size: 34px;">Account Statement Screen</h1>
				<div class="pure-control-group">
					<label for="aligned-name" style="text-align: left;">Account
						Id</label> <input type="number" id="aligned-name"
						placeholder="Enter Account Id" name="accID" required />
				</div>
				<div>
					<br> <label class="container">Last No.of Transactions<input
						type="radio"
						onclick="javascript:yesnoCheck(this);"
						value="last"
						id="yesCheck" name="radio"> <span class="checkmark"></span>
					</label> <br> <label class="container">Date Transactions<input
						type="radio" onclick="javascript:yesnoCheck(this);" id="noCheck"
						value="date"> <span class="checkmark"></span>
					</label> <input type="hidden" id="page" name="page" value="hello"/>	
				</div>
				<div class="pure-control-group" id="ifYes" style="display: none">
					<label for="aligned-state" style="text-align: left;">N.O of
						Transactions</label> <select id="state" class="pure-contorl-group"
						name="numberT" >
						<option selected>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						<option>13</option>
						<option>14</option>
						<option>15</option>
						<option>16</option>
						<option>17</option>
						<option>18</option>
						<option>19</option>
						<option>20</option>
					</select>
				</div>
				<div class="pure-control-group" id="ifNo" style="display: none">
					<label for="aligned-name" style="text-align: left;">Start-date</label>
					<input type="date" id="aligned-name" placeholder="Enter Start Date"
						name="sDate" /> <br> <br> <label for="aligned-name"
						style="text-align: left;">End-date</label> <input type="date"
						id="aligned-name" placeholder="Enter End Date" name="eDate" />
				</div>
				<div class="pure-controls">
					<button class="button-success" type="submit">Submit</button>
					<button class="button-success" type="reset" onclick="fall_back('View Statements')">Cancel</button>
				</div>
			</fieldset>
		</form>
	</div><script type="text/javascript" src="JS/test.js"></script>
	<script type="text/javascript" src="JS/eve.js"></script>
	<script type="text/javascript" src="JS/event.js"></script>
	<script type="text/javascript" src="JS/navigationBar.js"></script>
</body>
</html>
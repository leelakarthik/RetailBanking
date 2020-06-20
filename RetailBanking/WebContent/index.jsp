<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Sign-in</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="CSS/ss.css">
</head>
<body>
	<header>
	</header>
	<div class="main">
		<form class="pure-form pure-form-aligned" action="Login" method="post">
			<fieldset>
			<h1>Employee Login Screen</h1>
				<div class="pure-control-group">
					<label for="aligned-name">Employee Id</label> <input
						type="number" id="aligned-name"
						placeholder="Enter Employee Id" name="empId" required />
				</div>
				<div class="pure-control-group">
					<label for="aligned-password">Password</label> <input
						type="password" id="aligned-password"
						placeholder="Enter Password" name="empPassword" required />
				</div>
				<div class="pure-controls">
					<button class="button-success " type="submit">Login</button>
					<button class="button-error " onclick="fall_back('Login')" type="reset">Cancel</button>
				</div>
			</fieldset>
		</form>
	</div>
	<script type="text/javascript">
	function fall_back(x) {
		window.alert(x+' Cancelled');
		window.location = 'index.jsp';
	}
	</script>
</body>
</html>

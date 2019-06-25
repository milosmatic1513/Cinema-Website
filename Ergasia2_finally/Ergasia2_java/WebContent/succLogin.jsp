<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GET TICKETS ONLINE</title>
</head>
<body>
	<style>
.button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
}

.button:hover {
	opacity: 0.8;
}

.textbox {
	padding: 14px 20px margin: 8px 0;
}
</style>
	<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	%>
	<h1 align="center">GET TICKETS ONLINE</h1>

	<table width='100%'>
		<tr>
			<td width='25%'><form action="main_login.jsp" class="frm-block">
					<button width='100%' type="submit"
						class="btn btn-success btn-block frm-block">
						<i class="fas fa-sign-in-alt"></i> Login
					</button>
				</form></td>
			<td width='25%'><form width='100%' method="post" action="Logout">
					<button class="btn btn-success btn-block frm-block" type="submit">
						<i class="fas fa-sign-out-alt"></i> Logout
					</button>
				</form></td>
			<td width='25%'><form width='100%' method="post"
					action="main_register.jsp">
					<button type="submit" class="btn btn-success btn-block frm-block">
						<i class="fas fa-flag"></i> Register
					</button>
				</form></td>
			<td width='25%'><form width='100%' method="post"
					action="Profile">
					<button type="submit" class="btn btn-success btn-block frm-block">
						<i class="fas fa-user"></i> Profile
					</button>
				</form></td>
		</tr>
	</table>
	<h1>Logged in : ${uname}</h1>
	<h1>Status : ${status}</h1>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>GET TICKETS ONLINE</title>
</head>
<body>

</head>
<body>
<h1 align="center">GET TICKETS ONLINE </h1>
<div class="btn-group  text-center col-12 btn-group-lg">
<table width='100%' >
  <tr>
   <td width='25%'><form   action = "main_login.jsp"  class  ="frm-block"><button width='100%' type = "submit"  class= "btn btn-success btn-block frm-block">   <i class="fas fa-sign-in-alt"></i> Login    </button></form></td>
   <td width='25%'><form width='100%' method = "post" action = "Logout"   ><button class= "btn btn-success btn-block frm-block" type = "submit"> <i class="fas fa-sign-out-alt"></i> Logout      </button></form></td>
   <td width='25%'><form width='100%' method = "post" action = "main_register.jsp"  ><button type = "submit"  class= "btn btn-success btn-block frm-block"> <i class="fas fa-flag"></i> Register</button></form></td>
   <td width='25%'><form width='100%' method = "post" action = "Profile"  ><button type = "submit"  class="btn btn-success btn-block frm-block"> <i class="fas fa-user"></i> Profile</button></form></td>
  </tr>
</table>
</div>
</body>
</html>
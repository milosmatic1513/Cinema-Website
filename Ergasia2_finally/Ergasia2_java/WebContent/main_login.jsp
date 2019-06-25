<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>GET TICKETS ONLINE</title>
 </head>
<body>
<style>



input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}


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
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}
</style>
<h1 align="center">GET TICKETS ONLINE </h1>
<table width='100%' >
  <tr>
   <td width='25%'><form   action = "main_login.jsp"  class  ="frm-block"><button width='100%' type = "submit"  class= "btn btn-success btn-block frm-block">   <i class="fas fa-sign-in-alt"></i> Login    </button></form></td>
   <td width='25%'><form width='100%' method = "post" action = "Logout"   ><button class= "btn btn-success btn-block frm-block" type = "submit"> <i class="fas fa-sign-out-alt"></i> Logout      </button></form></td>
   <td width='25%'><form width='100%' method = "post" action = "main_register.jsp"  ><button type = "submit"  class= "btn btn-success btn-block frm-block"> <i class="fas fa-flag"></i> Register</button></form></td>
   <td width='25%'><form width='100%' method = "post" action = "Profile"  ><button type = "submit"  class="btn btn-success btn-block frm-block"> <i class="fas fa-user"></i> Profile</button></form></td>
  </tr>
</table>


	<form method="post" action="LoginCheck">
	<table>
		<td>Username</td>
		<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				
				<td>Password</td>
				<td><input type="password" name="password" ></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="login" class = "button">
			</tr>
		</table>
	</form>
</body>
</html>
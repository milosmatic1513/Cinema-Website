<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>GET TICKETS ONLINE</title>
</head>
<body>
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;

  
}

button:hover {
  opacity: 0.8;
}

/* Extra styles for the cancel button */




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

<p><img style=" position: fixed;top: 30%; left: 40%; margin-top: -50px;margin-left: -100px;  "    src="ticket_pic.png" alt = "Tickets image"  align="middle"></p>
 


</body>
</html>
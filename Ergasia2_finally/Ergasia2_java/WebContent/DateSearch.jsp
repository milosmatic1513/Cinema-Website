<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="btn-group  text-center col-12 btn-group-lg">
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
</style>


		<form action="GetProvoles" method="post">
			<br> Start : <input type='date' required name="start_date"
				id="start"> End : <input type='date' required
				name="end_date" id="end"> <input class="button"
				value="Search" type='submit'>


		</form>
		<br>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User Registration Form</title>
</head>
<body onload="myFunction()">
<form action="user?action=registernewuser" method="post">
<table>
	<tr>
				<td>UserId</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>UserPassword</td>
				<td><input type="text" name="userpassword"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
</table>

				
	</form>		
</body>
</html>
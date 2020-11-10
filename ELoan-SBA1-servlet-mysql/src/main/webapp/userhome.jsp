<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user home</title>
</head>
<body onload="myFunction()">
<form action="user?action=validate" method="post">
<jsp:include page="header.jsp"/>
<h4>User Login</h4>
<div align="right"><a href="index.jsp">Logout</a></div>
<table>
			<tr>
				<td>UserId</td>
				<td><input type="text" name="UserId"></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="UserName"></td>
			</tr>
			<tr>
				<td>UserPassword</td>
				<td><input type="text" name="UserPassword"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
</table>
<a href="newuserui.jsp">New User Registration</a><br>
<jsp:include page="footer.jsp"/>
</form>
</body>
</html>
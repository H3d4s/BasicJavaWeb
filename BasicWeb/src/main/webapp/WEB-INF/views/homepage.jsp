<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
</head>
<body>
	<h2>Welcome to the Home Page</h2>
	<form action="LoginServlet" method="post">
		Username: <input type="text" name="username" /><br> Password: <input
			type="password" name="password" /><br> <input type="submit"
			value="Login">
	</form>
	<a href="register.jsp">Register</a>
</body>
</html>

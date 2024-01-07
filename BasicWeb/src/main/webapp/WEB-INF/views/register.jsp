<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Register Page</title>
</head>
<body>
	<h2>Register a New Account</h2>
	<form action="RegisterServlet" method="post">
		Username: <input type="text" name="username" required><br>
		Password: <input type="password" name="password" required><br>
		Role: <select name="role">
			<option value="user">User</option>
			<option value="admin">Admin</option>
		</select><br> <input type="submit" value="Register">
	</form>
</body>
</html>

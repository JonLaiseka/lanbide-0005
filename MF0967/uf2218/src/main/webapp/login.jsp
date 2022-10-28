<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="login" method="post">
		<input name="user" placeholder="Usuario">
		<input name="pass" type="password" placeholder="Contraseña">
		<button>Login</button>
		<span class="error"><%= request.getAttribute("error") %></span>
		<span class="error">${error}</span>
	</form>
</body>
</html>

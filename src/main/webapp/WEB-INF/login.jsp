<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login Page</h1>
<br/>
<form method="post" action="login">
    <p>
        <input type="text" placeholder="Input username..." name="username">
    </p>
    <p>
        <input type="password" placeholder="Input password..." name="password">
    </p>
    <p>
        <input type="submit" value="Login">
    </p>
</form>
</body>
</html>
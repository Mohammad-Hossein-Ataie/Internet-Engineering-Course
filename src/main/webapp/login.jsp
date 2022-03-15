<%@ page import="org.example.CA1.httpServlet.GetData" %><%--
  Created by IntelliJ IDEA.
  User: MHAT
  Date: 3/13/2022
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <form action="login" method="POST">
        <label>Email:</label>
        <input type="text" name="email" value="">
        <button type="submit">Login</button>
    </form>
</body>
</html>

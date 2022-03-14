<%--
  Created by IntelliJ IDEA.
  User: MHAT
  Date: 3/14/2022
  Time: 6:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <c:forEach items="${movies}" var="movie">
            <tr>
                <td>${movie.name}</td>
                <td><a href="movie?id=${movie.id}">detail</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

<%@ page import="org.example.CA1.DAO.UserDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Actor</title>
    <style>
        li, td, th {
            padding: 5px;
        }
    </style>
</head>
<body>
<a href="/home.jsp">Home</a>
<p id="email">email: <%= UserDAO.getEnrolledID()%></p>
<ul>
    <li id="name">name: </li>
    <li id="birthDate">birthDate: </li>
    <li id="nationality">nationality: </li>
    <li id="tma">Total movies acted in: </li>
</ul>
<table>
    <tr>
        <th>Movie</th>
        <th>imdb Rate</th>
        <th>rating</th>
        <th>page</th>
    </tr>
</table>
<%--<table>--%>
<%--    <tr>--%>
<%--        <th>Movie</th>--%>
<%--        <th>imdb Rate</th>--%>
<%--        <th>rating</th>--%>
<%--        <th>page</th>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>No Time to Die</td>--%>
<%--        <td>7.3</td>--%>
<%--        <td>8</td>--%>
<%--        <td><a href="/movies/01">Link</a></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>The Night Clerk</td>--%>
<%--        <td>5.6</td>--%>
<%--        <td>5</td>--%>
<%--        <td><a href="/movies/02">Link</a></td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>Knives Out</td>--%>
<%--        <td>7.9</td>--%>
<%--        <td>8</td>--%>
<%--        <td><a href="/movies/03">Link</a></td>--%>

<%--    </tr>--%>
<%--</table>--%>
</body>
</html>
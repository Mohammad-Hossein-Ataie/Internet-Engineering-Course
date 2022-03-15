<%@ page import="DAO.UserDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Movie</title>
    <style>
        li, td, th {
            padding: 5px;
        }
    </style>
</head>
<body>
<a href="/home.jsp">Home</a>
<p id="email">email: <%= UserDAO.getEnrolledID()%></p>

<%--list--%>

<h3>Cast</h3>
<table>
    <tr>
        <th>name</th>
        <th>age</th>
    </tr>
</table>

<form action="" method="POST">
    <label>Rate(between 1 and 10):</label>
    <input type="number" id="quantity" name="quantity" min="1" max="10">
<%--    <input type="hidden" id="form_action" name="action" value="rate">--%>
<%--    <input type="hidden" id="form_movie_id" name="movie_id" value="01">--%>
    <button type="submit">rate</button>
</form>

<form action="" method="POST">
    <label>Your Comment:</label>
    <input type="text" name="comment" value="">
<%--    <input type="hidden" id="form_action" name="action" value="comment">--%>
<%--    <input type="hidden" id="form_movie_id" name="movie_id" value="01">--%>
    <button type="submit">Add Comment</button>
</form>
</body>
</html>

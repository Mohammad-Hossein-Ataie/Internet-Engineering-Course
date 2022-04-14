<%@ page import="java.util.List" %>
<%@ page import="org.example.CA1.Entity.Movie" %>
<%@ page import="org.example.CA1.DAO.MovieDAO" %>
<%@ page import="org.example.CA1.DAO.UserDAO" %><%--
  Created by IntelliJ IDEA.
  User: MHAT
  Date: 3/14/2022
  Time: 6:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movies</title>
</head>
<body>
    <% List<Movie> movies = MovieDAO.getUserSearchedMovies();%>

    <a href="/home.jsp">Home</a>
    <p id="email">email: <%= UserDAO.getEnrolledID()%></p>
    <br><br>
    <form action="movies" method="POST">
        <label>Search:</label>
        <input type="text" name="search" value="">
        <button type="submit" name="action" value="search">Search</button>
        <button type="submit" name="action" value="clear">Clear Search</button>
    </form>
    <br><br>
    <form action="movies" method="POST">
        <label>Sort By:</label>
        <button type="submit" name="action" value="sort_by_imdb">imdb Rate</button>
        <button type="submit" name="action" value="sort_by_date">releaseDate</button>
    </form>
    <br>
    <table>
        <tr>
            <th>name</th>
            <th>summary</th>
            <th>releaseDate</th>
            <th>director</th>
            <th>writers</th>
            <th>genres</th>
            <th>cast</th>
            <th>imdb Rate</th>
            <th>rating</th>
            <th>duration</th>
            <th>ageLimit</th>
            <th>Links</th>
        </tr>
        <%if(movies.size() != 0) {
            for (int i = 0; i < movies.size(); i++){
            String id = String.valueOf(movies.get(i).getId());
            String href = "/movies/"+id;%>
            <tr>
<%--                <%=%>--%>
                <td><%= movies.get(i).getName()%></td>
                <td><%= movies.get(i).getSummary()%></td>
                <td><%= movies.get(i).getReleaseDate()%></td>
                <td><%= movies.get(i).getDirector()%></td>
                <td><%= movies.get(i).getWritersString()%></td>
                <td><%= movies.get(i).getGenreString()%></td>
                <td><%= movies.get(i).getCastString()%></td>
                <td><%= movies.get(i).getImdbRate()%></td>
                <td><%= movies.get(i).getRating()%></td>
                <td><%= movies.get(i).getDuration()%></td>
                <td><%= movies.get(i).getAgeLimitString()%></td>
                <td><a href=<%=href%>>Link</a></td>
            </tr>
        <%}}%>

<%--    <table>--%>
<%--        <c:forEach items="${movies}" var="movie">--%>
<%--            <tr>--%>
<%--                <td>${movie.name}</td>--%>
<%--                <td><a href="movie?id=${movie.id}">detail</a></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
</body>
</html>

<%@ page import="org.example.CA1.DAO.UserDAO" %>
<%@ page import="org.example.CA1.Entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.CA1.Entity.Movie" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WatchList</title>
    <style>
        li, td, th {
            padding: 5px;
        }
    </style>
</head>
<body>
    <%
        String email = UserDAO.getEnrolledID();
        String[] name = email.split("@");
    %>
    <a href="/home.jsp">Home</a>
    <p id="email">email: <%= email%></p>
    <ul>
        <li id="name">name: <%=name[0]%></li>
        <li id="nickname">nickname: @<%=name[0]%></li>
    </ul>

    <%
        User user = UserDAO.getUserBymail(UserDAO.getEnrolledID());
        List<Movie> movies = user.getWatchList();
    %>
    <h2>Watch List</h2>
    <table>
        <tr>
            <th>Movie</th>
            <th>releaseDate</th>
            <th>director</th>
            <th>genres</th>
            <th>imdb Rate</th>
            <th>rating</th>
            <th>duration</th>
            <th></th>
            <th></th>
        </tr>
        <%if(movies.size() != 0){
            for(int i = 0; i< movies.size(); i++) {

        %>
            <tr>
                <td><%=movies.get(i).getName()%></td>
                <td><%=movies.get(i).getReleaseDate()%></td>
                <td><%=movies.get(i).getDirector()%></td>
                <td><%=movies.get(i).getGenreString()%></td>
                <td><%=movies.get(i).getImdbRate()%></td>
                <td><%=movies.get(i).getRating()%></td>
                <td><%=movies.get(i).getDuration()%></td>
                <td><a href="/movies/"+<%= String.valueOf(movies.get(i).getId())%>>Link</a></td>
                <td>
                    <form action="" method="POST" >
                        <input id="form_movie_id" type="hidden" name="remove-movie" value=<%=movies.get(i).getId()%>>
                        <button type="submit">Remove</button>
                    </form>
                </td>
            </tr>
        <%}}%>
    </table>

    <h2>Recommendation List</h2>
    <table>
        <tr>
            <th>Movie</th>
            <th>imdb Rate</th>
            <th></th>
        </tr>
    </table>
</body>
</html>
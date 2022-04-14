<%@ page import="org.example.CA1.DAO.UserDAO" %>
<%@ page import="org.example.CA1.DAO.ActorDAO" %>
<%@ page import="org.example.CA1.Entity.Actor" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.CA1.Entity.Movie" %>
<%@ page import="org.example.CA1.DAO.MovieDAO" %>

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
    <%
        Actor actor = ActorDAO.findByID(ActorDAO.getSeaechedActor());
        List<Movie> moviesActed = ActorDAO.getMovieActed(ActorDAO.getSeaechedActor());
    %>
    <a href="/home.jsp">Home</a>
    <p id="email">email: <%= UserDAO.getEnrolledID()%></p>
    <% if(actor != null){%>
        <ul>
            <li id="name">name: <%= actor.getName()%></li>
            <li id="birthDate">birthDate: <%= actor.getBirthDate()%></li>
            <li id="nationality">nationality: <%= actor.getNationality()%></li>
            <li id="tma">Total movies acted in: <%= moviesActed.size()%></li>
        </ul>

        <% if(moviesActed.size() != 0){%>

            <table>
                <tr>
                    <th>Movie</th>
                    <th>imdb Rate</th>
                    <th>rating</th>
                    <th>page</th>
                </tr>

                <%for (int i = 0; i < moviesActed.size(); i++){%>

                    <tr>
                        <td><%=moviesActed.get(i).getName()%></td>
                        <td><%=moviesActed.get(i).getImdbRate()%></td>
                        <td><%=moviesActed.get(i).getRating()%></td>
                        <%
                            MovieDAO.setSelectedMovie(moviesActed.get(i).getId());
                        %>
                        <td><a href = "movie.jsp">Link</a></td>
                    </tr>

                <%}%>
            </table>
        <%}%>

    <%}%>
</body>
</html>
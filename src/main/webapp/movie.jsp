<%@ page import="org.example.CA1.DAO.UserDAO" %>
<%@ page import="org.example.CA1.Entity.Movie" %>
<%@ page import="org.example.CA1.DAO.MovieDAO" %>
<%@ page import="org.example.CA1.Entity.Actor" %>
<%@ page import="org.example.CA1.DAO.ActorDAO" %>
<%@ page import="org.example.CA1.Entity.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.CA1.DAO.CommentDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.example.CA1.Entity.User" %>
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
    <%
        Movie movie = MovieDAO.getMovieByID(MovieDAO.getSelectedMovie());
        List<Actor> actors = new ArrayList<>();
    %>

    <a href="/home.jsp">Home</a>
    <p id="email">email: <%= UserDAO.getEnrolledID()%></p>

<% if(movie != null){%>
    <ul>
        <li id="name">name: <%= movie.getName()%></li>
        <li id="summary">summary: <%=movie.getSummary()%></li>
        <li id="releaseDate">releaseDate: <%=movie.getReleaseDate()%></li>
        <li id="director">director: <%=movie.getDirector()%></li>
        <li id="writers">writers: <%=movie.getWritersString()%></li>
        <li id="genres">genres: <%=movie.getGenreString()%></li>
        <li id="imdbRate">imdbRate: <%=movie.getImdbRate()%></li>
        <li id="rating">rating: <%=movie.getRating()%></li>
        <li id="duration">duration: <%=movie.getDuration()%></li>
        <li id="ageLimit">ageLimit: <%=movie.getAgeLimitString()%></li>
    </ul>

    <h3>Cast</h3>
    <table>
        <tr>
            <th>name</th>
            <th>age</th>
            <th></th>
        </tr>
        <%
            if(movie != null){
            for(int i = 0; i < movie.getCast().size(); i++) {
                actors.add(ActorDAO.findByID(movie.getCast().get(i)));
            }}
        %>
        <%if (actors != null){
            for (int i = 0; i < actors.size(); i++){%>
            <tr>
                <td> <%= actors.get(i).getName()%> </td>
                <td> <%= actors.get(i).getBirthDate()%> </td>
                <td><a href="/actors/"+<%= String.valueOf(actors.get(i).getId())%>>Link</a></td>
            </tr>
        <%
            }}
        %>
    </table>
    <br>
    <form action="" method="POST">
        <label>Rate(between 1 and 10):</label>
        <input type="number" id="quantity" name="quantity" min="1" max="10">
    <%--    <input type="hidden" id="form_action" name="action" value="rate">--%>
    <%--    <input type="hidden" id="form_movie_id" name="movie_id" value="01">--%>
        <button type="submit">rate</button>
    </form>

    <br>

    <form action="" method="POST">
        <input type="hidden" id="form_action" name="watchlist" value="add">
<%--        <input type="hidden" id="form_movie_id" name="movie_id" value="01">--%>
        <button type="submit">Add to WatchList</button>
    </form>

    <br>
    <%
        List<Comment> comments = CommentDAO.getComments();
        List<Comment> movieComments = new ArrayList<>();
        comments.forEach(comment -> {
            if (comment.getMovieId() == movie.getId()){
                movieComments.add(comment);
            }
        });
    %>
    <table>
        <tr>
            <th>nickname</th>
            <th>comment</th>
            <th></th>
            <th></th>
        </tr>
        <%if(movieComments.size() != 0){
            for (int i = 0; i < movieComments.size(); i++){
        %>
            <tr>
                <%
                    User user = UserDAO.getUserBymail(movieComments.get(i).getUserEmail());
                    String nikName = user.getName();
                %>
                <td><%=nikName%></td>
                <td><%=movieComments.get(i).getText()%></td>
                <td>
                    <form action="" method="POST">
                        <label></label>
                        <input
                                type="hidden"
                                name="comment_id"
                                value="03"
                        />
                        <input type="hidden" name="action" value="like">
                        <input type="hidden" name="movie_id" value="01">
                        <button type="submit">like</button>
                    </form>
                </td>
                <td>
                    <form action="" method="POST">
                        <label></label>
                        <input
                                type="hidden"
                                name="comment_id"
                                value="03"
                        />
                        <input type="hidden" name="action" value="dislike">
                        <input type="hidden" name="movie_id" value="01">
                        <button type="submit">dislike</button>
                    </form>
                </td>
            </tr>
        <%}}%>
    </table>

    <form action="" method="POST">
        <label>Your Comment:</label>
        <input type="text" name="comment" value="">
    <%--    <input type="hidden" id="form_action" name="action" value="comment">--%>
    <%--    <input type="hidden" id="form_movie_id" name="movie_id" value="01">--%>
        <button type="submit">Add Comment</button>
    </form>
<%}%>
</body>
</html>

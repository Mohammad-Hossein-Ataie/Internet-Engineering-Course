package org.example.CA1.Controller;
import org.example.CA1.DAO.ActorDAO;
import org.example.CA1.DAO.ConnetctionPool;
import org.example.CA1.DAO.MovieDAO;
import org.example.CA1.Entity.Actor;
import org.example.CA1.Entity.Comment;
import org.example.CA1.Entity.Movie;
import org.example.CA1.Error.ActorNotFound;
import org.example.CA1.Manager.CommentManager;
import org.example.CA1.Manager.MovieManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@RestController
public class MovieController {

    public void isActorsValid(List<Actor> actors, Movie movie) throws ActorNotFound {
        for (int i = 0; i < actors.size(); i++) {
            if (movie.getCast().contains(actors.get(i))) {
                continue;
            } else {
                throw new ActorNotFound();
            }
        }
    }
    public static void addMovie(Movie movie) throws SQLException {
        MovieManager.addMovie(movie);
//        return "movie added successfully";
    }
    @GetMapping("/movies/date")
    public Object[] getSortByDate() throws SQLException {
        List<Movie>  res =  MovieDAO.sortMovies(1);
        return new Object[]{res};
    }
    @GetMapping("/movies/imdb")
    public Object[] getSortByRate() throws SQLException {
        List<Movie>  res =  MovieDAO.sortMovies(2);
        return new Object[]{res};
    }
    @GetMapping("/movies/{id}")
    public Object[] getMovieById(@PathVariable Integer id) throws SQLException {
        Movie temp = MovieManager.getMovieById(id);
        List <Integer> actorsID = temp.getCast();
        List <Actor> actors = new ArrayList<>();
        Connection connection = ConnetctionPool.getConnection();
        String query = "SELECT * FROM casts WHERE movieId=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            Actor actor = new Actor();
            int actorId = rs.getInt("actorId");
            query = "SELECT * FROM actor WHERE id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, actorId);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                actor.setId(result.getInt(1));
                actor.setName(result.getString(2));
                actor.setBirthDate(result.getString(3));
                actor.setNationality(result.getString(4));
                actor.setImage(result.getString(5));
            }
            actors.add(actor);
        }
        List <Comment> comments = CommentManager.getByID(id);
        statement.close();
        connection.close();
        return new Object[]{temp, actors, comments};
    }
    @GetMapping("/movies/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return MovieDAO.getMoviesByGenre(genre);
    }
    @GetMapping("/movies/name/{name}")
    public List<Movie> getMoviesByName(@PathVariable String name) {
        return MovieDAO.getMovieByName(name);
    }
    @GetMapping("/movies/date/{date}")
    public List<Movie> getMoviesByDate(@PathVariable String date) {
        return MovieDAO.getMovieByDate(date);
    }
    @GetMapping("/movies")
    public List<Movie> getMovies() throws SQLException {
        return MovieManager.getMoviesList();
    }
}

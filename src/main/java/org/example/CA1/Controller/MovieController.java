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
    public Object[] getSortByDate(){
        List<Movie>  temp;
        temp = MovieDAO.sortMovies(1);
        List<Movie> res = new ArrayList<>();
        for(int i = 0; i < 16; i++){
            res.add(temp.get(i));
        }
        return new Object[]{res};
    }
    @GetMapping("/movies/imdb")
    public Object[] getSortByRate(){
        List<Movie>  temp;
        temp = MovieDAO.sortMovies(2);
        List<Movie> res = new ArrayList<>();
        for(int i = 0; i < 16; i++){
            res.add(temp.get(i));
        }
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
            actor.setId(result.getInt(1));
            actor.setName(result.getString(2));
            actor.setBirthDate(result.getString(3));
            actor.setNationality(result.getString(4));
            actor.setImage(result.getString(5));
        }
        List <Comment> comments = CommentManager.getByID(id);
        return new Object[]{temp, actors, comments};
    }
    @GetMapping("/movies/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return MovieManager.getMoviesByGenre(genre);
    }
    @GetMapping("/movies/name/{name}")
    public List<Movie> getMoviesByName(@PathVariable String name) {
        return MovieManager.getMovieByName(name);
    }
    @GetMapping("/movies/date/{date}")
    public List<Movie> getMoviesByDate(@PathVariable String date) {
        return MovieManager.getMovieByDate(date);
    }
    @GetMapping("/movies")
    public List<Movie> getMovies() {
        List<Movie>  temp = new ArrayList<>();
        for(int i = 0; i < 12; i++){
            temp.add(MovieManager.getMoviesList().get(i));
        }
        return  temp;//returns json string
    }
}

package org.example.CA1.Manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.CA1.DAO.ConnetctionPool;
import org.example.CA1.DAO.MovieDAO;
import org.example.CA1.Entity.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private static boolean isUpdating(Movie movie) throws SQLException {
        Connection connection = ConnetctionPool.getConnection();
        Statement statement;
        statement = connection.createStatement();
        String query = "SELECT * FROM movie WHERE movie.id=?";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setInt(1, movie.getId());
        ResultSet res = preparedStmt.executeQuery();
        if (res.getString(1) != null) {
            return true;
        } else {
            return false;
        }
    }

    public static void addMovie(Movie movie) throws SQLException {
        if (isUpdating(movie))
            MovieDAO.update(movie);
        MovieDAO.add(movie);
    }
    public static List<Movie> getMoviesList() throws SQLException {
        List<Movie> movies = MovieDAO.getMovies();
        return movies;
    }

    public static Movie getMovieById(Integer id) {
        return MovieDAO.getMovieByID(id);
    }
}

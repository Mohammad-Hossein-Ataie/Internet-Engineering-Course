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
    public static List<Movie> getMoviesList() {
        List<Movie> movies = MovieDAO.getMovies();
        return movies;
    }

    public static Movie getMovieById(Integer id) {
        try {
            List<Movie> movies = new ArrayList<>();
            Connection connection = ConnetctionPool.getConnection();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM movie WHERE movie.id=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet res = preparedStmt.executeQuery();
            Movie movie = new Movie();
            movie.setId(res.getInt(1));
            movie.setName(res.getString(2));
            movie.setSummary(res.getString(3));
            movie.setReleaseDate(res.getString(4));
            movie.setDirector(res.getString(5));
            movie.setImdbRate(res.getFloat(6));
            movie.setDuration(res.getString(7));
            movie.setAgeLimit(res.getInt(8));
            movie.setImage(res.getString(9));
            movie.setCoverImage(res.getString(10));
            movie.setRating(res.getFloat(11));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Movie> getMoviesByGenre(String genre) {
//        List<Movie> movies = MovieDAO.getMovies();
//        System.out.println(movies.size());
//        List<Movie> moviesList = new ArrayList<>();
//        for (int i = 0; i < movies.size(); i++) {
//            for (int j = 0; j < movies.get(i).getGenre().size(); j++) {
//                if (movies.get(i).getGenre().get(j).equals(genre)) {
//                    moviesList.add(movies.get(i));
//                }
//            }
//        }
//        return movieList;
        try {
            List<Movie> movies = new ArrayList<>();
            Connection connection = ConnetctionPool.getConnection();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM movie m JOIN genres g ON m.id = g.movieId  WHERE g.genre=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, genre);
            ResultSet res = preparedStmt.executeQuery();
            while (res.next()){
                Movie movie = new Movie();
                movie.setId(res.getInt(12));
                movie.setName(res.getString(2));
                movie.setSummary(res.getString(3));
                movie.setReleaseDate(res.getString(4));
                movie.setDirector(res.getString(5));
                movie.setImdbRate(res.getFloat(6));
                movie.setDuration(res.getString(7));
                movie.setAgeLimit(res.getInt(8));
                movie.setImage(res.getString(9));
                movie.setCoverImage(res.getString(10));
                movie.setRating(res.getFloat(11));
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
        public static List<Movie> getMovieByName(String movieName) {
            try {
                List<Movie> movies = new ArrayList<>();
                Connection connection = ConnetctionPool.getConnection();
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM movie WHERE movie.movie_name LIKE ?";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, movieName);
                ResultSet res = preparedStmt.executeQuery();
                while (res.next()) {
                    Movie movie = new Movie();
                    movie.setId(res.getInt(1));
                    movie.setName(res.getString(2));
                    movie.setSummary(res.getString(3));
                    movie.setReleaseDate(res.getString(4));
                    movie.setDirector(res.getString(5));
                    movie.setImdbRate(res.getFloat(6));
                    movie.setDuration(res.getString(7));
                    movie.setAgeLimit(res.getInt(8));
                    movie.setImage(res.getString(9));
                    movie.setCoverImage(res.getString(10));
                    movie.setRating(res.getFloat(11));
                    movies.add(movie);
                }
                return movies;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
    }

    public static List<Movie> getMovieByDate(String date) {
        try {
            List<Movie> movies = new ArrayList<>();
            Connection connection = ConnetctionPool.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM movie WHERE movie.releaseDate=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, date);
            ResultSet res = preparedStmt.executeQuery();
            while (res.next()) {
                Movie movie = new Movie();
                movie.setId(res.getInt(1));
                movie.setName(res.getString(2));
                movie.setSummary(res.getString(3));
                movie.setReleaseDate(res.getString(4));
                movie.setDirector(res.getString(5));
                movie.setImdbRate(res.getFloat(6));
                movie.setDuration(res.getString(7));
                movie.setAgeLimit(res.getInt(8));
                movie.setImage(res.getString(9));
                movie.setCoverImage(res.getString(10));
                movie.setRating(res.getFloat(11));
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

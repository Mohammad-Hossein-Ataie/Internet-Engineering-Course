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
    private static boolean isUpdating(Movie movie) {
        if (MovieDAO.findByID(movie.getId()) != null) {
            return true;
        } else {
            return false;
        }
    }

    public static void addMovie(Movie movie) {
        if (isUpdating(movie))
            MovieDAO.update(movie);
        MovieDAO.add(movie);
    }
    public static List<Movie> getMoviesList() {
        List<Movie> movies = MovieDAO.getMovies();
        return movies;
    }

    public static Movie getMovieById(Integer id) {
        List<Movie> movies = MovieDAO.getMovies();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId() == id) {
                return movies.get(i);
            }
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
        List<Movie> movies = MovieDAO.getMovies();
        List<Movie> temp = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().contains(movieName)) {
                temp.add(movies.get(i));
            }
        }
        return temp;
    }

    public static List<Movie> getMovieByDate(String date) {
        List<Movie> movies = MovieDAO.getMovies();
        List<Movie> temp = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getReleaseDate().contains(date)) {
                temp.add(movies.get(i));
            }
        }
        return temp;
    }
}

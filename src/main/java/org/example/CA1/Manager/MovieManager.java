package org.example.CA1.Manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.CA1.DAO.MovieDAO;
import org.example.CA1.Entity.Movie;

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
        List<Movie> movies = MovieDAO.getMovies();
        System.out.println(movies.size());
        List<Movie> moviesList = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            for (int j = 0; j < movies.get(i).getGenre().size(); j++) {
                if (movies.get(i).getGenre().get(j).equals(genre)) {
                    moviesList.add(movies.get(i));
                }
            }
        }
        return moviesList;
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

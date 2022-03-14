package Manager;

import DAO.MovieDAO;
import Entity.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public static String getMoviesList() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        List<Movie> movies = MovieDAO.getMovies();
        List<String> moviesList = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            moviesList.add(gson.toJson(movies.get(i)));
        }
        return (gson.toJson(moviesList));
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
        List<Movie> moviesList = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            for (int j = 0; j < movies.get(i).getGenre().size(); j++) {
                if (movies.get(i).getGenre().get(j) == genre) {
                    moviesList.add(movies.get(i));
                }
            }
            return moviesList;
        }
        return movies;
    }

    public static int getMovieByName(String movieName) {
        List<Movie> movies = MovieDAO.getMovies();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName() == movieName) {
                return movies.get(i).getId();
            }
        }
        return -1;
    }

}

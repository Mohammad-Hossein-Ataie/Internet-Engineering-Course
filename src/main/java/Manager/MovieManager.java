package Manager;

import DAO.MovieDAO;
import Entity.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private static boolean isUpdating(Movie movie) {
        if (MovieDAO.findByID(movie.getId()) != null)
        {
            return true;
        }
        else {
            return  false;
        }
    }

    public static void addMovie(Movie movie) {
        if (isUpdating(movie))
            MovieDAO.update(movie);
        MovieDAO.add(movie);
    }

    public  static String getMoviesList() {
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
}

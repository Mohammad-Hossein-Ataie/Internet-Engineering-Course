package DAO;
import Entity.Movie;
import Entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieDAO {
    private static Map<Integer, Movie> movieIds = new HashMap<>();

    public static void setMovies(List<Movie> movies) {
        movies.addAll(movies);
    }

    private static List<Movie> movies = new ArrayList<>();
    public static void update(Movie movie) {
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).isSame(movie))
                movies.set(i,movie);
        }
    }
    public static Movie findByID(int id){
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getId() == id)
                return movies.get(i);
        }
        return null;
    }
    public static void add(Movie movie) {

        movies.add(movie);
        movieIds.put(movie.getId(),movie);
    }

    public static List<Movie> getMovies() {
        return movies;
    }

    public static Movie getMovieByID(Integer movieId) {
        return movieIds.get(movieId);
    }
}

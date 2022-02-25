package DAO;
import Entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
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
    }

    public static List<Movie> getMovies() {
        return movies;
    }
}

package DAO;
import Entity.Movie;
import Entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieDAO {
    private static Map<Integer, Movie> movieIds = new HashMap<>();

    private static Map<String,Map<Integer,Integer>> userRateMovie = new HashMap<>();
    private static Map<Integer,Integer> scoreMovies =new HashMap<>();

    public static void setRateMovie(String userId,int rate,int movieId){
        userRateMovie.put(userId,new HashMap(){{put(rate,movieId);}});
        scoreMovies.put(movieId,rate);
    }
    public static float getRateMovie(Integer movieId){
        int score = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : scoreMovies.entrySet()) {
            if(movieId == entry.getKey()) {
                count = count + 1;
                score = score + entry.getValue();
            }
        }
        Movie newMovie = MovieDAO.findByID(movieId);
        if (count == 0) {
            newMovie.setRating(0);
            return 0;
        }
        float rating = score/count;
        newMovie.setRating(rating);
        return rating;
    }
    public static void setMovies(List<Movie> newMovies) {
        movies.addAll(newMovies);
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

        for (Movie result : movies) {
            if (result.getId()==movieId){
                return result;
            }
        }
        return null;
    }
}

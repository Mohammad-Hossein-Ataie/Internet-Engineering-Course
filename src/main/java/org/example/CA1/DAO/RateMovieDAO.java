package org.example.CA1.DAO;

import org.example.CA1.Entity.Movie;
import org.example.CA1.Entity.RateMovie;

import java.util.HashMap;
import java.util.Map;

public class RateMovieDAO {
//    private static Map<String, Float> userScore = new HashMap<>();
//    private static Map<Float,Integer> movieScore = new HashMap<>();
    public static void rateMovie(RateMovie rateMovie){
        Integer movieID = rateMovie.getMovieId();
        Movie movie = MovieDAO.getMovieByID(movieID);
        movie.setRating(rateMovie.getScore());
//        userScore.put(rateMovie.getUserEmail(),rateMovie.getScore());
//        movieScore.put(rateMovie.getScore(),rateMovie.getMovieId());
    }
}

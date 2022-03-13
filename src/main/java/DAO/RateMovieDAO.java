package DAO;

import Entity.Comment;
import Entity.RateMovie;
import Entity.User;

import java.util.HashMap;
import java.util.Map;

public class RateMovieDAO {
    private static Map<String, Integer> userScore = new HashMap<>();
    private static Map<Integer,Integer> movieScore = new HashMap<>();
    public static void rateMovie(RateMovie rateMovie){
        userScore.put(rateMovie.getUserEmail(),rateMovie.getScore());
        movieScore.put(rateMovie.getScore(),rateMovie.getMovieId());
    }
}

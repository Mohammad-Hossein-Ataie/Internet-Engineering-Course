package org.example.CA1.Entity;

import java.util.ArrayList;
import java.util.List;

public class RateMovie {
//    private List<Movie> movies = new ArrayList<>();
//    private List<User> users = new ArrayList<>();
    private String userEmail;
    private Integer movieId;

    public Integer getScore() {
        return score;
    }

    private Integer score;
    public int getMovieId() {
        return movieId;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public RateMovie(String userEmail, Integer movieId, Integer score) {
        this.userEmail = userEmail;
        this.movieId = movieId;
        this.score = score;
    }

    public boolean isScoreValid(Integer score) {
        return score > 0 && score <= 10;
    }

}

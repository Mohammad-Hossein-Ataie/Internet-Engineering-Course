package org.example.CA1.Entity;

public class RateMovie {
//    private List<Movie> movies = new ArrayList<>();
//    private List<User> users = new ArrayList<>();
    private String userEmail;
    private Integer movieId;

    public Float getScore() {
        return score;
    }

    private Float score;
    public int getMovieId() {
        return movieId;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public RateMovie(String userEmail, Integer movieId, Float score) {
        this.userEmail = userEmail;
        this.movieId = movieId;
        this.score = score;
    }

    public boolean isScoreValid(Float score) {
        return score > 0 && score <= 10;
    }

}

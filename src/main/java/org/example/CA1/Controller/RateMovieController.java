package org.example.CA1.Controller;

import org.example.CA1.Entity.RateMovie;
import org.example.CA1.Error.MovieNotExist;
import org.example.CA1.Error.UserNotExist;
import org.example.CA1.Error.InvalidRateScore;
import org.example.CA1.Manager.RateMovieManager;

public class RateMovieController {
    public static String rateMovie(RateMovie rateMovie) throws UserNotExist, MovieNotExist ,InvalidRateScore {
        if (rateMovie.isScoreValid(rateMovie.getScore())) {
            if (RateMovieManager.movieExist(rateMovie)) {
                if (RateMovieManager.userExist(rateMovie)) {
                    RateMovieManager.rateMovie(rateMovie);
                    return "movie rated successfully";
                } else {
                    throw new UserNotExist();
                }
            } else {
                throw new MovieNotExist();
            }
        }
        else {
            throw new InvalidRateScore();
        }
    }
}


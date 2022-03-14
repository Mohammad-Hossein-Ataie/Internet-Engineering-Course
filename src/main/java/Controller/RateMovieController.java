package Controller;

import Entity.RateMovie;
import Error.MovieNotExist;
import Error.UserNotExist;
import Error.InvalidRateScore;
import Manager.RateMovieManager;

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


package org.example.CA1.Controller;

import org.example.CA1.Entity.RateMovie;
import org.example.CA1.Error.InvalidRateScore;
import org.example.CA1.Error.MovieNotExist;
import org.example.CA1.Error.UserNotExist;
import org.example.CA1.Manager.RateMovieManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateMovieController {
    @PostMapping("/movies/rate")
    public void rateMovie(@RequestBody RateMovie rateMovie) throws UserNotExist, MovieNotExist ,InvalidRateScore {
//        if (rateMovie.isScoreValid(rateMovie.getScore())) {
//            if (RateMovieManager.movieExist(rateMovie)) {
//                if (RateMovieManager.userExist(rateMovie)) {
                    RateMovieManager.rateMovie(rateMovie);
//                } else {
//                    throw new UserNotExist();
//                }
//            } else {
//                throw new MovieNotExist();
//            }
//        }
//        else {
//            throw new InvalidRateScore();
//        }
    }
}


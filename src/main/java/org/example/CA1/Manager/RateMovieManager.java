package org.example.CA1.Manager;

import org.example.CA1.DAO.MovieDAO;
import org.example.CA1.DAO.UserDAO;
import org.example.CA1.Entity.RateMovie;
import org.example.CA1.Entity.User;
import org.example.CA1.DAO.RateMovieDAO;
import java.util.Map;

public class RateMovieManager {
    public static void rateMovie(RateMovie rateMovie) {
        RateMovieDAO.rateMovie(rateMovie);
    }

    public static boolean movieExist(RateMovie rateMovie) {
        if (MovieDAO.findByID(rateMovie.getMovieId()) != null) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean userExist(RateMovie rateMovie) {
        Map<String, User> userMails = UserDAO.getUsersMails();
        if (userMails.containsValue(rateMovie.getUserEmail())) {
            return true;
        }
        else{
            return false;
        }
    }
}

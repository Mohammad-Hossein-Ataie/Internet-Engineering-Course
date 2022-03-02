package Manager;

import DAO.CommentDAO;
import DAO.MovieDAO;
import DAO.UserDAO;
import Entity.Comment;
import Entity.RateMovie;
import Entity.User;
import DAO.RateMovieDAO;
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

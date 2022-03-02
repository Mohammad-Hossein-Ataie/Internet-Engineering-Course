package Manager;

import DAO.CommentDAO;
import DAO.MovieDAO;
import DAO.UserDAO;
import Entity.Comment;
import Entity.User;

import java.util.Map;

public class CommentManager {
    public static void addComment(Comment comment) {
        CommentDAO.addComment(comment);
    }

    public static boolean movieExist(Comment comment) {
        if (MovieDAO.findByID(comment.getMovieId()) != null) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean userExist(Comment comment) {
        Map<String, User> userMails = UserDAO.getUsersMails();
        if (userMails.containsValue(comment.getUserEmail())) {
            return true;
        }
        else{
            return false;
        }
    }
}

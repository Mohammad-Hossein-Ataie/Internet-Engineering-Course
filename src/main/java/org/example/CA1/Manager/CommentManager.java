package org.example.CA1.Manager;

import org.example.CA1.DAO.CommentDAO;
import org.example.CA1.DAO.MovieDAO;
import org.example.CA1.DAO.UserDAO;
import org.example.CA1.Entity.Comment;
import org.example.CA1.Entity.User;

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

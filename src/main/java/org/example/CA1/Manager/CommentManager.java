package org.example.CA1.Manager;

import org.example.CA1.DAO.CommentDAO;
import org.example.CA1.DAO.MovieDAO;
import org.example.CA1.DAO.UserDAO;
import org.example.CA1.Entity.Comment;
import org.example.CA1.Entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentManager {
    public static void addComment(Comment comment) throws SQLException {
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

    public static List<Comment> getByID(Integer id) {
        List <Comment> comments = new ArrayList<>();
        for(int i = 0; i < CommentDAO.getComments().size(); i++){
            if(CommentDAO.getComments().get(i).getMovieId() == id){
                comments.add(CommentDAO.getComments().get(i));
            }
        }
        return comments;
    }
}

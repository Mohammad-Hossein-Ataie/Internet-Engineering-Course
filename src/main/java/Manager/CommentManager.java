package Manager;

import DAO.CommentDAO;
import Entity.Comment;

public class CommentManager {
    public static void addComment(Comment comment) {
        CommentDAO.addComment(comment);
    }

    public static boolean movieExist(Comment comment) {

        return true;
    }

    public static boolean userExist(Comment comment) {
        return true;
    }
}

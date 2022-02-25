package Manager;

import DAO.CommentDAO;
import DAO.UserDAO;
import Entity.Comment;

public class CommentManager {
    public void addComment(Comment comment) {
        CommentDAO.addComment(comment);
    }
}

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


    public static List<Comment> getByID(Integer id) throws SQLException {
        List <Comment> comments;
        comments = CommentDAO.getComments(id);
        return comments;
    }
}

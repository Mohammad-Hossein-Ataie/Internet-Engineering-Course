package DAO;

import Entity.Comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentDAO {
    public static int getCount() {
        return count++;
    }

    private static int count = 0;

    // addComment 1
    private static Map<Integer, Comment> usersComments = new HashMap<>();

    public static List<Integer> getComments() {
        return comments;
    }

    private static List<Integer> comments = new ArrayList<>();
    public static void addComment(Comment comment){
        setID(comment);
        setTime(comment);
        usersComments.put(comment.getMovieId(),comment);
    }
    // set id with getCount
    public static void setID(Comment comment){
        comments.add(getCount());
        comment.setCommentID(getCount());
    }
    // set time     //LocalDateTime.now()
    public static void setTime(Comment comment){
        comment.setCommentID(getCount());
    }
}

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

    public static Map<Integer, Comment> getUsersComments() {
        return usersComments;
    }

    // addComment 1
    private static Map<Integer, Comment> usersComments = new HashMap<>();

    public static List<Comment> getComments() {
        return comments;
    }

    private static List<Comment> comments = new ArrayList<>();
    public static void addComment(Comment comment){
        setTime(comment);
        usersComments.put(comment.getMovieId(),comment);
    }
    // set time     //LocalDateTime.now()
    public static void setTime(Comment comment){
        comment.setCommentID(getCount());
    }

    public static void setComments(List<Comment> newComments) {
        count = 0;
        for (Comment comment : newComments) {
            count += 1;
            usersComments.put(count, comment);
            comments.add(comment);
        }
    }
}

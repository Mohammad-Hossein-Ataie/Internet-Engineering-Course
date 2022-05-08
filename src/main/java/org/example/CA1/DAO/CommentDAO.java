package org.example.CA1.DAO;

import org.example.CA1.Entity.Actor;
import org.example.CA1.Entity.Comment;
import org.example.CA1.Entity.Movie;

import java.sql.*;
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
        Movie movie = MovieDAO.getMovieByID(comment.getMovieId());

        usersComments.put(comment.getMovieId(),comment);
    }
    // set time     //LocalDateTime.now()
    public static void setTime(Comment comment){
        comment.setCommentID(getCount());
    }

//    public static void setComments(List<Comment> newComments) {
//        count = 0;
//        for (Comment comment : newComments) {
//            count += 1;
//            usersComments.put(count, comment);
//            comments.add(comment);
//        }
//    }
public static void setComments(List<Comment> newComment) throws SQLException {
    Statement statement;
    try {
        Connection connection = ConnetctionPool.getConnection();
        statement = connection.createStatement();
        for(Comment comment:newComment) {
            String query = "SELECT * FROM Comment WHERE id=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1,comment.getCommentID());
            ResultSet result = preparedStmt.executeQuery();
            if(result.next()){
                continue;
            }
            statement.close();
            query = " INSERT INTO Comment (userEmail, movieId, text)"
                    + " values (?, ?, ?)";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, comment.getUserEmail());
            preparedStmt.setInt(2,comment.getMovieId());
            preparedStmt.setString(3,comment.getText());
            preparedStmt.executeUpdate();
        }
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public static Comment getCommentByID(Integer id) {
        for(int i = 0; i <comments.size();i++){
            if(comments.get(i).getCommentID() == id){
                return comments.get(i);
            }
        }
        return null;
    }
}

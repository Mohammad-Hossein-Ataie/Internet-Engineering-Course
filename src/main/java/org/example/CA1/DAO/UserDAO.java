package org.example.CA1.DAO;

import org.example.CA1.Entity.Movie;
import org.example.CA1.Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {
    public static String getEnrolledID() {
        return enrolledID;
    }
    public static void setEnrolledID(String enrolledID) throws SQLException {
        UserDAO.enrolledID = enrolledID;
        User.enrolledUsers.add(UserDAO.getUserByMail(enrolledID));
    }

    private static String enrolledID = "";
    public static void addEnrolled(String enrolled) throws SQLException {
         setEnrolledID(enrolled);
    }
    public static Map<String, User> getUsersMails() {
        return usersMails;
    }

    private static Map<String, User> usersMails = new HashMap<>();

    public static Map<String, Integer> getWatchListUser() {
        return watchListUser;
    }

    private static Map<String, Integer> watchListUser = new HashMap<>();

    public static List<User> getUsers() {
        return users;
    }

    private static List<User> users = new ArrayList<>();



    public static List<String> getMails() {
        return mails;
    }

    private static List<String> mails = new ArrayList<>(usersMails.keySet());
    public static void addUser(User user){
        usersMails.put(user.getEmail(),user);
    }

    public static void addToWatchList(User user, Movie movie) throws SQLException {
        Statement statement;
        Connection connection = ConnetctionPool.getConnection();
        statement = connection.createStatement();
        String query = " INSERT INTO watchList (userEmail, movieId)"
                + " values (?, ?)";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1,user.getEmail());
        preparedStmt.setInt(2,movie.getId());
        preparedStmt.executeUpdate();
        statement.close();
    }

    public static User getUserByMail(String mail) throws SQLException {
        Connection connection = ConnetctionPool.getConnection();
        Statement statement;
        statement = connection.createStatement();
        String query = "SELECT * FROM user WHERE user.email=?";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, mail);
        ResultSet res = preparedStmt.executeQuery();
        User user = new User();
        if(res.next()){
            user.setEmail(res.getString(1));
            user.setPassword(res.getString(2));
            user.setNickname(res.getString(3));
            user.setName(res.getString(4));
            user.setBirthDate(res.getDate(5));
        }
        res.close();
        statement.close();
        connection.close();
        return user;
    }
    public static boolean IsInMails(String mail) {
        for (int i = 0; i < UserDAO.getUsers().size(); i++) {
            System.out.println(UserDAO.getUsers().get(i).getEmail());
            if (UserDAO.getUsers().get(i).getEmail().equals(mail)) {
                return true;
            }
        }
        return false;
    }
    public static void removeFromWatchList(int id) throws SQLException {
        Connection connection = ConnetctionPool.getConnection();
        Statement statement = connection.createStatement();
        String query = "DELETE FROM watchlist WHERE movieId = ?";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setInt(1,id);
        preparedStmt.executeUpdate();
        connection.close();
        statement.close();
    }
    public static void setUsers(List<User> newUsers) throws SQLException {
        Statement statement;
        try {
            Connection connection = ConnetctionPool.getConnection();
            statement = connection.createStatement();
            for(User user:newUsers) {
                String query = "SELECT * FROM user WHERE email=?";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1,user.getEmail());
                ResultSet result = preparedStmt.executeQuery();
                if(result.next()){
                    continue;
                }
                statement.close();
                query = " INSERT INTO user (email, password, nickname, name, birthDate)"
                        + " values (?, ?, ?, ?, ?)";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, user.getEmail());
                preparedStmt.setString(2, String.valueOf(user.getPassword().hashCode()));
                preparedStmt.setString(3, user.getNickname());
                preparedStmt.setString(4, user.getName());
                preparedStmt.setDate(5,  new Date(user.getBirthDate().getTime()));
                preparedStmt.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Movie> getWatchList(User user) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        Connection connection = ConnetctionPool.getConnection();
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM watchList WHERE userEmail = ? ";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, user.getEmail());
        ResultSet res = preparedStmt.executeQuery();
        List<Integer> movie_id = new ArrayList<>();
        while (res.next()) {
             movie_id.add(res.getInt(2));
        }
        statement.close();
        res.close();
        for(int i = 0; i<movie_id.size(); i++) {
            query = "SELECT * FROM movie WHERE id = ?";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, movie_id.get(i));
            res = preparedStmt.executeQuery();
            if (res.next()) {
                Movie movie = new Movie();
                movie.setId(res.getInt(1));
                movie.setName(res.getString(2));
                movie.setSummary(res.getString(3));
                movie.setReleaseDate(res.getString(4));
                movie.setDirector(res.getString(5));
                movie.setImdbRate(res.getFloat(6));
                movie.setDuration(res.getString(7));
                movie.setAgeLimit(res.getInt(8));
                movie.setImage(res.getString(9));
                movie.setCoverImage(res.getString(10));
                movie.setRating(res.getFloat(11));
                movies.add(movie);
            }
            statement.close();
        }
        connection.close();
        return movies;
    }
//    public static void setUsers(List<User> newUsers) {
//        users.addAll(newUsers);
//        for(int i = 0; i<newUsers.size(); i++){
//            String temp = newUsers.get(i).getEmail();
//            usersMails.put(temp,newUsers.get(i));
//        }
//
//    }
}

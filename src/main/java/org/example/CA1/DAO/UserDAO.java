package org.example.CA1.DAO;

import org.example.CA1.Entity.Movie;
import org.example.CA1.Entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {
    public static String getEnrolledID() {
        return enrolledID;
    }
    public static void setEnrolledID(String enrolledID) {
        UserDAO.enrolledID = enrolledID;
        User.enrolledUsers.add(UserDAO.getUserBymail(enrolledID));
    }

    private static String enrolledID = "";
    public static void addEnrolled(String enrolled){
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

    public static void addToWatchList(String email, int id) {
        Movie movie = MovieDAO.getMovieByID(id);
        User user = UserDAO.getUserBymail(email);
        user.setWatchList(movie);
        watchListUser.put(email,id);
    }

    public static User getUserBymail(String mail) {
        return usersMails.get(mail);
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
    public static void removeFromWatchList(String email, int id) {
        User user = UserDAO.getUserBymail(email);
        List<Movie> watchlist = user.getWatchList();
        for(int i = 0; i < watchlist.size(); i++){
            if(id == (watchlist.get(i).getId())){
                watchlist.remove(watchlist.get(i));
            }
        }
        watchListUser.remove(email,id);
    }
    public static void setUsers(List<User> newUsers) {
        users.addAll(newUsers);
        for(int i = 0; i<newUsers.size(); i++){
            String temp = newUsers.get(i).getEmail();
            usersMails.put(temp,newUsers.get(i));
        }

    }
}

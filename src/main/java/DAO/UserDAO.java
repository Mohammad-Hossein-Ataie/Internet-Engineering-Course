package DAO;

import Entity.Movie;
import Entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {
    public static Map<String, User> getUsersMails() {
        return usersMails;
    }
    public static Map<String,Map<Integer,Integer>> userRateMovie;
    private static Map<String, User> usersMails = new HashMap<>();
    private static Map<String, Integer> watchListUser = new HashMap<>();
    private static List<User> users = new ArrayList<>();
    public static List<Movie> getWatchList() {
        return watchList;
    }

    private static List<Movie> watchList = new ArrayList<>();

    public static List<String> getMails() {
        return mails;
    }

    private static List<String> mails = new ArrayList<>(usersMails.keySet());
    public static void addUser(User user){
        usersMails.put(user.getEmail(),user);
    }

    public static void addToWatchList(String email, int id) {
        watchListUser.put(email,id);
    }

    public static User getUserBymail(String mail) {
        return usersMails.get(mail);
    }

    public static void removeFromWatchList(String email, int id) {
        watchListUser.remove(email,id);
    }
    public static void rateMovie(String userId,int rate,int movieId){
            userRateMovie.put(userId,new HashMap(){{put(rate,movieId);}});
    }
    public static void setUsers(List<User> newUsers) {
        users.addAll(newUsers);
    }
}

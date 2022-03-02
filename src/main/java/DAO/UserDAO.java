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

    private static Map<String, User> usersMails = new HashMap<>();

    public static List<String> getMails() {
        return mails;
    }

    private static List<String> mails = new ArrayList<>(usersMails.keySet());
    public static void addUser(User user){
        usersMails.put(user.getEmail(),user);
    }
}

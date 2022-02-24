package DAO;

import Entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private static Map<String, User> usersMails = new HashMap<>();
    public static void addUser(User user){
        usersMails.put(user.getEmail(),user);
    }
}

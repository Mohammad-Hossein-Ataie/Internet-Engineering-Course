package org.example.CA1.Manager;
import org.example.CA1.DAO.UserDAO;
import org.example.CA1.Entity.Logedin;
import org.example.CA1.Entity.User;

import java.util.Date;

public class UserManager {
    
    public static boolean uniqueMail(User user) {
        for (String userItem : UserDAO.getMails())
            if (user.isSame(userItem))
                return false;
        return true;
    }
    public static void addUser(User user) {
        UserDAO.addUser(user);
    }
    public static boolean checkUser(String email){
        return UserDAO.IsInMails(email);
    }
    public static boolean checkAge(Date birthDate, int ageLimit) {
        //Period period = Period.between(birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
        return true;
    }

    public static void addToWatchList(String email, int id) {
        UserDAO.addToWatchList(email,id);
    }

    public static void removeFromWatchList(String email, int id) {
        UserDAO.removeFromWatchList(email,id);
    }

    public static boolean checkPassword(User user) {
        for(int i =0;i<UserDAO.getUsers().size();i++){
            if(UserDAO.getUsers().get(i).getEmail().equals(user.getEmail())&&
                    UserDAO.getUsers().get(i).getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }
}


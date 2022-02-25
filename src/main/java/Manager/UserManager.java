package Manager;
import DAO.UserDAO;
import Entity.User;


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
}


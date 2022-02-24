package Manager;
import DAO.UserDAO;
import Entity.User;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static List<User> users = new ArrayList<>();

    public static boolean uniqueMail(User user) {
        for (User userItem : users)
            if (userItem.isSame(user))
                return false;
        return true;
    }
    public static void addUser(User user) {
        UserDAO.addUser(user);
    }
}


package Controller;

import Entity.User;
import Manager.UserManager;
import Error.UserAlreadyExist;

public class UserController {
    public static String addUser(User user) throws UserAlreadyExist {
        if (UserManager.uniqueMail(user)) {
            UserManager.addUser(user);
            return "user added successfully";
        } else {
            throw new UserAlreadyExist();
        }
    }
}

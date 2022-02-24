package Controller;

import Entity.User;
import Manager.UserManager;
import Error.UserAlreadyExist;

public class UserController {
    public static void addUser(User user) throws UserAlreadyExist {
        if (UserManager.uniqueMail(user)) {
            UserManager.addUser(user);
        } else {
            throw new UserAlreadyExist();
        }
    }
}

package Manager;
import Entity.User;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users = new ArrayList<>();

    private boolean uniqueMail(User user) {
        for (User userItem : users)
            if (userItem.isSame(user))
                return false;
        return true;
    }
    public void addUser(User user) {
        if (uniqueMail(user)) {
            users.add(user);
        } else {
            //Call Exception in UserController
        }
    }
}


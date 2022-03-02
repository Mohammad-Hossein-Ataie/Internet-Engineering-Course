package Manager;

import DAO.VoteCommentDAO;
import DAO.UserDAO;
import Entity.RateMovie;
import Entity.User;
import Entity.VoteComment;

import java.util.Map;

public class VoteCommentManager {
    public static boolean userExist(VoteComment voteComment) {
        Map<String, User> userMails = UserDAO.getUsersMails();
        if (userMails.containsValue(voteComment.getEmail())) {
            return true;
        }
        else{
            return false;
        }
    }

    public static void voteComment(VoteComment voteComment) {
        VoteCommentDAO.voteComment(voteComment);
    }
}

package org.example.CA1.Manager;

import org.example.CA1.DAO.VoteCommentDAO;
import org.example.CA1.DAO.UserDAO;
import org.example.CA1.Entity.User;
import org.example.CA1.Entity.VoteComment;

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

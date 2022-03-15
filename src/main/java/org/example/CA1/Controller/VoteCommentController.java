package org.example.CA1.Controller;

import org.example.CA1.DAO.CommentDAO;
import org.example.CA1.Entity.VoteComment;
import org.example.CA1.Manager.VoteCommentManager;
import org.example.CA1.Error.UserNotExist;
import org.example.CA1.Error.CommentNotExist;
import org.example.CA1.Error.InvalidVoteValue;

public class VoteCommentController {
    public static String voteComment(VoteComment voteComment) throws UserNotExist, CommentNotExist, InvalidVoteValue {
        if (voteComment.isVoteValid(voteComment.getVote())) {
            if (CommentDAO.getComments().contains(voteComment.getCommentID())) {
                if (VoteCommentManager.userExist(voteComment)) {
                    VoteCommentManager.voteComment(voteComment);
                    return "comment voted successfully";
                } else {
                    throw new UserNotExist();
                }
            } else {
                throw new CommentNotExist();
            }
        }
        else {
            throw new InvalidVoteValue();
        }
    }
}

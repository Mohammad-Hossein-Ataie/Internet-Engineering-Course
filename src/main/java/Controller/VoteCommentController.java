package Controller;

import DAO.CommentDAO;
import Entity.VoteComment;
import Manager.VoteCommentManager;
import Error.UserNotExist;
import Error.CommentNotExist;
import Error.InvalidVoteValue;

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

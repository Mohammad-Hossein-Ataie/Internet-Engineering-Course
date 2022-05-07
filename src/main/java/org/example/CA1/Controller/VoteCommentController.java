package org.example.CA1.Controller;

import org.example.CA1.DAO.CommentDAO;
import org.example.CA1.Entity.VoteComment;
import org.example.CA1.Error.CommentNotExist;
import org.example.CA1.Error.InvalidVoteValue;
import org.example.CA1.Error.UserNotExist;
import org.example.CA1.Manager.VoteCommentManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteCommentController {
    @PostMapping("/movie/comment")
    public void voteComment(@RequestBody VoteComment voteComment) throws UserNotExist, CommentNotExist, InvalidVoteValue {
        if (voteComment.isVoteValid(voteComment.getVote())) {
            if (CommentDAO.getComments().contains(voteComment.getCommentID())) {
                if (VoteCommentManager.userExist(voteComment)) {
                    VoteCommentManager.voteComment(voteComment);
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

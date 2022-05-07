package org.example.CA1.DAO;

import org.example.CA1.Entity.VoteComment;

import java.util.HashMap;
import java.util.Map;

public class VoteCommentDAO {
    private static Map<Integer, Integer> commentVote = new HashMap<>();
    public static void voteComment(VoteComment voteComment) {
        commentVote.put(voteComment.getCommentID(),voteComment.getVote());
    }
}

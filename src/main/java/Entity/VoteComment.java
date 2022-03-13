package Entity;

public class VoteComment {
    public VoteComment(String email, int commentID, int vote) {
        this.email = email;
        this.commentID = commentID;
        this.vote = vote;
    }

    public String getEmail() {
        return email;
    }

    private String email;
    private int commentID;
    private int vote;


    public Integer getCommentID() {
        return commentID;
    }
    public Integer getVote() {
        return vote;
    }
    public boolean isVoteValid(Integer vote) {
        return vote == 0 || vote == 1 || vote == -1;
    }
}

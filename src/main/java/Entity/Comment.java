package Entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Comment {
    private String userEmail;

    public int getMovieId() {
        return movieId;
    }

    private int movieId;
    private String text;

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    private int commentID;
    private Date currentTime;

    public String getUserEmail() {
        return userEmail;
    }

    public Comment(String userEmail, int movieId, String text, int commentID, Date currentTime) {
        this.userEmail = userEmail;
        this.movieId = movieId;
        this.text = text;
        this.commentID = commentID;
        this.currentTime = currentTime;
    }
}

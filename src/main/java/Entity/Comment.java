package Entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Comment {
    private String userEmail;
    private int movieId;
    private String text;
    private int commentID;
    private Date currentTime;

    public Comment(String userEmail, int movieId, String text, int commentID, Date currentTime) {
        this.userEmail = userEmail;
        this.movieId = movieId;
        this.text = text;
        this.commentID = commentID;
        this.currentTime = currentTime;
    }
}

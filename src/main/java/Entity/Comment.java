package Entity;

import java.time.LocalDateTime;

public class Comment {
    private String userEmail;
    private int movieId;
    private String text;
    private int commentID;
    private LocalDateTime currentTime;

    public Comment(String userEmail, int movieId, String text, int commentID, LocalDateTime currentTime) {
        this.userEmail = userEmail;
        this.movieId = movieId;
        this.text = text;
        this.commentID = commentID;
        this.currentTime = currentTime;
    }
}

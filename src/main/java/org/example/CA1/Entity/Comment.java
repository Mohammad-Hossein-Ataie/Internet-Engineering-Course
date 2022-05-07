package org.example.CA1.Entity;

import java.util.Date;

public class Comment {
    private String userEmail;
    private int movieId;
    private String text;
    private int likes = 0;

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    private int dislikes = 0;

    public int getCommentID() {
        return commentID;
    }

    private int commentID;
    private Date currentTime;


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setUserId(String userId) {
        this.userEmail = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void addLikes(){
        this.likes += 1;
    }

    public void addDislikes(){
        this.dislikes += 1;
    }

    public Comment(String userEmail, int movieId, String text, int commentID, Date currentTime) {
        this.userEmail = userEmail;
        this.movieId = movieId;
        this.text = text;
        this.commentID = commentID;
        this.currentTime = currentTime;
    }

    public void setVote(Integer vote) {
        if(vote == -1){
            this.dislikes += vote;
        }
        else if(vote == 1){
            this.likes += vote;
        }
    }
}

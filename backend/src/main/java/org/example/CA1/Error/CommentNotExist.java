package org.example.CA1.Error;

public class CommentNotExist extends ClientError{
    public String getMessage() {
        return message;
    }

    private static final String message = "comment not exist!";
}

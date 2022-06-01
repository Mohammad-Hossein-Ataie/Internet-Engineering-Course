package org.example.CA1.Error;

public class MovieNotExist extends ClientError{
    public String getMessage() {
        return message;
    }

    private static final String message = "Movie not exist!";
}

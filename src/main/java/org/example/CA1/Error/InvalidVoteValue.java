package org.example.CA1.Error;

public class InvalidVoteValue extends ClientError{
    public String getMessage() {
        return message;
    }

    private static final String message = "InvalidVoteValue";
}

package org.example.CA1.Error;

public class InvalidRateScore extends ClientError {
    public String getMessage() {
        return message;
    }

    private static final String message = "InvalidRateScore";
}
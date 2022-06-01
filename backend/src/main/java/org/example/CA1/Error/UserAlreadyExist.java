package org.example.CA1.Error;

public class UserAlreadyExist extends ClientError {
    public String getMessage() {
        return message;
    }

    private static final String message = "User already exist!";

}

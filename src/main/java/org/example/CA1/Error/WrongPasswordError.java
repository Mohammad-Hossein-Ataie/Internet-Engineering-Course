package org.example.CA1.Error;

public class WrongPasswordError extends Exception {
    public WrongPasswordError() {
        super("Wrong password!");
    }
}


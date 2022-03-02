package Error;

public class UserNotExist extends ClientError{
    public String getMessage() {
        return message;
    }

    private static final String message = "User not exist!";
}


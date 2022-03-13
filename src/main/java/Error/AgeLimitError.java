package Error;

public class AgeLimitError extends Throwable {
    public String getMessage() {
        return message;
    }

    private static final String message = "AgeLimitError";
}

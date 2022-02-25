package Response;

public class Response {
    public Object getDate() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    private Object data;

    public void setDate(Object date) {
        this.data = date;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private boolean success;

    public Response(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }
}

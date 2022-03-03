import java.util.HashMap;
import java.util.Map;

import io.javalin.Javalin;

public class HandleRequest {


    public void main(String[] args) {

        Javalin app = Javalin.create().start(7777);
        app.get("/movies", this::test );

    }

    private void test(io.javalin.http.Context context) {
    }
}
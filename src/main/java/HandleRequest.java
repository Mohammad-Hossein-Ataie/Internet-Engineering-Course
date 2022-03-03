import View.MovieView;
import io.javalin.Javalin;

public class HandleRequest {


    public static void main(String[] args) {

        Javalin app = Javalin.create().start(7777);
        app.get("/movies", ctx -> ctx.html(MovieView.returnVal()) );

    }

}
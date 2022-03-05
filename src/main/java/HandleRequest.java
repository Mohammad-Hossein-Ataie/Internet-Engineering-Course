import View.ActorView;
import View.MovieView;
import io.javalin.Javalin;

import java.io.IOException;

public class HandleRequest {


    public static void main(String[] args) throws IOException {
        GetData.setActorsListData();
        GetData.getMovieList();
        GetData.setUsersListData();
        GetData.setCommentsListData();
        Javalin app = Javalin.create().start(7777);
        app.get("/movies", ctx -> ctx.html(MovieView.returnMovies()) );
        app.get("/movies/{movieId}", ctx -> ctx.html(MovieView.returnMovie( ctx.pathParam("movieId"))));
        app.get("/movies/search/{genre}", ctx -> ctx.html(MovieView.returnMovieByGenre( ctx.pathParam("genre"))));
        app.get("/movies/search/{start_year}/{end_year}", ctx -> ctx.html(MovieView.returnMovieByDateRange( ctx.pathParam("start_year"), ctx.pathParam("end_year"))));

        app.get("/actors/{actorId}", ctx -> ctx.html(ActorView.returnActor( ctx.pathParam("actorId"))));

    }

}
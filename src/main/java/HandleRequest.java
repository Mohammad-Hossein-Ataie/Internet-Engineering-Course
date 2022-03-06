import View.ActorView;
import View.MovieView;
import View.WatchListView;
import io.javalin.Javalin;

import java.io.IOException;

public class HandleRequest {


    public static void main(String[] args) throws IOException {
        GetData.setActorsListData();
        GetData.getMovieList();
        GetData.setUsersListData();
        GetData.setCommentsListData();
        Javalin app = Javalin.create().start(7777);
        //Movie
        app.get("/movies", ctx -> ctx.html(MovieView.returnMovies()) );
        app.get("/movies/{movieId}", ctx -> ctx.html(MovieView.returnMovie( ctx.pathParam("movieId"))));
        //add movie to watchlist
        app.get("/watchList/{user_id}/{movieId}", ctx -> ctx.html(MovieView.addMovieToWatchList(ctx.pathParam("user_id"), ctx.pathParam("movieId"))));
        //rate movie
        app.get("/rateMovie/{user_id}/{movieId}/{rate}", ctx -> ctx.html(MovieView.rateMovie(ctx.pathParam("user_id"), ctx.pathParam("quantity"), ctx.pathParam("movieId"))));
        app.post("/movies/{movieId}", ctx -> ctx.html(MovieView.rateMovie( ctx.formParam("user_id"), ctx.formParam("quantity"), ctx.pathParam("movieId"))));
        //movie genre
        app.get("/movies/search/{genre}", ctx -> ctx.html(MovieView.returnMovieByGenre( ctx.pathParam("genre"))));
        //movie date
        app.get("/movies/search/{start_year}/{end_year}", ctx -> ctx.html(MovieView.returnMovieByDateRange( ctx.pathParam("start_year"), ctx.pathParam("end_year"))));
        //Actor
        app.get("/actors/{actorId}", ctx -> ctx.html(ActorView.returnActor( ctx.pathParam("actorId"))));
        //user Watchlist
        app.get("/watchList/{userId}", ctx -> ctx.html(WatchListView.returnWatchList( ctx.pathParam("userId"))));

    }

}
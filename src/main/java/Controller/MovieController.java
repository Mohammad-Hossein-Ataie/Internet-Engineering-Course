package Controller;

import DAO.ActorDAO;
import Entity.Actor;
import Entity.Movie;
import Entity.User;
import Error.ActorNotFound;
import Manager.MovieManager;
import Manager.UserManager;

import java.util.List;

public class MovieController {
    public void isActorsValid(List<Actor> actors, Movie movie) throws ActorNotFound {
        for (int i = 0; i < actors.size(); i++) {
            if (movie.getCast().contains(actors.get(i))) {
                continue;
            } else {
                throw new ActorNotFound();
            }
        }
    }

    public static String addMovie(Movie movie) {
        MovieManager.addMovie(movie);
        return "movie added successfully";
    }
}

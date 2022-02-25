package Manager;

import DAO.ActorDAO;
import DAO.MovieDAO;
import Entity.Actor;
import Entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private static boolean isUpdating(Movie movie) {
        if (MovieDAO.findByID(movie.getId()) != null)
        {
            return true;
        }
        else {
            return  false;
        }
    }

    public static void addMovie(Movie movie) {
        if (isUpdating(movie))
            MovieDAO.update(movie);
        MovieDAO.add(movie);
    }
}

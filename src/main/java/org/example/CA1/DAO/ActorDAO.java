package org.example.CA1.DAO;

import org.example.CA1.Entity.Actor;
import org.example.CA1.Entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class ActorDAO {
    private static List<Actor> actors = new ArrayList<>();

    public static void update(Actor actor) {
        for (int i = 0; i < actors.size(); i++) {
            if(actors.get(i).isSame(actor))
                actors.set(i,actor);
        }
    }
    public static Actor findByID(int id){
        for (int i = 0; i < actors.size(); i++) {
            if(actors.get(i).getId() == id)
                return actors.get(i);
        }
        return null;
    }
    public static void add(Actor actor) {
        actors.add(actor);
    }
    public static List<Movie> getMovieActed(Integer actorID){
        List<Movie> actsList = new ArrayList<Movie>();
        List<Movie> movies = MovieDAO.getMovies();
        for (Movie result : movies) {
            List<Integer> casts =  result.getCast();
            for (int i = 0; i < casts.size(); i++) {
                if(casts.get(i) == actorID) {
                    actsList.add(result);
                }
            }
        }
        return actsList;
    }
    public static void setActores(List<Actor> newActors) {
        actors.addAll(newActors);
    }
}

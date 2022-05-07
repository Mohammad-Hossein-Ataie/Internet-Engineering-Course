package org.example.CA1.DAO;

import org.example.CA1.Entity.Actor;
import org.example.CA1.Entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class ActorDAO {
    private static List<Actor> actors = new ArrayList<>();

    public static int searchedActor;
    public static int getSearchedActor() {
        return searchedActor;
    }

    public static void setSearchedActor(int searchedActor) {
        ActorDAO.searchedActor = searchedActor;
    }

    public static Actor getActorByID(int id){
        for(int i = 0; i < actors.size(); i++){
            if(actors.get(i).getId() == id){
                return actors.get(i);
            }
        }
        return null;
    }
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
    public static void setActores(List<Actor> newActors) {
        actors.addAll(newActors);
    }
}

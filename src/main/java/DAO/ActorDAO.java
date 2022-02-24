package DAO;

import Entity.Actor;

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
}

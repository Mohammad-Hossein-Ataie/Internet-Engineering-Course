package org.example.CA1.Manager;

import org.example.CA1.DAO.ActorDAO;
import org.example.CA1.Entity.Actor;
public class ActorManager {


    private static boolean isUpdating(Actor actor) {
        if (ActorDAO.findByID(actor.getId()) != null)
        {
            return true;
        }
        else {
            return  false;
        }
    }

    public static void addActor(Actor actor){
        if (isUpdating(actor))
            ActorDAO.update(actor);
        ActorDAO.add(actor);
    }
}

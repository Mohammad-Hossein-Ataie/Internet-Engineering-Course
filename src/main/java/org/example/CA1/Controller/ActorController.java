package org.example.CA1.Controller;

import org.example.CA1.Entity.Actor;
import org.example.CA1.Manager.ActorManager;

public class ActorController {
    public static String addActor(Actor actor){
        ActorManager.addActor(actor);
        return "actor added successfully";
    }
}

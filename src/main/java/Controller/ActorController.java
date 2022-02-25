package Controller;

import DAO.ActorDAO;
import Entity.Actor;
import Manager.ActorManager;

public class ActorController {
    public static String addActor(Actor actor){
        ActorManager.addActor(actor);
        return "successfully added!";
    }
}

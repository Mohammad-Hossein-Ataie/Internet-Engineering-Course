package Manager;

import DAO.ActorDAO;
import Entity.Actor;
public class ActorManager {


    private boolean isUpdating(Actor actor) {
        if (ActorDAO.findByID(actor.getId()) != null)
        {
            return true;
        }
        else {
            return  false;
        }
    }

    public void addActor(Actor actor){
        if (isUpdating(actor))
            ActorDAO.update(actor);
        ActorDAO.add(actor);
    }
}

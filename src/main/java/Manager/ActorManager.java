package Manager;

import DAO.ActorDAO;
import Entity.Actor;

import java.util.List;
import java.util.ArrayList;

public class ActorManager {
    private List<Actor> actors = new ArrayList<>();

    private boolean isUpdating(Actor actor) {
        for (Actor actorItem : actors)
            if (actorItem.isSame(actor))
                return true;
        return false;
    }

    public void addActor(Actor actor){
        if (isUpdating(actor))
            ActorDAO.update(actor);
        actors.add(actor);
    }
}

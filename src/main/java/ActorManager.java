import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

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
            actor.updateActor(actor);
        actors.add(actor);
    }
}

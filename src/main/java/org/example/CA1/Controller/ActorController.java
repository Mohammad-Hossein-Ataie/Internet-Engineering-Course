package org.example.CA1.Controller;

import org.example.CA1.DAO.ActorDAO;
import org.example.CA1.DAO.MovieDAO;
import org.example.CA1.Entity.Actor;
import org.example.CA1.Entity.Movie;
import org.example.CA1.Manager.ActorManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ActorController {
    public void addActor(Actor actor){
        ActorManager.addActor(actor);
    }
    @GetMapping("/actors/{id}")
    public Object[] getMovieActed(@PathVariable Integer id) throws SQLException {
        List<Movie> actsList = new ArrayList<Movie>();
        actsList = ActorDAO.getActsList(id);
        Actor actor = ActorDAO.getActorByID(id);
        //Actor
        return new Object[]{actor, actsList};
    }
}

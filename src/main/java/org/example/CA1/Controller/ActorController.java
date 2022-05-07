package org.example.CA1.Controller;

import org.example.CA1.DAO.ActorDAO;
import org.example.CA1.DAO.MovieDAO;
import org.example.CA1.Entity.Actor;
import org.example.CA1.Entity.Movie;
import org.example.CA1.Manager.ActorManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActorController {
    public void addActor(Actor actor){
        ActorManager.addActor(actor);
    }
    @GetMapping("/actors/{id}")
    public Object[] getMovieActed(@PathVariable Integer id){
        List<Movie> actsList = new ArrayList<Movie>();
        List<Movie> movies = MovieDAO.getMovies();
        for (Movie result : movies) {
            List<Integer> casts =  result.getCast();
            for (Integer cast: casts) {
                if(id.equals(cast))
                {
                    actsList.add(result);
               }
            }
        }
        Actor actor = ActorDAO.getActorByID(id);
        //Actor
        return new Object[]{actor, actsList};
    }
}

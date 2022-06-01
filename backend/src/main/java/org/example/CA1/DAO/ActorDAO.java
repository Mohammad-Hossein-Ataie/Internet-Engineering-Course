package org.example.CA1.DAO;

import org.example.CA1.Entity.Actor;
import org.example.CA1.Entity.Movie;

import java.sql.*;
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
        try {
            Connection connection = ConnetctionPool.getConnection();
            String query = "SELECT * FROM actor WHERE actor.id=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet res = preparedStmt.executeQuery();
            Actor actor = new Actor();
            if(res.next()){
                actor.setId(res.getInt(1));
                actor.setName(res.getString(2));
                actor.setBirthDate(res.getString(3));
                actor.setNationality(res.getString(4));
                actor.setImage(res.getString(5));
            }
            res.close();
            connection.close();
            return actor;
        } catch (SQLException e) {
            e.printStackTrace();
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
//    public static void setActores(List<Actor> newActors) {
//        actors.addAll(newActors);
//    }
public static void setActors(List<Actor> newActors) throws SQLException {
    Statement statement;
    try {
        Connection connection = ConnetctionPool.getConnection();
        for(Actor actor:newActors) {
            String query = "SELECT * FROM actor WHERE id=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1,actor.getId());
            ResultSet result = preparedStmt.executeQuery();
            if(result.next()){
                continue;
            }
            query = " INSERT INTO actor (id, name, birthDate, nationality, image)"
                    + " values (?, ?, ?, ?, ?)";
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, actor.getId());
            preparedStmt.setString(2,actor.getName());
            preparedStmt.setString(3,actor.getBirthDate());
            preparedStmt.setString(4,actor.getNationality());
            preparedStmt.setString(5,actor.getActorImage());
            preparedStmt.executeUpdate();
        }
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public static List<Movie> getActsList(Integer id) {
        try {
            List<Movie> movies = new ArrayList<>();
            Connection connection = ConnetctionPool.getConnection();
            String query = "SELECT * FROM movie m JOIN casts c ON m.id = c.movieId  WHERE c.actorId=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet res = preparedStmt.executeQuery();
            while (res.next()) {
                Movie movie = new Movie();
                movie.setId(res.getInt(1));
                movie.setName(res.getString(2));
                movie.setSummary(res.getString(3));
                movie.setReleaseDate(res.getString(4));
                movie.setDirector(res.getString(5));
                movie.setImdbRate(res.getFloat(6));
                movie.setDuration(res.getString(7));
                movie.setAgeLimit(res.getInt(8));
                movie.setImage(res.getString(9));
                movie.setCoverImage(res.getString(10));
                movie.setRating(res.getFloat(11));
                movies.add(movie);
            }
            res.close();
            connection.close();
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

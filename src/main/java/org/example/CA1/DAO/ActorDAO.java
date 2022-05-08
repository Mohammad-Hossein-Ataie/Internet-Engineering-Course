package org.example.CA1.DAO;

import org.example.CA1.Entity.Actor;
import org.example.CA1.Entity.Movie;
import org.example.CA1.Entity.User;

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
        for(int i = 0; i < actors.size(); i++){
            if(actors.get(i).getId() == id){
                return actors.get(i);
            }
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
        statement = connection.createStatement();
        for(Actor actor:newActors) {
            String query = "SELECT * FROM actor WHERE id=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1,actor.getId());
            ResultSet result = preparedStmt.executeQuery();
            if(result.next()){
                continue;
            }
            statement.close();
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
}

import DAO.ActorDAO;
import DAO.MovieDAO;
import Entity.Actor;
import Entity.Movie;
import Entity.User;
import HTTPRequestHandler.HTTPRequestHandler;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.javalin.Javalin;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchMovieTest {
    public static void addTestMovies() {
        try {
            MovieDAO.add(new Movie(1,"Fight Club", "summary1", "1999-11-11", "David Fincher",new ArrayList<>(Arrays.asList("Chuck Palahniuk", "Jim Uhls")), new ArrayList<>(Arrays.asList("Drama")), new ArrayList<>(Arrays.asList(4,5)),  (float)8.8, "139",  16));
            MovieDAO.add(new Movie(2,"The Prestige", "summary2", "2006-10-20", "Christopher Nolan",new ArrayList<>(Arrays.asList("Christopher Nolan", "Jonathan Nolan", "Christopher priest")), new ArrayList<>(Arrays.asList("Drama", "Mystery", "Thriller")), new ArrayList<>(Arrays.asList(1, 2, 3)),  (float)8.5, "130",  13));
            MovieDAO.add(new Movie(3,"Se7en", "summary3", "1995-09-22", "David Fincher",new ArrayList<>(Arrays.asList("Andrew Kevin Walker")), new ArrayList<>(Arrays.asList("Drama", "Mystery", "Thriller")), new ArrayList<>(Arrays.asList(1,5)),  (float)8.6, "127",  16));
            MovieDAO.add(new Movie(4,"Forrest Gump", "summary4", "1994-07-06", "Robert Zemeckis",new ArrayList<>(Arrays.asList("Eric Roth", "Winston Groom")), new ArrayList<>(Arrays.asList("Drama", "Romance")), new ArrayList<>(Arrays.asList(1,4)),  (float)8.8, "142",  9));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    /*
    public static void addTestUsers() {
        try {
            UserDAO.addUser(new User("sara@ut.ac.ir","sara1234","Ali","sara","1924-04-03"));
            UserDAO.addUser(new User("sajjad@ut.ac.ir","sajjad1234","Sajjad","sajjad","2000-06-14"));
            UserDAO.addUser(new User("saman@ut.ac.ir","saman1234","Saman","saman","2014-01-01"));

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
     */
    public static void addTestActors() {
        try {
            ActorDAO.add(new Actor( 1,"Ali","1924-04-03","American"));
            ActorDAO.add(new Actor(2,"Mali","2000-04-03","Iran"));
            ActorDAO.add(new Actor(3,"Sally","1999-04-03","Iraq"));
            ActorDAO.add(new Actor(4,"Kally","1998-04-03","Canada"));
            ActorDAO.add(new Actor(4,"Kally","1998-04-03","Austria"));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    @BeforeClass
    public static void beforeWatchListTests() {
        final String Movies_URI = "http://138.197.181.131:5000/api/movies";
        HandleRequest interfaceServer = new HandleRequest();
        addTestActors();
        addTestMovies();
        //addTestUsers();
        try {
            interfaceServer.start(Movies_URI, 7777);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void successWatchListTest() throws UnirestException {
        try {
            User.getWatchList();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    @Test
    public void ForbiddenSearchMovieTest() {
        String startDate = "19837948";
        String endDate = "3453778";
        String url = "http://localhost:7777/movies/" + startDate + "/" + endDate;
        try {
            int statusCode = HTTPRequestHandler.getStatusCode(url);
            Assert.assertEquals(statusCode, 403);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void afterWatchListTests() {
        Javalin.create().stop();
    }
}

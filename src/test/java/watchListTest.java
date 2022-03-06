import DAO.MovieDAO;
import DAO.UserDAO;
import Entity.Movie;
import Entity.User;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.javalin.Javalin;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
public class watchListTest {

    public static void addTestMovies() {
        try {
            MovieDAO.add(new Movie(1,"Fight Club", "summary", "1999-11-11", "David Fincher",new ArrayList<>(Arrays.asList("Chuck Palahniuk", "Jim Uhls")), new ArrayList<>(Arrays.asList("Drama")), new ArrayList<>(Arrays.asList(4,5)),  (float)8.8, "139",  16));
            } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    @BeforeClass
    public static void beforeWatchListTests() {
        final String Movies_URI = "http://138.197.181.131:5000/api/movies";
        addTestMovies();
        try {
            Javalin.create().start(7777);
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

    @AfterClass
    public static void afterWatchListTests() {
        Javalin.create().stop();
    }
}
import Controller.MovieController;
import Entity.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class getMovieTest {
    private static Movie movie;
    @Before
    public static void deforeTest() {
        try {
            movie = new Movie(1, "Film", "Action Film!", "2020-10-10", "John Star", new ArrayList<>(Arrays.asList("John Son")), new ArrayList<>(Arrays.asList("Action")), 1, 6.2, "100");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void Test() {
        //
    }

}

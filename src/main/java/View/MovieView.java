package View;

import DAO.MovieDAO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MovieView {

    public MovieView() throws IOException {
    }

    public static String returnVal() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("templates/movies.html");
        Document doc = Jsoup.parse(is, "UTF-8", "test");
        //String listString = String.join(",", MovieDAO.getMovies());
        return doc.toString();
    }
}

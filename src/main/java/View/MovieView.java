package View;

import DAO.MovieDAO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

import DAO.MovieDAO;
public class MovieView {

    public MovieView() throws IOException {
    }

    public static String returnVal() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("templates/movies.html");
        Document doc = Jsoup.parse(is, "UTF-8", "test");

        Element tr = doc.createElement("tr");
        doc.getElementsByTag("table").first().appendChild(tr);
        Element th = doc.createElement("th");
        doc.getElementsByTag("tr").first().appendChild(th);
        //Array string movie
        //for each value of string creat td
        //if not null
        //append to td
        return doc.toString();
    }
}

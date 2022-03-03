package View;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class MovieView {
    File input = new File("/templates/movies.html");
    Document doc = Jsoup.parse(input, "UTF-8");

    public MovieView() throws IOException {
    }

    public static String returnVal()
    {
        return "salam";
    }
}

package View;

import DAO.MovieDAO;
import Entity.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MovieView {
    public MovieView() throws IOException {
    }
    public static ArrayList assignFilds(Movie movie){
        ArrayList movieList = new ArrayList<String>() {{
            add(movie.getName());
            add(movie.getSummary());
            add(movie.getReleaseDate());
            add(movie.getDirector());
            add(movie.getWritersString());
            add(movie.getGenreString());
            add(movie.getCastString());
            add(movie.getImdbRate());
            add(movie.getRating());
            add(movie.getDuration());
            add(movie.getAgeLimit());
            add("Links");
        }};
        return movieList;
    }
    public static String returnMovies() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("templates/movies.html");
        Document doc = Jsoup.parse(is, "UTF-8", "test");
        List movies = MovieDAO.getMovies();
        //Array string movie
        movies.forEach(movieObject ->{
            List movietempList = assignFilds((Movie) movieObject);
            Element tr = doc.createElement("tr");
            doc.getElementsByTag("table").first().appendChild(tr);
            for(int i =0;i <11; i++) {
                Element th = doc.createElement("th");
                th.text(movietempList.get(i));
                doc.getElementsByTag("tr").first().appendChild(th);
            }
        });
        return doc.toString();

    }
}

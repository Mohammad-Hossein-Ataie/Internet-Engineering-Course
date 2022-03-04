package View;

import DAO.MovieDAO;
import Entity.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
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
        }};
        return movieList;
    }
    public static String returnMovies() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//      InputStream is = classloader.getResourceAsStream("templates/movies.html");
        File in = new File("src/main/resources/templates/movies.html");
        Document doc = Jsoup.parse(in, "UTF-8");
        Elements dom = doc.children();
        List movies = MovieDAO.getMovies();

        //Array string movie
        movies.forEach(movieObject -> {
            List<String> movietempList = assignFilds((Movie) movieObject);
            Element tr = doc.createElement("tr");
            doc.getElementsByTag("table").first().appendChild(tr);
            for(int i =0;i <= movietempList.size() ; i++) {
                Element td = doc.createElement("td");
                if(i==movietempList.size()){
                    Element a = doc.createElement("a");
                    a.attr("target", "_blank");
                    a.attr("href","/movies/"+((Movie) movieObject).getId());
                    a.text("Link");
                    td.appendChild(a);
                }
                else {
                    td.text(movietempList.get(i));
                }
                tr.appendChild(td);
            }
            doc.getElementsByTag("table").first().appendChild(tr);
        });
        return doc.toString();
    }
    public static String returnMovie() throws IOException{
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("templates/movie.html");
        Document doc = Jsoup.parse(is, "UTF-8", "test");
        return doc.toString();
    }
}
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
import java.util.Arrays;
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
            add(movie.getAgeLimitString());
        }};
        return movieList;
    }
    public static String returnMovies() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//      InputStream is = classloader.getResourceAsStream("templates/movies.html");
        File in = new File("src/main/resources/templates/movies.html");
        Document doc = Jsoup.parse(in, "UTF-8");
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

    public static String returnMovie(String movieId) throws IOException{
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File in = new File("src/main/resources/templates/movie.html");
        Document doc = Jsoup.parse(in, "UTF-8");
        Movie movie = MovieDAO.getMovieByID(Integer.valueOf(movieId));

        doc.getElementById("name").text(movie.getName());
        doc.getElementById("summary").text(movie.getSummary());
        doc.getElementById("releaseDate").text(movie.getReleaseDate());
        doc.getElementById("director").text(movie.getDirector());
        doc.getElementById("writers").text(movie.getWritersString());
        doc.getElementById("genres").text(movie.getGenreString());
        doc.getElementById("cast").text(movie.getCastString());
        doc.getElementById("rating").text(movie.getRating());
        doc.getElementById("duration").text(movie.getDuration());
        doc.getElementById("ageLimit").text(movie.getAgeLimitString());
//
        return doc.toString();
    }

    public static String returnMovieByGenre(String searchedGenre) throws IOException{
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File in = new File("src/main/resources/templates/movies.html");
        Document doc = Jsoup.parse(in, "UTF-8");
        List movies = MovieDAO.getMovies();
        List<Movie> serachedMovies = new ArrayList<>();

        movies.forEach(movieObj -> {
            List<String> genres = ((Movie) movieObj).getGenres();
            if(genres.contains(searchedGenre)){
                serachedMovies.add((Movie) movieObj);
            }
        });

        if(serachedMovies != null){
            serachedMovies.forEach(movie -> {
                List<String> movietempList = assignFilds((Movie) movie);
                Element tr = doc.createElement("tr");
                doc.getElementsByTag("table").first().appendChild(tr);
                for(int i =0;i <= movietempList.size() ; i++) {
                    Element td = doc.createElement("td");
                    if(i==movietempList.size()){
                        Element a = doc.createElement("a");
                        a.attr("target", "_blank");
                        a.attr("href","/movies/"+((Movie) movie).getId());
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
        }
        return doc.toString();
    }

    public static String returnMovieByDateRange(String start, String end) throws IOException{
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File in = new File("src/main/resources/templates/movies.html");
        Document doc = Jsoup.parse(in, "UTF-8");
        List movies = MovieDAO.getMovies();
        List<Movie> serachedMovies = new ArrayList<>();


        Integer start_date = Integer.valueOf(start);
        Integer end_date = Integer.valueOf(end);

        movies.forEach(movieObj -> {
            List<String> date = Arrays.asList(((Movie) movieObj).getReleaseDate().split("-"));
            Integer dateYear = Integer.valueOf(date.get(0));
            if(dateYear >= start_date && dateYear <= end_date){
                serachedMovies.add((Movie) movieObj);
            }
        });

        if(serachedMovies != null){
            serachedMovies.forEach(movie -> {
                List<String> movietempList = assignFilds((Movie) movie);
                Element tr = doc.createElement("tr");
                doc.getElementsByTag("table").first().appendChild(tr);
                for(int i =0;i <= movietempList.size() ; i++) {
                    Element td = doc.createElement("td");
                    if(i==movietempList.size()){
                        Element a = doc.createElement("a");
                        a.attr("target", "_blank");
                        a.attr("href","/movies/"+((Movie) movie).getId());
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
        }
//      System.out.println();
        return doc.toString();
    }
}
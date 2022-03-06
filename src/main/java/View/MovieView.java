package View;

import DAO.CommentDAO;
import DAO.MovieDAO;
import DAO.UserDAO;
import Entity.Comment;
import Entity.Movie;
import Entity.User;
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
//            add(String.valueOf(MovieDAO.getRateMovie(Integer.valueOf(movie.getId()))));
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
        List<Comment> movieComments = new ArrayList<>();

        List<Comment> comments = CommentDAO.getComments();
        comments.forEach(comment -> {
            if (comment.getMovieId() == Integer.valueOf(movieId)){
                movieComments.add(comment);
            }
        });

        doc.getElementById("name").text(movie.getName());
        doc.getElementById("summary").text(movie.getSummary());
        doc.getElementById("releaseDate").text(movie.getReleaseDate());
        doc.getElementById("director").text(movie.getDirector());
        doc.getElementById("writers").text(movie.getWritersString());
        doc.getElementById("genres").text(movie.getGenreString());
        doc.getElementById("cast").text(movie.getCastString());
        doc.getElementById("rating").text(String.valueOf(MovieDAO.getRateMovie(Integer.valueOf(movieId))));
        doc.getElementById("duration").text(movie.getDuration());
        doc.getElementById("ageLimit").text(movie.getAgeLimitString());

        movieComments.forEach(comment -> {
            Element tr = doc.createElement("tr");
            //nikName
            User user = UserDAO.getUserBymail(comment.getUserEmail());
            String nikName = user.getName();
            Element nametd = doc.createElement("td");
            nametd.text("@"+nikName);
            tr.appendChild(nametd);
            //comment
            Element commenttd = doc.createElement("td");
            commenttd.text(comment.getText());
            tr.appendChild(commenttd);
            //likes
            Element likestd = doc.createElement("td");
            Element likes = doc.createElement("span");
            likes.text(String.valueOf(comment.getLikes()));
            likestd.appendChild(likes);

            Element likebtn = doc.createElement("button");
            likebtn.text("like");
            likebtn.attr("type", "submit");
            likestd.appendChild(likebtn);
            tr.appendChild(likestd);
            //dislikes
            Element dislikestd = doc.createElement("td");
            Element dislikes = doc.createElement("span");
            dislikes.text(String.valueOf(comment.getDislikes()));
            dislikestd.appendChild(dislikes);

            Element dislikebtn = doc.createElement("button");
            dislikebtn.text("dislike");
            dislikebtn.attr("type", "submit");
            dislikestd.appendChild(dislikebtn);
            tr.appendChild(dislikestd);

            doc.getElementsByTag("table").first().appendChild(tr);

        });

        return doc.toString();
    }

    public static  String addMovieToWatchList(String userId, String movieId) throws IOException{
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File in = new File("src/main/resources/templates/movie.html");
        Document doc = Jsoup.parse(in, "UTF-8");

        UserDAO.addToWatchList(userId, Integer.parseInt(movieId));
        return returnMovie(movieId);
    }

    public static String rateMovie(String userId, String rating, String movieId)throws IOException{
        MovieDAO.setRateMovie(userId,Integer.valueOf(rating),Integer.valueOf(movieId));
        return returnMovie(movieId);
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
package View;

import DAO.ActorDAO;
import Entity.Actor;
import Entity.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActorView {

    public static String returnActor(String id) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File in = new File("src/main/resources/templates/actor.html");
        Document doc = Jsoup.parse(in, "UTF-8");

        Actor actor = ActorDAO.findByID(Integer.parseInt(id));
        List<Movie> movies = ActorDAO.getMovieActed(Integer.parseInt(id));
        List<String> ActorsMovies = new ArrayList<>();
        Integer tableCol = 4;

        doc.getElementById("name").text(actor.getName());
        doc.getElementById("birthDate").text(actor.getBirthDate());
        doc.getElementById("nationality").text(actor.getNationality());
        doc.getElementById("tma").text(String.valueOf(movies.size()));

        movies.forEach(movie -> {
            Element tr = doc.createElement("tr");
            //name
            Element Nametd = doc.createElement("td");
            Nametd.text(movie.getName());
            tr.appendChild(Nametd);
            //imdb
            Element imdbtd = doc.createElement("td");
            imdbtd.text(movie.getImdbRate());
            tr.appendChild(imdbtd);
            //rating
            Element ratingtd = doc.createElement("td");
            ratingtd.text(movie.getRating());
            tr.appendChild(ratingtd);
            //page
            Element pagetd = doc.createElement("td");
            Element a = doc.createElement("a");
            a.attr("target", "_blank");
            a.attr("href","/movies/"+((Movie) movie).getId());
            a.text("Link");
            pagetd.appendChild(a);
            tr.appendChild(pagetd);

            doc.getElementsByTag("table").first().appendChild(tr);
        });

        return doc.toString();
    }
}

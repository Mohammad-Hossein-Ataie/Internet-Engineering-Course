package View;

import DAO.MovieDAO;
import DAO.UserDAO;
import Entity.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Entity.Movie;
import org.jsoup.nodes.Element;

public class WatchListView {

    public static String returnWatchList(String userId) throws IOException{
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File in = new File("src/main/resources/templates/watchlist.html");
        Document doc = Jsoup.parse(in, "UTF-8");
        File err404 = new File("src/main/resources/templates/404.html");
        Document doc404 = Jsoup.parse(err404, "UTF-8");

        List<User> users = UserDAO.getUsers();
        List<User> searchedUser = new ArrayList<>();

        if(users == null){
            return doc404.toString();
        }
        else{
            users.forEach(userObj -> {
                if(userObj.getEmail().equalsIgnoreCase(userId)){
                    searchedUser.add(userObj);
                }
            });

            doc.getElementById("name").text(searchedUser.get(0).getName());
            doc.getElementById("nickname").text(searchedUser.get(0).getNickname());

            List<Movie> movies = searchedUser.get(0).getWatchList();

            movies.forEach(movie -> {
                Element tr = doc.createElement("tr");
                //Movie
                Element movietd = doc.createElement("td");
                movietd.text(movie.getName());
                tr.appendChild(movietd);
                //Date
                Element datetd = doc.createElement("td");
                datetd.text(movie.getReleaseDate());
                tr.appendChild(datetd);
                //Director
                Element directortd = doc.createElement("td");
                directortd.text(movie.getDirector());
                tr.appendChild(directortd);
                //Genres
                Element genretd = doc.createElement("td");
                genretd.text(movie.getGenreString());
                tr.appendChild(genretd);
                //imdb
                Element imdbtd = doc.createElement("td");
                imdbtd.text(movie.getImdbRate());
                tr.appendChild(imdbtd);
                //rating
                Element ratingtd = doc.createElement("td");
                Float rating = MovieDAO.getRateMovie(movie.getId());
                ratingtd.text(String.valueOf(rating));
                tr.appendChild(ratingtd);
                //duration
                Element durationtd = doc.createElement("td");
                durationtd.text(movie.getDuration());
                tr.appendChild(durationtd);
                doc.getElementsByTag("table").first().appendChild(tr);
                //page
                Element pagetd = doc.createElement("td");
                Element a = doc.createElement("a");
                a.attr("target", "_blank");
                a.attr("href","/movies/"+((Movie) movie).getId());
                a.text("Link");
                pagetd.appendChild(a);
                tr.appendChild(pagetd);
                //remove
                Element removetd = doc.createElement("td");
                Element removeBtn = doc.createElement("button");
                removeBtn.text("remove");
                removeBtn.attr("type", "submit");
                removetd.appendChild(removeBtn);
                tr.appendChild(removetd);

                doc.getElementsByTag("table").first().appendChild(tr);
            });

            return doc.toString();
        }
    }
}

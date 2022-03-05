package View;

import DAO.UserDAO;
import Entity.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Entity.Movie;

public class WatchListView {

    public static String returnWatchList(String userId) throws IOException{
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File in = new File("src/main/resources/templates/watchlist.html");
        Document doc = Jsoup.parse(in, "UTF-8");

        List<User> users = UserDAO.getUsers();
        List<User> searchedUser = new ArrayList<>();

        users.forEach(userObj -> {
            if(userObj.getEmail().equalsIgnoreCase(userId)){
                searchedUser.add(userObj);
            }
        });

        doc.getElementById("name").text(searchedUser.get(0).getName());
        doc.getElementById("nickname").text(searchedUser.get(0).getNickname());

        List<Movie> movies = searchedUser.get(0).getWatchList();


        return doc.toString();
    }

}

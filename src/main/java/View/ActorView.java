package View;

import DAO.ActorDAO;
import Entity.Actor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class ActorView {

    public static String returnActor(String id) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File in = new File("src/main/resources/templates/actor.html");
        Document doc = Jsoup.parse(in, "UTF-8");

        Actor actor = ActorDAO.findByID(Integer.parseInt(id));

        doc.getElementById("name").text(actor.getName());
        doc.getElementById("birthDate").text(actor.getBirthDate());
        doc.getElementById("nationality").text(actor.getNationality());
//      doc.getElementById("tma").text(actor.get());

        return doc.toString();
    }
}

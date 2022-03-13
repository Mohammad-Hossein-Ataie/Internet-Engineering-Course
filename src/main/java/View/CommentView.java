package View;

import DAO.CommentDAO;
import Entity.Comment;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CommentView {
    public static String handleVoteComment(String userId, String commentId, String vote)throws IOException{
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File in = new File("src/main/resources/templates/movie.html");
        Document doc = Jsoup.parse(in, "UTF-8");

        List<Comment> comments = CommentDAO.getComments();


        return doc.toString();
    }
}

package org.example.CA1.httpServlet;

import org.example.CA1.DAO.ActorDAO;
import org.example.CA1.DAO.CommentDAO;
import org.example.CA1.DAO.MovieDAO;
import org.example.CA1.DAO.UserDAO;
import org.example.CA1.Entity.Actor;
import org.example.CA1.Entity.Comment;
import org.example.CA1.Entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.example.CA1.Entity.Movie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetData {
    public static <T> T setListData(String url, Class<T> type) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {

            HttpGet request = new HttpGet(url);


            CloseableHttpResponse response = httpClient.execute(request);

            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    String objectListSTR = EntityUtils.toString(entity);
                    Gson gson = new GsonBuilder()
                            .create();
                    return (gson.fromJson(objectListSTR, type));
                }

            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
        return null;
    }
    public static void setMovieList() throws IOException {
        Movie[] objectList = setListData("http://138.197.181.131:5000/api/movies",Movie[].class);
        MovieDAO.setMovies(Arrays.asList(objectList));
    }
    public static void setActorsListData() throws IOException {
        Actor[] objectList = setListData("http://138.197.181.131:5000/api/actors",Actor[].class);
        ActorDAO.setActores(Arrays.asList(objectList));
    }
    public static void setUsersListData() throws IOException {
        User[] objectList = setListData("http://138.197.181.131:5000/api/users",User[].class);
        UserDAO.setUsers(Arrays.asList(objectList));
    }
    public static void setCommentsListData() throws IOException {
        Comment[] objectList = setListData("http://138.197.181.131:5000/api/comments", Comment[].class);
        CommentDAO.setComments(Arrays.asList(objectList));
    }
}
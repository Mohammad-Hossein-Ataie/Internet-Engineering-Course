import DAO.MovieDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import Entity.Movie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetData {
    public static void setData() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {

            HttpGet request = new HttpGet("http://138.197.181.131:5000/api/movies");


            CloseableHttpResponse response = httpClient.execute(request);

            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    String movieListSTR = EntityUtils.toString(entity);
                    Gson gson = new GsonBuilder()
                            .create();
                    Movie[] movieList = gson.fromJson(movieListSTR, Movie[].class);
                    MovieDAO.setMovies(Arrays.asList(movieList));
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
    }

}

package org.example.CA1.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

@RestController
public class AuthenticationController {
    @PostMapping("/callback/{code}")
    public String callback(
            @PathVariable String code
    ) throws IOException,InterruptedException{

        String client_id = "ba82189574fb38061422";
        String client_secret = "f6c65b31837082c1f54490f6785d4fdcd05c5d34";
        String accessTokenURL = String.format("https://github.com/login/oauth/access_token?client_id=%s&client_secret=%s&code=%s",
                client_id,client_secret,code
        );
        System.out.println(accessTokenURL);
        HttpClient client = HttpClient.newHttpClient();
        URI accessTokenURI = URI.create(accessTokenURL);
        HttpRequest.Builder accessTokenBuilder = HttpRequest.newBuilder().uri(accessTokenURI);
        HttpRequest accessTokenRequest =
                accessTokenBuilder
                        .POST(HttpRequest.BodyPublishers.noBody())
                        .header("Accept","application/json")
                        .build();
        HttpResponse<String> accessTokenResult = client.send(accessTokenRequest, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> resultBody = mapper.readValue(accessTokenResult.body(),HashMap.class);
        String accessToken = (String) resultBody.get("access_token");
        //Get user Information with access_token
        URI userDataURI =  URI.create("https://api.github.com/user");
        HttpRequest.Builder userDataBuilder = HttpRequest.newBuilder().uri(userDataURI);
        HttpRequest req =
                userDataBuilder.GET()
                        .header("Authorization",String.format("token %s", accessToken))
                        .build();
        HttpResponse<String> userDataResult = client.send(req,HttpResponse.BodyHandlers.ofString());
        return userDataResult.body();
        //TODO : create update user
        //TODO : Generate JWT for user and return it
    }

}

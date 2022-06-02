package org.example.CA1.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.jsonwebtoken.Jwts;
import org.example.CA1.Entity.User;
import org.example.CA1.Entity.Userlogin;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;

@RestController
public class AuthenticationController {
    private static final long EXPIRATION_TIME = 86400000;
    public static final String KEY = "Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=";
    @PostMapping("/callback/{code}")
    public JsonNode callback(
            @PathVariable String code
    ) throws Exception {

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
        System.out.println(accessToken);
        //Get user Information with access_token
        URI userDataURI =  URI.create("https://api.github.com/user");
        HttpRequest.Builder userDataBuilder = HttpRequest.newBuilder().uri(userDataURI);
        HttpRequest req =
                userDataBuilder.GET()
                        .header("Authorization",String.format("token %s", accessToken))
                        .build();
        HttpResponse<String> userDataResult = client.send(req,HttpResponse.BodyHandlers.ofString());
        System.out.println(userDataResult.body());
        RestTemplate restTemplate = new RestTemplate();
        var headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        var entity = new HttpEntity<String>(headers);
        var User = restTemplate
                .exchange("https://api.github.com/user", HttpMethod.GET, entity, Userlogin.class);
        Date birthDate = User.getBody().getCreated_at();
        SignUpController signUpController = new SignUpController();
        LoginController loginController = new LoginController();
        User user = new User();
        user.setNickname(User.getBody().getLogin());
        user.setName(User.getBody().getName());
        user.setEmail(User.getBody().getEmail());
        System.out.println(User.getBody().getEmail());
        user.setBirthDate(birthDate);
        user.setPassword("null");
        signUpController.signup(user);
        loginController.login(user);

        String jwt = createToken(user.getEmail());
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode resp = objectMapper.createObjectNode();
        resp.put("token", jwt);
        resp.put("email",user.getEmail());
        System.out.println("__________________________");
        System.out.println(resp);
        return resp;
        //TODO : Check if user exist
        //TODO : Generate JWT for user and return it
    }
    private String createToken(String mail) {
        SecretKey key = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        String token = Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject(mail)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(key)
                .compact();
        return token;
    }
}

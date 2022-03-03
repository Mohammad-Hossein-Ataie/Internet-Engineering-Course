import java.io.*;

import Controller.*;
import Entity.*;
import Response.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Error.ClientError;
import Error.AgeLimitError;

import java.lang.reflect.Type;
import java.util.Map;

class appInterface {
    public static  void main(String[] args) throws IOException {
        PrintStream outStream = System.out;
        InputStream inStream = System.in;
        start(inStream, outStream);
    }

    public static void start(InputStream inStream, PrintStream outStream) throws IOException {
        System.setOut(outStream);
        // new class obj
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream));
        String line;
            while ((line = bufferedReader.readLine()) != null) {
                try {
                String[] in = line.split(" ", 2); // limit =2 ??
                String cmd = in[0];
                String jsonData = "";

                if (in.length == 2) {
                    jsonData = in[1];
                }
                getCommandData(cmd, jsonData,outStream); //? chek input
            }
                catch (Exception | ClientError | AgeLimitError e) {
                    Gson gson = new GsonBuilder()
                            .create();
                    Response response = new Response(false, e.getMessage());
                    String jsonString = gson.toJson(response);
                    outStream.println(jsonString);
                }
            }
        }

    private static void getCommandData(String cmd, String jsonData,PrintStream outStream) throws ClientError, AgeLimitError {
        //gson
        switch(cmd) {
            //1
            case "addActor": {
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd")
                        .create();

                Actor actor = gson.fromJson(jsonData, Actor.class);
                Response response = new Response(true, ActorController.addActor(actor));
                String jsonString = gson.toJson(response);
                outStream.println(jsonString);

                break;
            }
            //2
            case "addMovie": {
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd")
                        .create();
                Movie movie = gson.fromJson(jsonData, Movie.class);
                Response response = new Response(true, MovieController.addMovie(movie));
                String jsonString = gson.toJson(response);
                outStream.println(jsonString);
                break;
            }
            //3
            case "addUser": {
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd")
                        .create();

                User user = gson.fromJson(jsonData, User.class);
                Response response = new Response(true,UserController.addUser(user));
                String jsonString = gson.toJson(response);
                outStream.println(jsonString);
                break;
            }
            //4
            case "addComment": {
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd")
                        .create();

                Comment comment = gson.fromJson(jsonData, Comment.class);
                Response response = new Response(true, CommentController.addComment(comment));
                String jsonString = gson.toJson(response);
                outStream.println(jsonString);
                break;
            }
            //5
            case "rateMovie": {
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd")
                        .create();

                RateMovie rateMovie = gson.fromJson(jsonData, RateMovie.class);
                Response response = new Response(true, RateMovieController.rateMovie(rateMovie));
                String jsonString = gson.toJson(response);
                outStream.println(jsonString);
                break;
            }
            //6
            case "voteComment": {
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd")
                        .create();

                VoteComment voteComment = gson.fromJson(jsonData, VoteComment.class);
                Response response = new Response(true, VoteCommentController.voteComment(voteComment));
                String jsonString = gson.toJson(response);
                outStream.println(jsonString);
                break;
            }
            //7
            case "addToWatchList": {
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd")
                        .create();
                Map addToWatchListDTO = gson.fromJson(jsonData, (Type) User.class);
                Response response = new Response(true, UserController.addToWatchList(addToWatchListDTO.get("userEmail").toString(),(Integer)addToWatchListDTO.get("movieId")));
                String jsonString = gson.toJson(response);
                outStream.println(jsonString);

                break;
            }
            //8
            case "removeFromWatchList": {
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd")
                        .create();
                Map addToWatchListDTO = gson.fromJson(jsonData, (Type) User.class);
                Response response = new Response(true, UserController.removeFromWatchList(addToWatchListDTO.get("userEmail").toString(),(Integer)addToWatchListDTO.get("movieId")));
                String jsonString = gson.toJson(response);
                outStream.println(jsonString);
                break;
            }
            //9
            case "getMoviesList": {
                //Serilize object ouput
                Gson gson = new GsonBuilder()
                        .create();
                Response response = new Response(true,MovieController.getMoviesList());
                String jsonString = gson.toJson(response);
                outStream.println(jsonString);
                break;
            }
            //10
            case "getMovieById": {
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd")
                        .create();
                Response response = new Response(true,MovieController.getMovieById(1)); //cmd?
                String jsonString = gson.toJson(response);
                outStream.println(jsonString);
                break;
            }
            //11
            case "getMoviesByGenre": {
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd")
                        .create();
                Response response = new Response(true,MovieController.getMoviesByGenre("Action")); //cmd?
                String jsonString = gson.toJson(response);
                outStream.println(jsonString);
                break;
            }
            //12
            case "getWatchList": {
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd")
                        .create();
                String mail = gson.fromJson(jsonData, (Type) User.class);
                Response response = new Response(true, UserController.getWatchList(mail));
                String jsonString = gson.toJson(response);
                outStream.println(jsonString);
                break;
            }

        }
    }
}

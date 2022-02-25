import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.Buffer;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
//Using reflection
import Controller.UserController;
import Entity.Actor;
import Entity.User;
import Response.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Error.ClientError;
class appInterface {
    public static  void main(String[] args) {
        PrintStream outStream = System.out;
        InputStream inStream = System.in;
        start(inStream, outStream);
    }

    public static void start(InputStream inStream, PrintStream outStream) {
        System.setOut(outStream);
        // new class obj
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream));
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] in = line.split("", 1); // limit =2 ??
                String cmd = in[0];
                String jsonData = "";

                if (in.length == 2) {
                    jsonData = in[1];
                }
                getCommandData(cmd, jsonData,outStream); //? chek input
            }
        }
        catch (Exception | ClientError e) {
//            outStream.println(e.getMessage());
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
//                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .create();

            String jsonString = gson.toJson(new Response(false, e.getMessage()));
        }
    }

    private static void getCommandData(String cmd, String jsonData,PrintStream outStream) throws ClientError {
        //gson
        switch(cmd) {
            //1
            case "addActor": {
                Gson gson = new GsonBuilder()
         //               .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()) //How to convert desrealize time in gson
                        .create();

                Actor actor = gson.fromJson(jsonData, Actor.class);
                outStream.println();
                break;
            }
            //2
            case "addMovie": {
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
                break;
            }
            //5
            case "rateMovie": {
                break;
            }
            //6
            case "voteComment": {
                break;
            }
            //7
            case "addToWatchList": {
                break;
            }
            //8
            case "removeFromWatchList": {
                break;
            }
            //9
            case "getMoviesList": {
                //Serilize object ouput
                break;
            }
            //10
            case "getMovieById": {
                break;
            }
            //11
            case "getMoviesByGenre": {
                break;
            }
            //12
            case "getWatchList": {
                break;
            }

        }
    }
}

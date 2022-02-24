import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.Buffer;
import java.util.List;
import java.util.Properties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

                //            if (input_parts.length == 2) {
                //                jsonData = input_parts[1];
                //            } ?????????????????
                getCommandData(cmd, jsonData); //? chek input
            }
        }
        catch (Exception e) {
            //
        }
    }

    private static void getCommandData(String cmd, String jsonData) {
        //gson
        switch(cmd) {
            //1
            case "addActor": {
                break;
            }
            //2
            case "addMovie": {
                break;
            }
            //3
            case "addUser": {
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

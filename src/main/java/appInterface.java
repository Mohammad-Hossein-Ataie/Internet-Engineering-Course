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
    }
}

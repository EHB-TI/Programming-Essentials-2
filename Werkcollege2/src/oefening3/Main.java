package oefening3;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://api.icndb.com/jokes/random");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        Joke j = new Gson().fromJson(reader, Joke.class);
        reader.close();
        System.out.println(j.getValue().getJoke());

    }
}

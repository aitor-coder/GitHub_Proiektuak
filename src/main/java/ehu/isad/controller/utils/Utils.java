package ehu.isad.controller.utils;

import com.google.gson.Gson;
import ehu.isad.GithubDatuakModel;
import ehu.isad.GithubModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Utils {
    public Utils(){

    }
    public GithubDatuakModel readFromUrl(String izena) throws IOException {
        URL openlibrary = new URL("https://api.github.com/repos/"+izena);
        URLConnection yc = openlibrary.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine = in.readLine();
        in.close();

        Gson gson = new Gson();
        return gson.fromJson(inputLine, GithubDatuakModel.class);
    }
}

package ru.bonbon.SpringTest.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class TestQuery {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            OutputStream outputStream = connection.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("name=yopta");
            printWriter.flush();

            InputStream inputStream = connection.getInputStream();
            Scanner in = new Scanner(inputStream);
            String result = "";
            while (in.hasNext()){
                result+= in.nextLine();
            }
            System.out.println(result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

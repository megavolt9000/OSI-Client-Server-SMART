package ru.netology.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8083;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Oleg");
            String response = in.readLine();
            System.out.println(response);
            out.println("no");
            String response2 = in.readLine();
            System.out.println(response2);
            out.println("bye");
            String response3 = in.readLine();
            System.out.println(response3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package ru.netology.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server start");
        int port = 8083;
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                System.out.println("New connection accepted. Write your name?\n");
                clientSocket.getPort();
                String name = reader.readLine();
                System.out.println(name);
                writer.println(String.format("Hi %s, your port is %d. Are you child? (yes/no)",
                        name, clientSocket.getPort()));
                String answer = reader.readLine();
                System.out.println(answer);
                if (answer.equals("yes")) {
                    writer.println("Welcome to the kids area, " + name + "! Let's play!");
                } else if (answer.equals("no")) {
                    writer.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                } else {
                    writer.println(name + "! Your answer ir wrong!");
                }
                String bye = reader.readLine();
                System.out.println(bye);
                writer.println(bye);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
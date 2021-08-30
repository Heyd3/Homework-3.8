package Homework.ClientService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class clientServerApplication {
    public static void main(String[] args) throws IOException {

        System.out.println("server started");
        int port = 8081;

        while (true) {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());

            out.println(String.format("Write your name?"));
            final String name = in.readLine();
            out.println(String.format("Are you child? (yes/no)"));
            if (in.readLine().equals("yes")) {
                out.println(String.format("Welcome to the kids area, %s Let's play!", name));
            } else {
                out.println(String.format("zone, %s Have a good rest, or a good working day!", name));
            }
            serverSocket.close();
        }
    }
}

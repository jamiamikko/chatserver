/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *
 * @author RYU
 */
import java.net.*;
import java.io.*;

public class ChatServer {

    ChatServer() {
    }

    void serve() throws IOException {

        try {
            ServerSocket server = new ServerSocket(0, 3);
            int portaddress = server.getLocalPort();
            System.out.println(portaddress);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in;
            PrintWriter out;
            Socket s;
            String message;

            while (true) {
                System.out.println("Waiting ....");

                s = server.accept();

                System.out.println("Connection Established!!");
                CommandInterpreter i = new CommandInterpreter(s.getInputStream(), new PrintStream(s.getOutputStream()));
                i.run();

            }

        } catch (IOException e) {
            System.out.println("Could not listen.");
            System.exit(-1);
        }
    }
}

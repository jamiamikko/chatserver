/*
Class for creating a server that can be connected to through local host.

@authors
1402803 Jämiä Mikko
1406733 Järvinen Otto
1503524 Taba Tünde
 */
import java.net.*;
import java.io.*;

public class ChatServer {

    /*Constructor for ChatServer*/
    ChatServer() {
    }

    /*Serve() method*/
    void serve() throws IOException {

        try {

            /*Define variables for Server Socket, port address and accepting socket,
            which are need for communicating with the server.*/
            ServerSocket server = new ServerSocket(0, 3);
            int portaddress = server.getLocalPort();
            System.out.println(portaddress);
            Socket s;

            /*While loop for waiting the server to accept the connection. When connection is established,
            start run the CommandInterpreter as a Thread.*/
            while (true) {
                System.out.println("Waiting ....");

                s = server.accept();

                System.out.println("Connection Established!!");
                CommandInterpreter i = new CommandInterpreter(s.getInputStream(), new PrintStream(s.getOutputStream()));

                Thread t = new Thread((Runnable) i);

                t.start();

            }

        } catch (IOException e) {

            /*If connection can't be established, quit the application.*/
            System.out.println("Could not listen.");
            System.exit(-1);
        }
    }
}

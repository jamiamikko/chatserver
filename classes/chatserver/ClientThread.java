
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RYU
 */
public class ClientThread extends ChatServer implements Runnable {

    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        /*try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (!socket.isClosed()) {
                String input = in.readLine();
                if (input != null) {
                    for (ClientThread client : clients) {
                        client.getWriter().write(input);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
        }*/
    }

    public PrintWriter getWriter() {
        return out;
    }
}

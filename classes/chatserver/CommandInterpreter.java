
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RYU
 */
public class CommandInterpreter implements Runnable {

    String username;
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    static ArrayList<CommandInterpreter> clients = new ArrayList<CommandInterpreter>();
    ChatHistory history = ChatHistory.getInstance();

    public CommandInterpreter(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        /*while socket is open:
        - read client's command
        - process command
         */

        synchronized (clients) {
            clients.add(this);
        }

        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("ClientThread started");
            while (!socket.isClosed()) {
                String input = in.readLine();
                System.out.println(input);
                if (input == null) {
                    break;
                }
                ChatMessage chatMessage = new ChatMessage(input);
                processMessage(chatMessage);

            }
        } catch (IOException e) {
            System.out.println("Error");
        }

        synchronized (clients) {
            clients.remove(this);
        }
    }

    public PrintWriter getWriter() {
        return out;
    }

    void processMessage(ChatMessage chatMessage) {
        System.out.println("Message gotten:" + chatMessage.message);
        username = chatMessage.username;
        switch (chatMessage.message) {
            case ":history":
                processHistory();
                break;
            case ":userlist":
                processUserlist();
                break;
            case ":help":
                processHelp();
                break;
            default:
                sendMessage(chatMessage);
                history.insert(chatMessage);
                break;
        }
    }

    void processHistory() {

        getWriter().println(history.toString());

    }

    void processUserlist() {
        String list = "System: Users:#";
        synchronized (clients) {
            for (CommandInterpreter client : clients) {
                list = list + client.username + " ";
            }
        }
        getWriter().println(list);
        System.out.println("Userlist: " + list + "<<<");
    }

    void processHelp() {
        String system = "System: ";
        getWriter().println(system + "Start by typing something.#Commands:#:history = show history#:userlist = list users#:help = help");

    }

    void sendMessage(ChatMessage chatMessage) {
        synchronized (clients) {
            for (CommandInterpreter client : clients) {
                System.out.println("Client loop:" + chatMessage.message);
                //if (!username.equals(chatMessage.username)) {
                client.getWriter().println(chatMessage.username + ": " + chatMessage.message);
                /*}else{
                client.getWriter().println(chatMessage.message);
            }*/
            }
        }

    }

}

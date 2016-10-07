
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/*
Class for creating CommandInterpreter.

@authors
Group Tableflipz
1402803 Jämiä Mikko
1406733 Järvinen Otto
1503524 Taba Tünde
 */
public class CommandInterpreter implements Runnable {

    /*Instance variables for CommandInterpreter*/
    String username;
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    static ArrayList<CommandInterpreter> clients = new ArrayList<CommandInterpreter>();
    ChatHistory history = ChatHistory.getInstance();

    /*Constructor for CommandInterpreter*/
    public CommandInterpreter(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        /*while socket is open:
        - read client's command
        - process command
         */

 /*Add new client*/
        synchronized (clients) {
            clients.add(this);
        }

        try {

            /*Socket output and input connection starts the thread*/
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("ClientThread started");

            /*While socket has a connecition, we process new messages*/
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

        /*Remove client*/
        synchronized (clients) {
            clients.remove(this);
        }
    }

    /*getWriter() method, returns output*/
    public PrintWriter getWriter() {
        return out;
    }

    /*processMessage() method processing commands*/
    void processMessage(ChatMessage chatMessage) {
        System.out.println("Message gotten:" + chatMessage.message);
        username = chatMessage.username;

        /*Switch case for different commands.*/
        switch (chatMessage.message) {

            /*Command for printing chat history*/
            case ":history":
                processHistory();
                break;

            /*Command for printing current users*/
            case ":userlist":
                processUserlist();
                break;

            /*Command for printing help*/
            case ":help":
                processHelp();
                break;

            /*Command for printing tableflip emoji*/
            case ":tableflip":
                processTableflip(chatMessage);
                break;

            /*Command for quitting chat. Command removes current client*/
            case ":quit":
                processQuit(chatMessage);
                break;
            /*As a default, we print messages*/
            default:
                sendMessage(chatMessage);
                history.insert(chatMessage);
                break;
        }
    }

    /*processHistory() method for printing history*/
    void processHistory() {

        getWriter().println(history.toString());

    }

    /*processQuit() method for removing client and notifying other users*/
    void processQuit(ChatMessage chatMessage) {

        synchronized (clients) {
            for (CommandInterpreter client : clients) {
                System.out.println("Client loop:" + chatMessage.username + " left");

                client.getWriter().println("System: " + chatMessage.username + " left");

            }
        }

        clients.remove(this);

    }

    /*processUserlist() method for printing user list*/
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

    /*processHelp() method for printing help message*/
    void processHelp() {
        String system = "System: ";
        getWriter().println(system + "Start by typing something.#Commands:#:history = show history#:userlist = list users#:help = help#:tableflip = (╯°□°）╯︵ ┻━┻#:quit = leave chat");

    }

    /*processTableflip() method for printing tableflip*/
    void processTableflip(ChatMessage chatMessage) {
        synchronized (clients) {
            for (CommandInterpreter client : clients) {
                System.out.println("Client loop:" + chatMessage.message);

                client.getWriter().println(chatMessage.username + ": (╯°□°）╯︵ ┻━┻");

            }
        }
    }

    /*processTableflip() method for sending and printing messages*/
    void sendMessage(ChatMessage chatMessage) {
        synchronized (clients) {
            for (CommandInterpreter client : clients) {
                System.out.println("Client loop:" + chatMessage.message);

                client.getWriter().println(chatMessage.username + ": " + chatMessage.message);

            }
        }

    }

}

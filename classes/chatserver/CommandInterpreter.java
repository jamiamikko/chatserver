
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandInterpreter implements Runnable {

    /*Create new scanner object*/
    Scanner reader = new Scanner(System.in);

    /*Constructor for CommandInterpreter*/
    public CommandInterpreter(InputStream inputStream, PrintStream outputStream) {
    }

    /*run() method for CommandInterpreter*/
    public void run() {

        /*Instance variables and objects needed in run() method*/
        String username = "";
        ChatHistory chatHistory = new ChatHistory();
        ChatHistory getHistory = ChatHistory.getInstance();

        User newUser = new User("user");
        chatHistory.register(newUser);

        System.out.println("Hello!");
        System.out.print("Commands:\n:user = Change username\n:history = Show sent messages\n:help = List commands\n:quit = Quit application\n");
        System.out.print("Type a command: \n>");

        /*While loop for running the chat application*/
        while (true) {

            /*Read the next command*/
            String command = reader.nextLine();

            /*Switch case for commands*/
            switch (command) {
                /*Case for command :user*/

                case ":user":
                    /*Check if username is defined. Set new username if username is not defined.
                    Else print current username*/

                    if (username.isEmpty()) {
                        System.out.print("Username not set.");

                        System.out.println("Type your username: \n>");

                        username = reader.nextLine();
                        System.out.print("Username is " + username + "\n>");
                        newUser.changeUsername(username);
                    } else {
                        System.out.print("Username is " + username + "\n>");
                    }
                    break;

                /*Case for command :quit*/
                case ":quit":

                    /*Quit application*/
                    System.out.println("Goodbye.");
                    System.exit(0);

                /*Case for command :history*/
                case ":history":

                    /*Print history*/
                    System.out.print(getHistory.toString() + ">");
                    break;

                /*Case for command :help*/
                case ":help":

                    /*List all commands*/
                    System.out.print("Commands:\n:user = Change username\n:help = List commands\n:quit = Quit application\n>");
                    break;

                /*Default case*/
                default:
                    /*Check if username is defined. Set new username if username is not defined.
                    Else instert message to chatHistory and notify users.*/
                    if (username.isEmpty()) {
                        System.out.println("Username not set.");

                        System.out.print("Type your username: \n>");

                        username = reader.nextLine();
                        System.out.print("Username is " + username + "\n>");
                        newUser.changeUsername(username);
                    } else {

                        ChatMessage chatmessage = new ChatMessage(username, command);

                        chatHistory.insert(chatmessage);

                    }
            }

        }

    }

}

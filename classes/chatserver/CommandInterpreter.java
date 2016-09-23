import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandInterpreter implements Runnable {

    Scanner reader = new Scanner(System.in);

    public CommandInterpreter(InputStream inputStream, PrintStream outputStream) {

    }

    public void run() {
        String username = "";
        ChatHistory updateHistory = ChatHistory.getInstance();
        
        
        ChatHistory chatHistory = new ChatHistory();
        User userName = new User("user");
        chatHistory.register(userName);

        System.out.println("Hello!");
        System.out.print("Commands:\n:user = Change username\n:history = Show sent messages\n:help = List commands\n:quit = Quit application\n");
        System.out.print("Type a command: \n>");

        while (true) {

            String command = reader.nextLine();

            switch (command) {
                case ":user":
                    if (username.isEmpty()) {
                        System.out.print("Username not set.");

                        System.out.println("Type your username: \n>");

                        username = reader.nextLine();
                        System.out.print("Username is " + username + "\n>");
                    } else {
                        System.out.print("Username is " + username + "\n>");
                    }
                    break;
                case ":quit":
                    System.out.println("Goodbye.");
                    System.exit(0);
                case ":history":
                    System.out.print(updateHistory.toString() + ">");
                    break;
                case ":help":
                    System.out.print("Commands:\n:user = Change username\n:help = List commands\n:quit = Quit application\n>");
                    break;
                default:
                    if (username.isEmpty()) {
                        System.out.println("Username not set.");

                        System.out.print("Type your username: \n>");

                        username = reader.nextLine();
                        System.out.print("Username is " + username + "\n>");
                    } else {
                        System.out.print(username + ": " + command + "\n>");
                        ChatMessage chatmessage = new ChatMessage(username, command);

                        updateHistory.insert(chatmessage);

                    }
            }

        }
    }

}
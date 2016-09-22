
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandInterpreter implements Runnable {

    Scanner reader = new Scanner(System.in);

    public CommandInterpreter(InputStream inputStream, PrintStream outputStream) {

    }

    public void run() {
        String username = "";

        System.out.println("Hello!");

        ChatHistory history = ChatHistory.getInstance();

        while (true) {

            System.out.println("Type a command: ");
            String command = reader.nextLine();

            switch (command) {
                case ":user":
                    if (username.isEmpty()) {
                        System.out.println("Username not set.");

                        System.out.println("Type your username: ");

                        username = reader.nextLine();
                        System.out.println("Username is " + username);
                    } else {
                        System.out.println("Username is " + username);
                    }
                    break;
                case ":quit":
                    System.out.println("Goodbye.");
                    System.exit(0);

                case ":history":
                    System.out.print(history.toString());
                default:
                    if (username.isEmpty()) {
                        System.out.println("Username not set.");

                        System.out.println("Type your username: ");

                        username = reader.nextLine();
                        System.out.println("Username is " + username);
                    } else {
                        System.out.println(username + ": " + command);
                        ChatMessage chatmessage = new ChatMessage(username, command);

                        history.insert(chatmessage);

                    }
            }

        }
    }

}

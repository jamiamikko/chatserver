
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandInterpreter {

    public static Scanner reader = new Scanner(System.in);

    CommandInterpreter(InputStream in, PrintStream out) {
    }

    public void run() {

        String command;
        String username = "user";

        System.out.println("Hello! ");

        while (true) {
            command = reader.nextLine();

            if (command.equals(":user")) {
                System.out.println("Type your username: ");
                username = reader.nextLine();
                System.out.println("Your username has been set to " + username + ".");
            } else if (command.equals(":quit")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println(username + ":" + command);
            }
        }
    }
}

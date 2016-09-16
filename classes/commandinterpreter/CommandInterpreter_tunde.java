
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

        System.out.print("Hello!\n");
        System.out.print("Commands:\n:user = change username\n:help = list commands\n:quit = quit application\n>");

        while (true) {
            command = reader.nextLine();

            if (command.equals(":user")) {
                System.out.print("Type your new username: \n>");
                username = reader.nextLine();
                System.out.print("Your username has been set to " + username + ".\n>");
            }else if (command.equals(":help")){
                System.out.print("Commands:\n:user = Change username\n:help = List commands\n:quit = Quit application\n>");
            }else if (command.equals(":quit")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.print(username + ":" + command + "\n>");
            }
        }
    }
}

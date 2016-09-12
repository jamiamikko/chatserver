
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RYU
 */
public class CommandInterpreter {

    public static Scanner reader = new Scanner(System.in);

    CommandInterpreter(InputStream in, PrintStream out) {
    }

    public static void run() {

        String command;
        String username;
        
        System.out.println("Hello! ");

        while (true) {
            System.out.println("");
            command = reader.nextLine();

            if (command.equals(":user")) {
                System.out.println("Type your username: ");
                username = reader.nextLine();;
                System.out.print("Your username has been set to " + username);
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}

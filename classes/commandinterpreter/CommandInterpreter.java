/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandinterpreter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author jamiamikko
 */
public class CommandInterpreter {

    Scanner reader = new Scanner(System.in);

    public CommandInterpreter(InputStream in, PrintStream out) {
        
    }
    
    public void run() {
        String username = "";
        
        
        
        System.out.println("Hello!");
        
        
        while(true) {
            
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
                    }   break;
                case ":quit":
                    System.out.println("Goodbye.");
                    System.exit(0);
                default:
                    if (username.isEmpty()) {
                        System.out.println("Username not set.");
                        
                        System.out.println("Type your username: ");
                        
                        username = reader.nextLine();
                        System.out.println("Username is " + username);
                    } else {
                        System.out.println(username + ": " + command);
                        
                    }
            }
            
        }
    }
    
}

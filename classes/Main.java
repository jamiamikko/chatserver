
import commandinterpreter.CommandInterpreter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jamiamikko
 */
public class Main {
    
    
    public static void main(String args[]) throws IOException {
        ChatServer cs = new ChatServer();
        CommandInterpreter ci = new CommandInterpreter(System.in, System.out);
        //ci.run();
        cs.serve();
        
    }
}

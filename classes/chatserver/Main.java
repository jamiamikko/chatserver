
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

        /*Create new ChatServer object and run serve method.*/
        ChatServer cs = new ChatServer();

        cs.serve();

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

/*
Main class for starting and creating chat server.

@authors
Group Tableflipz
1402803 Jämiä Mikko
1406733 Järvinen Otto
1503524 Taba Tünde
 */
public class Main {

    public static void main(String args[]) throws IOException {

        /*Create new ChatServer object and run serve method.*/
        ChatServer cs = new ChatServer();
        System.out.println("Chat Started");

        cs.serve();

    }
}


import java.io.IOException;

/*
Main class creates a new chat server.

@authors
1402803 Jämiä Mikko
1406733 Järvinen Otto
1503524 Taba Tünde
 */
public class Main {

    public static void main(String args[]) throws IOException {

        /*Create new ChatServer object and run serve method.*/
        ChatServer cs = new ChatServer();

        cs.serve();

    }
}

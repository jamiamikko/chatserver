import java.io.*;
import java.net.*;

public class ChatClient {

    /*public static void serve(String arg[]) throws IOException {
        BufferedReader br;
        BufferedReader in;
        PrintWriter out;
        String message;
        Socket s;
        s = new Socket("localhost", 6666);
    System.err.println("Connection error!");
            e.printStackTrace();
        System.out.println("Connection established!!");
        br = new BufferedReader(new InputStreamReader(System.in));

        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
        while (true) {
            System.out.println("Server:" + in.readLine());
            message = br.readLine();
            out.println(message);
            out.flush();
        }

    }*/
    public static void main(String[] args) throws IOException {

        try {
            Socket socket = new Socket("localhost", 6666); //type the given localport instead of 6666!
            CommandInterpreter interpreter = new CommandInterpreter(socket.getInputStream(), new PrintStream(socket.getOutputStream()));
            Thread.sleep(1000);
            Thread thread = new Thread((Runnable) interpreter);
            thread.start();
        } catch (IOException e) {
            System.out.println("Connection error!");
        } catch (InterruptedException e) {
            System.out.println("Connection error!");
        }
    }
}

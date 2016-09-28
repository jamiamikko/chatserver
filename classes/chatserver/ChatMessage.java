/*
This is the message object class.

@authors
1402803 Jämiä Mikko
1406733 Järvinen Otto
1503524 Taba Tünde
 */
public class ChatMessage {

    /*Instance variables for ChatMessage*/
    String message;
    String username;

    /*Constructor for ChatMessage*/
    ChatMessage(String username, String message) {
        this.username = username;
        this.message = message;
    }

    /*toString() method, returns the message*/
    @Override
    public String toString() {
        return this.message;
    }

}

/*
This is the message object class.

@authors
Group Tableflipz
1402803 Jämiä Mikko
1406733 Järvinen Otto
1503524 Taba Tünde
 */
public class ChatMessage {

    /*Instance variables for ChatMessage*/
    String message;
    String username;

    /*Constructor for ChatMessage, accepts username and message as a parameters.*/
    ChatMessage(String username, String message) {
        this.username = username;
        this.message = message;
    }
    
    
    /*Constructor for ChatMessage, accepts input as a parameter. Parses the input to two variables username and message*/
    ChatMessage(String input) {
        int idx = input.indexOf(':'); //TODO error handling
        username = input.substring(0, idx);
        message = input.substring(idx + 2);
    }

    /*toString() method, returns the message*/
    @Override
    public String toString() {
        return username + ": " + message;
    }

}

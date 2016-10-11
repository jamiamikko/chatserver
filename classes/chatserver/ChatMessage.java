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
    String timeStamp;
    String message;
    String username;
    
    /*Constructor for ChatMessage, accepts input as a parameter. Parses the input to two variables username and message*/
    ChatMessage(String input) {
        System.out.println("I'm here I: " + input);
        int idx = input.indexOf(']');
        System.out.println("index1 = " + idx);
        int idx2 = input.indexOf(':'); //TODO error handling
        System.out.println("index2 = " + idx2);
        timeStamp = input.substring(0, idx+1);
        username = input.substring(idx+1, idx2);
        message = input.substring(idx2 + 2);
        System.out.println("I'm here II: " + timeStamp + "_" + username + "_" + message);
    }

    /*toString() method, returns the message*/
    @Override
    public String toString() {
        return timeStamp + username + ": " + message;
    }

}
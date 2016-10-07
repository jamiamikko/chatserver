
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/*
This class is an instance that gets the messages from the CommandInterpreter and turns them into a String.

@authors
Group Tableflipz
1402803 Jämiä Mikko
1406733 Järvinen Otto
1503524 Taba Tünde
 */
public class ChatHistory {

    /*Instance variables for ChatHistory*/
    static ArrayList<ChatMessage> messageList;
    private static ChatHistory instance = new ChatHistory();


    /*Constructor for ChatHistory*/
    private ChatHistory() {
        this.messageList = new ArrayList<>();
    }

    /*getInstance() method for ChatHistory. Method returns the instance,
    for printing the chat history*/
    public static ChatHistory getInstance() {
        return instance;
    }

    /*insert() method for ChatHistory. Method adds message to chat history and runs notifyObservers method.*/
    synchronized public void insert(ChatMessage chatMessage) {
        messageList.add(chatMessage);
    }

    /*toString() method for chatHistory. Method adds time stamp to messages and
    return chatHistory as a string*/
    @Override
    synchronized public String toString() {
        String list = "System: History: #";

        for (int i = 0; i < messageList.size(); i++) {

            list += ("[OLD]" + messageList.get(i).username + ": " + messageList.get(i).message + "#");
        }
        System.out.println("list:" + list);
        return list;
    }
}

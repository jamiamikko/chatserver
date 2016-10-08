
import java.util.ArrayList;

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
    ArrayList<ChatMessage> messageList;
    private static ChatHistory instance = new ChatHistory();


    /*Constructor for ChatHistory*/
    private ChatHistory() {
        this.messageList = new ArrayList<>();
    }

    /*Returns the instance.*/
    public static ChatHistory getInstance() {
        return instance;
    }

    /*insert() method for ChatHistory. Method adds message to chat history.*/
    synchronized public void insert(ChatMessage chatMessage) {
        messageList.add(chatMessage);
    }

    /*toString() method for chatHistory. Returns messageList as a string*/
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
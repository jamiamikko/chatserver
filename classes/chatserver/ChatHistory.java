
import java.util.ArrayList;

public class ChatHistory {

    private static ChatHistory instance = new ChatHistory();

    static ArrayList<ChatMessage> messageHistory = new ArrayList<ChatMessage>();

    private ChatHistory() {
        
    }

    public static ChatHistory getInstance() {
        return instance;
    }

    public void insert(ChatMessage chatMessage) {
        messageHistory.add(chatMessage);

        //System.out.println("HEHEHE" + chatMessage.message);
    }

    @Override
    public String toString() {
        String list = new String();

        for (ChatMessage element : messageHistory) {
            list += (element.username + ": " + element.message + "\n");
        }

        return list;
    }
}

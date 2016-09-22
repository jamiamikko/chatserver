
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

            list += (timeStamp + " " + element.username + ": " + element.message + "\n");
        }

        return list;
    }
}

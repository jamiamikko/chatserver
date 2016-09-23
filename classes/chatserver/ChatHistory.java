
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChatHistory implements ObservableChat{
    private ArrayList<ChatObserver> observers;
   
    private static ChatHistory instance = new ChatHistory();
    static ArrayList<ChatMessage> messageHistory;

    public ChatHistory() {
        this.observers=new ArrayList<>();
        this.messageHistory = new ArrayList<>();
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

    @Override
    public void register(ChatObserver observer) {
        observers.add(observer);
        
    }

    @Override
    public void deregister(ChatObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(ChatMessage message) {
        System.out.println("History change: "+message);
    }
}

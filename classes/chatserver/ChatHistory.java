
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jamiamikko
 */
public class ChatHistory {
    
    private ChatMessage chatMessage;
    private String message;
    private String username;
    
    private ArrayList<ChatMessage> messageHistory = new ArrayList<ChatMessage>();
    
    public String history;
    
    
    private ChatHistory() {
        this.chatMessage = new ChatMessage(username, message);
    }
    
    public static ChatHistory getInstance() {
        return ChatHistoryHolder.INSTANCE;
    }
    
    private static class ChatHistoryHolder {

        private static final ChatHistory INSTANCE = new ChatHistory();
        
        
    }
    
    public void insert(ChatMessage chatMessage) {
        messageHistory.add(chatMessage);
        
        System.out.println("HEHEHE");
    }
    
    @Override public String toString() {
       
        for(ChatMessage element : messageHistory) {
            history += element;
        }
        
        return history;
    }
}

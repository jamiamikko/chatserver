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
    
    private ChatHistory() {
    }
    
    public static ChatHistory getInstance() {
        return ChatHistoryHolder.INSTANCE;
    }
    
    private static class ChatHistoryHolder {

        private static final ChatHistory INSTANCE = new ChatHistory();
    }
    
    public void insert(ChatMessage message) {
    
    }
    
    @Override public String toString() {
    
        return "";
    }
}

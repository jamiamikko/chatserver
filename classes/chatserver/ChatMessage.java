/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jamiamikko
 */
public class ChatMessage {
    String message;
    String username;
    
    ChatMessage(String username, String message) {
        this.username = username;
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
    
    
}
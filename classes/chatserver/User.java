/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Otto
 */
public class User implements ChatObserver {
    private String name;
    public User(String name){
        this.name = name;
    }
    @Override
    public void update(ChatMessage message) {
        System.out.println(name + " got updated history: " + message);
    }
    
}

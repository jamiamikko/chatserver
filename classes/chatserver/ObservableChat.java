/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Otto
 */
public interface ObservableChat {

    /*register() method for registering new observer*/
    public void register(ChatObserver observer);

    /*deregister() method for removing observer*/
    public void deregister(ChatObserver observer);

    /*notifyObservers() method for notifying observers*/
    void notifyObservers(ChatMessage message);
}

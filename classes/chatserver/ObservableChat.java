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
    public void register(ChatObserver observer);
    public void deregister(ChatObserver observer);
    void notifyObservers(ChatMessage message);
}

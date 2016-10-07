/*
Observable interface.

@authors
1402803 Jämiä Mikko
1406733 Järvinen Otto
1503524 Taba Tünde
 */
public interface ObservableChat {

    /*register() method for registering new observer*/
    public void register(ChatObserver observer);

    /*deregister() method for removing observer*/
    public void deregister(ChatObserver observer);

    /*notifyObservers() method for notifying observers*/
    void notifyObservers(ChatMessage message);
}

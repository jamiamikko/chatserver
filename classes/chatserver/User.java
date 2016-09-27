
public class User implements ChatObserver {

    /*Instace variables for chatObserver*/
    String name;
    String status;

    /*Constructor for User*/
    public User(String name) {
        this.name = name;
        this.status = status;
    }

    /*changeUsername() method for User. Changes current username to new one.*/
    public void changeUsername(String name) {
        this.name = name;
    }

    /*statusOnline() method for User. Changes status to online*/
    public void statusOnline(String online) {
        status = online;
    }

    /*toString() method for User. Return username and status*/
    @Override
    public String toString() {
        return name + " status: " + status;
    }

    /*update() to print out new messages*/
    @Override
    public void update(ChatMessage message) {

        System.out.print(name + ": " + message + "\n>");
    }

}

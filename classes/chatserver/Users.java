
import java.util.ArrayList;

/*
This is an instance for the list of the users.

@authors:
1402803 Jämiä Mikko
1406733 Järvinen Otto
1503524 Taba Tünde
 */
public class Users {
    /*Instance variables for Users*/
    private ArrayList<String> userlist;
    private static Users instance = new Users();
    
    /*Constructor for Users*/
    public Users() {

        this.userlist = new ArrayList<>();
    }

    /*Method for checking if user exists in userlist*/
    public boolean exists(String user) {
        for (String u : userlist) {
            if (u.equals(user)) {
                return true;
            }
        }
        return false;
    }
    /*Method returns the userlist*/
    public static Users getInstance() {
        return instance;
    }
    
    /*Method removes user from the userlist*/
    public void remove(String name) {
        userlist.remove(name);

    }

    /*Method adds user to the userlist*/
    public void insert(String name) {
        userlist.add(name);
        
    }

    /*Method returns the list of registered users as a string*/
    @Override
    public String toString() {
        String list = new String();

        for (String name : userlist) {

            list += (name + "\n");
        }

        return list;
    }
}

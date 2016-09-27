
import java.util.ArrayList;

public class Users {

    private ArrayList<User> userlist;

    private Users() {
    }

    public boolean exists(User user) {
        for (User u : userlist) {
            if (u.name.equals(user.name)) {
                return true;
            }
        }
        return false;
    }

    public static Users getInstance() {
        return UsersHolder.INSTANCE;
    }

    public void remove(User name) {
        userlist.remove(name);

    }

    public void insert(User name) {
        userlist.add(name);

    }

    private static class UsersHolder {

        private static final Users INSTANCE = new Users();
    }

    public String toString() {
        String list = new String();

        for (User element : userlist) {

            list += (element.name + "\n");
        }

        return list;
    }
}

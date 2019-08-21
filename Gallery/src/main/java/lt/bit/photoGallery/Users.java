package lt.bit.photoGallery;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
public class Users {

    private String user;
    private String password;
    private static LinkedList<Users> userList = null;

    private Users(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public static LinkedList<Users> getUsers() {
        if (userList == null) {
            try {
                userList = new LinkedList<>();
                FileInputStream fi = new FileInputStream(new File("C:/Users/User/Documents/JavaHomeWork/Gallery/data/users.txt"));
                ObjectInputStream ois = new ObjectInputStream(fi);
                userList = (LinkedList<Users>) ois.readObject();
                ois.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return userList;
    }
    public static void addAccount(String userID, String password) {
        try {
            userList.add(new Users(userID, password));

            FileOutputStream fo = new FileOutputStream(new File("C:/Users/User/Documents/JavaHomeWork/Gallery/data/users.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(userList);
            oos.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }


}

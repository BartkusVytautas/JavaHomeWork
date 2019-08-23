package lt.bit.formToSQL;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DB {
    private static DB db = null;
    private String user;
    private String password;
    private static final String urlDB = "jdbc:mysql://localhost/users?user=root&password=admin";



    private DB(String user, String password) throws SQLException {
        this.user = user;
        this.password = password;


    }



    public static DB getDb(String user, String password) throws SQLException {
        if(db == null){
            db = new DB(user, password);
        }
        return db;
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

    public static void AddToDB (String user, String password) throws SQLException, ClassNotFoundException {

        if(!doesUserExist(user)){
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(urlDB);
            PreparedStatement statement = connect.prepareStatement("INSERT INTO users (user_name, password) VALUES (?, ?) ");
            statement.setString(1,user);
            statement.setString(2,password);
            statement.executeUpdate();
            statement.close();
            connect.close();
        }
    }

    private static boolean doesUserExist(String user) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect = DriverManager.getConnection(urlDB);
        PreparedStatement statement = connect.prepareStatement("select userID from employees WHERE user_name=? ");
        statement.setString(1,user);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            resultSet.close();
            statement.close();
            connect.close();
            return true;
        }else {
            resultSet.close();
            statement.close();
            connect.close();
            return false;
        }




    }





}

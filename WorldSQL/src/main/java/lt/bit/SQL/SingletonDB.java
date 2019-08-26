package lt.bit.SQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonDB {
    private static Connection connection = null;


    public static Connection getConnect(){
        if (connection == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/worlddb?user=root&password=admin");
            }catch (Exception e){

            }

        }
        return connection;
    }
}

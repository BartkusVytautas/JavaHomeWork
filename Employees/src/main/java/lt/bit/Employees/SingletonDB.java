package lt.bit.Employees;

import java.sql.*;

public class SingletonDB {

    private static Connection connection = null;

    public static Connection connectToDB() {
        if(connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/employees?user=root&password=admin");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return connection;
    }
}

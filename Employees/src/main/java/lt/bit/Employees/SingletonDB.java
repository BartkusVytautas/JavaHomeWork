package lt.bit.Employees;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class SingletonDB {

    private static Connection connection = null;

    public static Connection connectToDB() {
        if(connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
//                    try {
//                        java.sql.DriverManager.registerDriver(new Driver());
//                    } catch (SQLException E) {
//                        throw new RuntimeException("Can't register driver!");
//                    }

                connection = DriverManager.getConnection("jdbc:mysql://localhost/employees?user=root&password=admin");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return connection;
    }
}

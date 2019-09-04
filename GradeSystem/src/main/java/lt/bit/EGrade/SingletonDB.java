package lt.bit.EGrade;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class SingletonDB {

    private static Connection connection = null;

    public static Connection connectToDB() {
        if(connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/student_grades?user=root&password=admin");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return connection;
    }
}

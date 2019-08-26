package lt.bit.SQL;


import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

         Statement statement = null;
         PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;

//Duomenų bazės tvarkyklės užkrovimas
        Class.forName("com.mysql.cj.jdbc.Driver");

//Prisijungimas prie DB
        //connect = DriverManager.getConnection("jdbc:mysql://localhost/worlddb?user=root&password=admin");

//Užklausos generavimas
        statement = SingletonDB.getConnect().createStatement();

//Rezultato gavimas
        resultSet = statement.executeQuery("select * from country where continent = 'Europe' and population > 10000000");

//Rezultatų spausdinimas
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            Integer population = resultSet.getInt("population");
            System.out.println(name + " - " + population);
        }

        resultSet.close();
        statement.close();

    }
}

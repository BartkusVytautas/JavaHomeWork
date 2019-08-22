package lt.baltictalents.Duombaze;

import java.sql.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	 Connection connect = null;
    	 PreparedStatement statement = null;
    
    	 ResultSet resultSet = null;

    	//Duomenų bazės tvarkyklės užkrovimas
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	           
    	//Prisijungimas prie DB
    	connect = DriverManager.getConnection("jdbc:mysql://localhost/darbuotojai?user=darbuotojai&password=labas");

    	//Užklausos generavimas
    	statement = connect.prepareStatement("select * from employees WHERE surname=? ");

    	Scanner sc=new Scanner(System.in); 
    	System.out.print("Vartotojo pavarde: ");
    	String pavarde=sc.next();
    	
    	statement.setString(1,pavarde);
    	
    	
    	//Rezultato gavimas
    	resultSet = statement.executeQuery();
    	
    	System.out.println(statement.toString());
    	
    	//Rezultatų spausdinimas
    	while (resultSet.next()) {
    	   System.out.print(   resultSet.getString("name") +" "  );
    	   System.out.println(  resultSet.getInt("salary"));
    	}

    	resultSet.close();
    	statement.close();
    	connect.close();
    }
}

package lt.bit.Employees;

import java.sql.*;
import java.util.LinkedList;

public class Employee {

    private String name;
    private int id;
    private String surname;
    private String gender;
    private String phone;
    private String birthday;
    private String education;
    private int salary;
    private int number;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Employee(String name, String surname, String gender, String phone, String birthday, String education, int salary) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.phone = phone;
        this.birthday = birthday;
        this.education = education;
        this.salary = salary;
    }

    private Employee(int number, int id, String name, String surname, String gender, String phone, String birthday, String education, int salary) {
        this.name = name;
        this.id = id;
        this.surname = surname;
        this.gender = gender;
        this.phone = phone;
        this.birthday = birthday;
        this.education = education;
        this.salary = salary;
        this.number = number;

    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEducation() {
        return education;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static LinkedList<Employee> getEmployeesFromDB() {
        LinkedList<Employee> emps = new LinkedList<>();
        try {
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            preparedStatement = SingletonDB.connectToDB().prepareStatement("SELECT * FROM employees");
            resultSet = preparedStatement.executeQuery();
            int i = 1;
            while (resultSet.next()) {

                int ID = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String gender = resultSet.getString("gender");
                String phone = resultSet.getString("phone");
                String birthday = resultSet.getString("birthday");
                String education = resultSet.getString("education");
                int salary = resultSet.getInt("salary");
                emps.add(new Employee(i, ID, name, surname, gender, phone, birthday, education, salary));
                i++;
            }
        } catch (Exception e) {
            emps = null;
        }
        return emps;
    }

    public static Employee addEmployeeToDB(String name, String surname, String gender, String phone, String birthday, String education, int salary) {
        Employee emp;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("INSERT INTO employees (name, surname, phone, gender, birthday, education, salary) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, birthday);
            preparedStatement.setString(6, education);
            preparedStatement.setInt(7, salary);
            preparedStatement.executeUpdate();
            emp = new Employee(name, surname, gender, phone, birthday, education, salary);

        } catch (Exception e) {
            emp = null;
        }
        return emp;
    }

    public static void deleteFromDB(int id) {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("DELETE FROM employees where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateDB(int id, String name, String surname, String gender, String phone, String education, String birthday, int salary) {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("UPDATE employees set name = ?, surname = ?, gender = ?, phone = ?, education = ?, birthday = ?, salary = ? where id = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, education);
            preparedStatement.setString(6, birthday);
            preparedStatement.setInt(7, salary);
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

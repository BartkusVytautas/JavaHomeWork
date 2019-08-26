package lt.bit.Employees;

import java.sql.*;

public class Employee {

    private String name;
    private String surname;
    private String gender;
    private String phone;
    private String birthday;
    private String education;
    private int salary;

    private Employee(String name, String surname, String gender, String phone, String birthday, String education, int salary) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.phone = phone;
        this.birthday = birthday;
        this.education = education;
        this.salary = salary;
    }

    public String getName() {
        return name;
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

    public static Employee getEmployeeFromDB(int id) {
        Employee emp;
        try{
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            preparedStatement = SingletonDB.connectToDB().prepareStatement("SELECT * FROM country WHERE id = ? ");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String gender = resultSet.getString("gender");
            String phone = resultSet.getString("phone");
            String birthday = resultSet.getString("birthday");
            String education = resultSet.getString("education");
            int salary = resultSet.getInt("salary");
            emp = new Employee(name, surname, gender, phone, birthday, education, salary);
        }catch (Exception e){
            emp = null;
        }
        return emp;
    }
}

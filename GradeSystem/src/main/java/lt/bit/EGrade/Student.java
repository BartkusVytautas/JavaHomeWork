package lt.bit.EGrade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Student {
    private String name;
    private String surname;
    private Integer id;

    public Student() {
    }

    public Student(String name, String surname, Integer id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static LinkedList<Student> getStudents() {
        LinkedList<Student> students = new LinkedList<>();
        try {
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            preparedStatement = SingletonDB.connectToDB().prepareStatement("SELECT * FROM students");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Integer ID = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                students.add(new Student(name, surname, ID));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            students = null;
        }
        return students;
    }

    public static void addStudent(String name, String surname) {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("INSERT INTO students (name, surname) VALUES (?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id) {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("DELETE FROM students where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void update() {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("UPDATE employees set name = ?, surname = ? where id = ?");
            preparedStatement.setString(1, this.name);
            preparedStatement.setString(2, this.surname);
            preparedStatement.setInt(3, this.id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

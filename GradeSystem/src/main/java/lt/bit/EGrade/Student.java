package lt.bit.EGrade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Student {
    private String name;
    private String surname;
    private Integer id;
    private  HashMap<Integer, Grades> studentGrades = null;
    private static HashSet<Student> students = null;

    public Student() {
    }

    private Student(String name, String surname, Integer id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        students.add(this);
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        students.add(this);
    }

    public String getName() {
        return name;
    }
    public static HashSet<Student> studentList(){
        if(students == null){
            students = new HashSet<>();
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
        }
        return students;
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

    public  HashMap<Integer, Grades> getStudentGrades(){
        if ( studentGrades == null){
            studentGrades = new HashMap<>();
        }
        return studentGrades;
    }

    public static Student getStudent(Integer id){
        Student student = null;
        try {
            for(Student s: Student.studentList()){
                if(id == s.getId()){
                    student = s;
                }
            }

        }catch (Exception e){
            student = null;
        }
        return student;
    }

    public static void addStudent(String name, String surname) {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("INSERT INTO students (name, surname) VALUES (?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.executeUpdate();
            students.add(new Student(name, surname));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(Integer id) {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("DELETE FROM grades where student_id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            students.remove(Student.getStudent(id));
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
    public boolean equals (Object o){
        if (this.id == ((Student) o).getId()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}

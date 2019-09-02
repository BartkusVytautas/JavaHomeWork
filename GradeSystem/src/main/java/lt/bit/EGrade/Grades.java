package lt.bit.EGrade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Grades{


    private Student student;
    private Subject subject;
    private Integer grade;
    private Integer id;

    public Grades(){

    }

    private Grades(Integer id, Integer grade){
        this.id = id;
        this.grade = grade;
        try{
            PreparedStatement preparedStatement = SingletonDB.connectToDB().prepareStatement("SELECT * FROM grades WHERE id = ?");
            preparedStatement.setInt(1, this.id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            this.student = Student.getStudent(resultSet.getInt("student_id"));
            this.student.getStudentGrades().put(this.id, this);
            this.subject = Subject.getSubject(resultSet.getInt("subject_id"));
            this.subject.getSubjectGrades().put(this.id, this);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public Integer getGrade() {
        return grade;
    }

    public Integer getId() {
        return id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static LinkedList<Grades> getGrades() {
        LinkedList<Grades> grades = new LinkedList<>();
        try {
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            preparedStatement = SingletonDB.connectToDB().prepareStatement("SELECT * FROM grades");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Integer ID = resultSet.getInt("id");
                Integer grade = resultSet.getInt("grade");
                grades.add(new Grades(ID, grade));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            grades = null;
        }
        return grades;
    }

    public static Grades getGrade(Integer id){
        Grades grades;
        try {
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            preparedStatement = SingletonDB.connectToDB().prepareStatement("SELECT * FROM grades WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Integer ID = resultSet.getInt("id");
            Integer grade = resultSet.getInt("grade");
            grades = new Grades(ID, grade);

        }catch (Exception e){
            grades = null;
        }
        return grades;
    }

    public  void update() {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("UPDATE grades set grade = ? where id = ?");
            preparedStatement.setInt(1, this.grade);
            preparedStatement.setInt(2, this.id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean equals (Object o){
        if (this.id == ((Grades) o).getId()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}

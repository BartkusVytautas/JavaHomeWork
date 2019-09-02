package lt.bit.EGrade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Grades{


    private Student student;
    private Subject subject;
    private Integer grade = null;
    private Integer id;
    public static LinkedList<Grades> grades;

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
        if (grades == null) {
            grades = new LinkedList<>();
        }
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

    static void initGradesForStudents(Student s){
        if(Student.studentList() != null && Subject.subjectList() != null){
            try{
                for(Subject sub: Subject.subjectList()) {
                    if (!isSameGrade(s.getId(), sub.getId())) {
                        PreparedStatement preparedStatement = SingletonDB.connectToDB().prepareStatement
                                ("INSERT INTO grades (student_id, subject_id) VALUES (?,?)");
                        preparedStatement.setInt(1, s.getId());
                        preparedStatement.setInt(2, sub.getId());
                        preparedStatement.executeUpdate();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    static void initGradesForSubjects(Subject s){
        if(Student.studentList() != null && Subject.subjectList() != null){
            try{
                for(Student stud: Student.studentList()) {
                    if (!isSameGrade(stud.getId(), s.getId())) {
                        PreparedStatement preparedStatement = SingletonDB.connectToDB().prepareStatement
                                ("INSERT INTO grades (student_id, subject_id) VALUES (?,?)");
                        preparedStatement.setInt(1, stud.getId());
                        preparedStatement.setInt(2, s.getId());
                        preparedStatement.executeUpdate();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private static boolean isSameGrade(Integer st_id, Integer sub_id){
        try{
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            preparedStatement = SingletonDB.connectToDB().prepareStatement("SELECT * FROM grades");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer stu = resultSet.getInt("student_id");
                Integer sub = resultSet.getInt("subject_id");
                if(st_id == stu && sub_id == sub){
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }
    public boolean equals (Object o){
        if (this.id == ((Grades) o).getId()){
            return true;
        }
        return false;
    }

    public static void delete (Grades g) {
        try {
            PreparedStatement preparedStatement;
            g.getSubject().getSubjectGrades().remove(g.getId());
            g.getStudent().getStudentGrades().remove(g.getId());
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("DELETE FROM grades where id = ?");
            preparedStatement.setInt(1, g.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}

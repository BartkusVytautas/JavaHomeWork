package lt.bit.EGrade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;

public class Subject {
    private String name;
    private String description;
    private Integer id;
    private HashMap<Integer, Grades> subjectGrades = null;
    private static HashSet<Subject> subjects = null;

    public Subject() {
    }

    private Subject(String name, String description, Integer id) {
        this.name = name;
        this.description = description;
        this.id = id;
        subjects.add(this);
        Grades.initGradesForSubjects(this);
    }

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public  HashMap<Integer, Grades> getSubjectGrades(){
        if (subjectGrades == null){
            subjectGrades = new HashMap<>();
        }
        return subjectGrades;
    }

    public static HashSet<Subject> subjectList(){
        if(subjects == null){
            subjects = new HashSet<>();
            try {
                PreparedStatement preparedStatement;
                ResultSet resultSet;

                preparedStatement = SingletonDB.connectToDB().prepareStatement("SELECT * FROM subjects");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {

                    Integer ID = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    subjects.add(new Subject(name, description , ID));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                subjects = null;
            }
        }
        return subjects;
    }

    public static Subject getSubject(Integer id){
        Subject subject = null;
        try {
            for(Subject s: Subject.subjectList()){
                if(id == s.getId()){
                    subject = s;
                }
            }

        }catch (Exception e){
            subject = null;
        }
        return subject;
    }

    public static void addSubject(String name, String description) {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("INSERT INTO subjects (name, description) VALUES (?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.executeUpdate();
            Subject.subjects = null;
            Grades.grades = null;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(Integer id) {
        try {
            PreparedStatement preparedStatement;
            for(Grades g: Grades.getGrades()){
                if(Subject.getSubject(id).getId() == g.getId()){
                    Grades.delete(g);
                }
            }
            subjects.remove(Subject.getSubject(id));
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("DELETE FROM subjects where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            Grades.grades = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void update() {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("UPDATE subjects set name = ?, description = ? where id = ?");
            preparedStatement.setString(1, this.name);
            preparedStatement.setString(2, this.description);
            preparedStatement.setInt(3, this.id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean equals (Object o){
        if (this.id == ((Subject) o).getId()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    public String toString(){
        return this.name + " " + this.description;
    }


}


package lt.bit.EGrade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Subject {
    private String name;
    private String description;
    private Integer id;
    private Integer grade = null;

    public Subject() {
    }

    public Subject(String name, String description, Integer id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
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

    public static LinkedList<Subject> getSubjects() {
        LinkedList<Subject> subjects = new LinkedList<>();
        try {
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            preparedStatement = SingletonDB.connectToDB().prepareStatement("SELECT * FROM subjects");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Integer ID = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                subjects.add(new Subject(name, description, ID));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            subjects = null;
        }
        return subjects;
    }

    public static void addSubject(String name, String description) {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("INSERT INTO subjects (name, description) VALUES (?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id) {
        try {
            PreparedStatement preparedStatement;
            preparedStatement = SingletonDB.connectToDB().prepareStatement
                    ("DELETE FROM subjects where id = ?");
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
                    ("UPDATE subjects set name = ?, description = ? where id = ?");
            preparedStatement.setString(1, this.name);
            preparedStatement.setString(2, this.description);
            preparedStatement.setInt(3, this.id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


package lt.bit.EGrade;

import java.util.HashMap;

public class Grades {

    private static HashMap<Student, Subject> gradeList = null;
    private Student student;
    private Subject subject;

    public static HashMap<Student, Subject> getGradeList (){
        if (gradeList == null){
            gradeList = new HashMap<>();
        }
        return gradeList;
    }
}

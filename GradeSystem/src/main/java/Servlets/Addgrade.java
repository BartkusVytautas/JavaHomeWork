package Servlets;

import lt.bit.EGrade.Grades;
import lt.bit.EGrade.Student;
import lt.bit.EGrade.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Addgrade", urlPatterns = {"/Addgrade"})
public class Addgrade extends HttpServlet {

    public static Student student;
    public static Subject subject;
    public static Grades grade;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("student") != null) {
            Integer sid = Integer.parseInt(request.getParameter("student"));
            request.setAttribute("form1", 1);
            request.setAttribute("form2", 1);
            Student s = Student.getStudent(sid);
            student = s;
            request.setAttribute("gradess", s.getStudentGrades());
            System.out.println(s.getStudentGrades());
            RequestDispatcher dispatcher =request.getRequestDispatcher("/addgrade.jsp");
            dispatcher.forward(request, response);
        }
        if (request.getParameter("subject") !=null){
            request.setAttribute("form2", null);
            request.setAttribute("form3", 1);
            Integer gradeId = Integer.parseInt(request.getParameter("subject"));
            request.setAttribute("gradeValue", Grades.getGrade(gradeId).getId());
            grade = Grades.getGrade(gradeId);
            subject = Grades.getGrade(gradeId).getSubject();
            RequestDispatcher dispatcher =request.getRequestDispatcher("/addgrade.jsp");
            dispatcher.forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentss", Student.studentList());
        RequestDispatcher dispatcher =request.getRequestDispatcher("/addgrade.jsp");
        dispatcher.forward(request, response);

    }
}

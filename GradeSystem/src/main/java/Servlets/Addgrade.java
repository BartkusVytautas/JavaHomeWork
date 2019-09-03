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

    public static Grades grade;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("addchange") != null){
            grade = Grades.getGrade(Integer.parseInt(request.getParameter("addchange")));
            grade.setGrade(Integer.parseInt(request.getParameter("gradeValue")));
            grade.update();
            request.setAttribute("form1", null);
            request.setAttribute("form2", null);
            response.sendRedirect("Display");
            return;
        }

        request.setAttribute("form1", 1);
        request.setAttribute("form2", 2);
        Integer studentId = Integer.parseInt(request.getParameter("student"));
        Integer subjectId = Integer.parseInt(request.getParameter("subject"));
        for (Grades g: Grades.getGrades()){
            if((g.getStudent().getId() == Student.getStudent(studentId).getId()) && (g.getSubject().getId() == Subject.getSubject(subjectId).getId())){
                grade = g;
                break;
            }
        }

        request.setAttribute("gradee", grade);
        RequestDispatcher dispatcher =request.getRequestDispatcher("/addgrade.jsp");
        dispatcher.forward(request, response);





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentss", Student.studentList());
        request.setAttribute("subjectss", Subject.subjectList());
        RequestDispatcher dispatcher =request.getRequestDispatcher("/addgrade.jsp");
        dispatcher.forward(request, response);

    }
}

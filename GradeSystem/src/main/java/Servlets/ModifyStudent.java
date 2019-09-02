package Servlets;

import lt.bit.EGrade.Grades;
import lt.bit.EGrade.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "ModifyStudent", urlPatterns = {"/ModifyStudent"})
public class ModifyStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("studentid"));
        Student student = Student.getStudent(id);
        request.setAttribute("student", student);
        LinkedList<Grades> grades =Grades.getGrades();
        for(Grades g: grades){
            if(g.getStudent().equals(student)){
                student = g.getStudent();
                break;
            }
        }
        request.setAttribute("grades", student.getStudentGrades());
        RequestDispatcher dispatcher =request.getRequestDispatcher("/studentinfo.jsp");
        dispatcher.forward(request, response);
    }
}

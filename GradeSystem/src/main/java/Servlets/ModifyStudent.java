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
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Integer id = Integer.parseInt(request.getParameter("id"));
        Student s = Student.getStudent(id);
        s.setName(name);
        s.setSurname(surname);
        s.update();
        request.setAttribute("modifystudent", null);
        response.sendRedirect("ModifyStudent" + "?studentid=" + s.getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("studentid") !=null) {
            Integer id = Integer.parseInt(request.getParameter("studentid"));
            Student student = Student.getStudent(id);
            request.setAttribute("student", student);
            Grades.getGrades();
            request.setAttribute("grades", student.getStudentGrades());
        }
        if(request.getParameter("modifystudent")!=null){
            request.setAttribute("modifyStudent", 1);
        }
        RequestDispatcher dispatcher =request.getRequestDispatcher("/studentinfo.jsp");
        dispatcher.forward(request, response);
    }
}

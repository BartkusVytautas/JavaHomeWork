package Servlets;

import lt.bit.EGrade.Student;
import lt.bit.EGrade.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;

@WebServlet(name = "Display", urlPatterns = {"/Display"})
public class Display extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashSet<Student> students = Student.studentList();
        HashSet<Subject> subjects = Subject.subjectList();
        request.setAttribute("subjects", subjects);
        request.setAttribute("students", students);
        RequestDispatcher dispatcher =request.getRequestDispatcher("/table.jsp");
        dispatcher.forward(request, response);
    }
}

package Servlets;

import lt.bit.EGrade.Student;
import lt.bit.EGrade.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
        Cookie cookie = null;
        if(request.getCookies() != null) {
            for (Cookie c : request.getCookies()) {
                if (c.getName().equals("logged") && c.getValue().equals("logged")) {
                    cookie = c;
                    break;
                }
            }
        }
        if(cookie == null) {
            if (request.getSession().getAttribute("login") == null || (Integer) request.getSession().getAttribute("login") == 0) {
                response.sendRedirect("Login");
                return;
            }
        }
        HashSet<Student> students;
        HashSet<Subject> subjects;
        students = Student.studentList();
        subjects = Subject.subjectList();
        request.setAttribute("subjects", subjects);
        request.setAttribute("students", students);
        RequestDispatcher dispatcher =request.getRequestDispatcher("/table.jsp");
        dispatcher.forward(request, response);
    }
}

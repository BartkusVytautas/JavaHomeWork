package Servlets;

import lt.bit.EGrade.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Addstudent", urlPatterns = {"/Addstudent"})
public class Addstudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Student.addStudent(name, surname);
        request.setAttribute("canAdd", null);
        RequestDispatcher dispatcher =request.getRequestDispatcher("/Display");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("canAdd", 1);
        RequestDispatcher dispatcher =request.getRequestDispatcher("/Display");
        dispatcher.forward(request, response);

    }
}

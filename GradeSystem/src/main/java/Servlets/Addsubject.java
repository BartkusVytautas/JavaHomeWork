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

@WebServlet(name = "Addsubject", urlPatterns = {"/Addsubject"})
public class Addsubject extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Subject.addSubject(name, description);
        request.setAttribute("canAddSubj", null);
        RequestDispatcher dispatcher =request.getRequestDispatcher("/Display");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("canAddSubj", 1);
        RequestDispatcher dispatcher =request.getRequestDispatcher("/Display");
        dispatcher.forward(request, response);
    }
}

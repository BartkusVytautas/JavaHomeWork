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

@WebServlet(name = "Modifysubject", urlPatterns = {"/Modifysubject"})
public class Modifysubject extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("subjectn");
        String description = request.getParameter("description");
        Integer id = Integer.parseInt(request.getParameter("subid"));
        Subject s = Subject.getSubject(id);
        s.setDescription(description);
        s.setName(name);
        s.update();
        request.setAttribute("subm", null);
        response.sendRedirect("Display");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("subjectid"));
        request.setAttribute("subm", Subject.getSubject(id).getId());
        RequestDispatcher dispatcher =request.getRequestDispatcher("/Display");
        dispatcher.forward(request, response);
    }
}

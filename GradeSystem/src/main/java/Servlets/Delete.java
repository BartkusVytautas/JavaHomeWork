package Servlets;

import lt.bit.EGrade.Student;
import lt.bit.EGrade.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id;
        if(request.getParameter("delete")!= null) {
            id = Integer.parseInt(request.getParameter("delete"));
            Student.delete(id);
        }
        if(request.getParameter("deletesub")!= null) {
            id = Integer.parseInt(request.getParameter("deletesub"));
            Subject.delete(id);
        }

        response.sendRedirect("Display");


    }
}

package lt.bit.Servlets;

import lt.bit.Employees.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(name = "DisplayEmployees", urlPatterns = {"/Display"})
public class DisplayEmployees extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<Employee> employees= Employee.getEmployeesFromDB();
        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher =request.getRequestDispatcher("/table.jsp");
        dispatcher.forward(request, response);

    }
}

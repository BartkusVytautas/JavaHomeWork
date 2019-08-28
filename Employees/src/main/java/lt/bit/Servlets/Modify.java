package lt.bit.Servlets;

import lt.bit.Employees.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.module.FindException;

@WebServlet(name = "Modify", urlPatterns = {"/Modify"})

public class Modify extends HttpServlet {
    private static Integer getId;
    private static Employee emp;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone =request.getParameter("phone");
        String gender = request.getParameter("gender");
        String education =  request.getParameter("education");
        String birthday = request.getParameter("birthday");
        int salary = Integer.parseInt(request.getParameter("salary"));
        Employee.updateDB(getId, name, surname, gender, phone, education, birthday, salary);
        response.sendRedirect("Display");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("modify") != null) {
            getId = Integer.parseInt(request.getParameter("modify"));
            for (Employee e : Employee.getEmployeesFromDB()) {
                if (getId == e.getId()) {
                    emp = e;
                    break;
                }
            }

            request.setAttribute("emp", emp);
        }
        RequestDispatcher dispatcher =request.getRequestDispatcher("/modify.jsp");
        dispatcher.forward(request, response);
    }
}

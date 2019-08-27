package lt.bit.Servlets;

import lt.bit.Employees.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Add", urlPatterns = {"/Add"})
public class Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String name = request.getParameter("name");
       String surname = request.getParameter("surname");
       String gender = request.getParameter("gender");
       String phone = request.getParameter("phone");
       String birthday = request.getParameter("birthday");
       String education = request.getParameter("education");
       Integer salary = Integer.parseInt(request.getParameter("salary"));
       Employee.addEmployeeToDB(name, surname, gender, phone, birthday, education, salary);
       response.sendRedirect("Display");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher =request.getRequestDispatcher("/addForm.jsp");
        dispatcher.forward(request, response);
    }
}

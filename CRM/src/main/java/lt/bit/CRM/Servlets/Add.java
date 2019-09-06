package lt.bit.CRM.Servlets;

import lt.bit.CRM.Connections.SingletonSession;
import lt.bit.CRM.Entities.Company;
import org.hibernate.Session;

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
        Session session = SingletonSession.getSession();
        session.beginTransaction();
        if(request.getParameter("company") != null){
            String comp_name = request.getParameter("compname");
            String address = request.getParameter("address");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String vat = request.getParameter("vat");
            String email = request.getParameter("vat");
            Company c = new Company(name, address, vat, comp_name, phone, email);
            session.save(c);
        }
        session.getTransaction().commit();
        session.close();
        request.setAttribute("table1", null);
        request.setAttribute("table2", null);
        request.setAttribute("table3", null);
        response.sendRedirect("Display");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String add = request.getParameter("add");
       switch (Integer.parseInt(add)){
           case 1:
               request.setAttribute("table1", 1);
               break;
           case 2 :
               request.setAttribute("table2", 1);
               break;
           case 3:
               request.setAttribute("table3", 1);
               break;
           default:
       }
        RequestDispatcher dispatcher =request.getRequestDispatcher("/Display");
        dispatcher.forward(request, response);
    }
}

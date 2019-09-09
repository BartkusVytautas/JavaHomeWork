package lt.bit.CRM.Servlets;

import lt.bit.CRM.Connections.SingletonSession;
import lt.bit.CRM.Entities.Company;
import lt.bit.CRM.Entities.Contact;
import lt.bit.CRM.Entities.Costumer;
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
        if(request.getParameter("costumer") != null){
            String cost_name = request.getParameter("costname");
            String cost_surname = request.getParameter("surname");
            String cost_address = request.getParameter("costaddress");
            String cost_email = request.getParameter("costemail");
            String cost_phone = request.getParameter("costphone");
            String cost_position = request.getParameter("position");
            Integer company_id = Integer.parseInt(request.getParameter("companyid"));
            Company comp = session.get(Company.class, company_id);
            Costumer costumer = new Costumer();
            costumer.setName(cost_name);
            costumer.setSurname(cost_surname);
            costumer.setAddress(cost_address);
            costumer.setEmail(cost_email);
            costumer.setPhone(cost_phone);
            costumer.setPosition(cost_position);
            costumer.setCompany(comp);
            session.save(costumer);
        }
        if(request.getParameter("contact") != null){
            String conversation = request.getParameter("conversation");
            Integer costumer_id = Integer.parseInt(request.getParameter("costumerid"));
            Costumer costumer = session.get(Costumer.class, costumer_id);
            Contact contact = new Contact();
            contact.setConversation(conversation);
            contact.setCostumer(costumer);
            session.save(contact);
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

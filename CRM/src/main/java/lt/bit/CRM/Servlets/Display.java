package lt.bit.CRM.Servlets;

import lt.bit.CRM.Connections.SingletonSession;
import lt.bit.CRM.Entities.Company;
import lt.bit.CRM.Entities.Contact;
import lt.bit.CRM.Entities.Costumer;
import lt.bit.CRM.Entities.Item;
import org.hibernate.Session;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "Display", urlPatterns = {"/Display"})
public class Display extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Session session = SingletonSession.getSession();
        session.beginTransaction();
        List<Company> companies = session.createQuery("from Company").list();
        List<Costumer> costumers = session.createQuery("from Costumer ").list();
        List<Contact> contacts = session.createQuery("from Contact").list();
        List<Item> items = session.createQuery("from Item").list();
        request.setAttribute("companies", companies);
        request.setAttribute("costumers", costumers);
        request.setAttribute("contacts", contacts);
        request.setAttribute("items", items);

        session.getTransaction().commit();
        session.close();
        RequestDispatcher dispatcher =request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}

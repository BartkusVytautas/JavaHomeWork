package lt.bit.CRM.Servlets;

import lt.bit.CRM.Connections.SingletonSession;
import lt.bit.CRM.Entities.Company;
import lt.bit.CRM.Entities.Contact;
import lt.bit.CRM.Entities.Costumer;
import lt.bit.CRM.Entities.Item;
import org.hibernate.Session;

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
        Session session = SingletonSession.getSession();
        session.beginTransaction();

        if(request.getParameter("delete")!=null) {
            Integer id = Integer.parseInt(request.getParameter("delete"));


            if (request.getParameter("company") != null) {
                Company c = session.get(Company.class, id);
                session.delete(c);
            }
            if (request.getParameter("contact") != null) {
                Contact c = session.get(Contact.class, id);
                session.delete(c);
            }
            if (request.getParameter("costumer") != null) {
                Costumer c = session.get(Costumer.class, id);
                session.delete(c);
            }
            if (request.getParameter("item") != null) {
                Item i = session.get(Item.class, id);
                session.delete(i);
            }
        }

        if (request.getParameter("deleteitem")!=null){
            Item i = session.get(Item.class, Integer.parseInt(request.getParameter("deleteitem")));
            Costumer c = session.get(Costumer.class, Integer.parseInt(request.getParameter("costumerid")));
            c.getItems().remove(i);
            session.save(c);
        }

        session.getTransaction().commit();
        session.close();
        response.sendRedirect("Display");
    }
}

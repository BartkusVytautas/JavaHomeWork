package lt.bit.CRM.Servlets;

import lt.bit.CRM.Connections.SingletonSession;
import lt.bit.CRM.Entities.Contact;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session= SingletonSession.getSession();
        session.beginTransaction();
        Contact c = new Contact();
        c.setConversation("Labas");
        c.setCostumer_id(2);
        session.save(c);
        session.getTransaction().commit();
        session.close();
    }
}

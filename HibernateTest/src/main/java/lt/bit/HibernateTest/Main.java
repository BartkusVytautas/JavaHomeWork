package lt.bit.HibernateTest;

import lt.bit.HibernateTest.Connections.SingletonSession;
import lt.bit.HibernateTest.Entities.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        Session session= SingletonSession.getSession();
        Status status = session.get(Status.class,1);
        System.out.println(status.getName());

        session.close();
    }
}

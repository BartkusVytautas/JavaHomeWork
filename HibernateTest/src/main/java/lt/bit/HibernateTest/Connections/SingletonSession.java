package lt.bit.HibernateTest.Connections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SingletonSession {

    private static StandardServiceRegistry serviceRegistry = null;
    private static Metadata metadata = null;
    private static SessionFactory sessionFactory = null;

    public static Session getSession (){
        if (sessionFactory == null){
             serviceRegistry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
             metadata= new MetadataSources(serviceRegistry).getMetadataBuilder().build();
             sessionFactory= metadata.getSessionFactoryBuilder().build();
        }
        return sessionFactory.openSession();
    }
}

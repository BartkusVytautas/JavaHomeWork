package lt.bit.CRM.Connections;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SingletonSession {

    private static SessionFactory sessionFactory = null;

    public static Session getSession (){
        if (sessionFactory == null){
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            sessionFactory= metadata.getSessionFactoryBuilder().build();
        }
        return sessionFactory.openSession();
    }
}

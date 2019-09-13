package bit.lt.DAO;


import bit.lt.Entities.KMI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class KMIDAOImpl implements KMIDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<KMI> getKMIlist() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from KMI").list();
    }

    @Override
    public KMI getKMI(Integer id) {
        return sessionFactory.getCurrentSession().get(KMI.class, id);
    }


    @Override
    public void saveKMI(KMI kmi) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(kmi);
    }

    @Override
    public void deleteKMI(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(this.getKMI(id));

    }
}

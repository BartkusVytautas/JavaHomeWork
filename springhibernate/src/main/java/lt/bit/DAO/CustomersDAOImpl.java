package lt.bit.DAO;

import lt.bit.Entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

@Repository

public class CustomersDAOImpl implements CustomersDAO{

    private EntityManager entityManager;


    @Override
    public List<Customer> getTasks() {
        List<Customer> c =new LinkedList<>();
        Query query = entityManager.createQuery("SELECT co FROM Costumer AS co");
        c = query.getResultList();
        return c;

    }
}

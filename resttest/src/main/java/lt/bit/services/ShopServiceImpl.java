package lt.bit.services;


import lt.bit.entities.Order;
import lt.bit.entities.Product;
import lt.bit.entities.User;
import lt.bit.repositories.OrderRepository;
import lt.bit.repositories.ProductRepository;
import lt.bit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class ShopServiceImpl implements ShopService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }


    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Iterable<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Iterable<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.save(order);
    }


    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Iterable<Order> orderList() {
        return orderRepository.findAll();
    }

    @Override
    public Order newOrder(Integer userId, Integer productId, boolean isCompleted , Integer quantity) {
        User user = userRepository.findById(userId).get();
        Product product = productRepository.findById(productId).get();
        Order order = new Order(quantity, isCompleted, user, product);
        order.setDate(new Date());
        orderRepository.save(order);
        return order;
    }

}

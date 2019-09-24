package lt.bit.services;

import lt.bit.entities.Order;
import lt.bit.entities.Product;
import lt.bit.entities.User;

public interface ShopService {
    void updateUser(User user);
    void deleteUser(Integer id);
    User getUserById(Integer id);
    Iterable<User> getUserList();

    void updateProduct(Product product);
    void deleteProduct(Integer id);
    Product getProductById(Integer id);
    Iterable<Product> getProductList();

    void updateOrder(Order order);
    void deleteOrder(Integer id);
    Order getOrderById(Integer id);
    Iterable<Order> orderList();
    Order newOrder(Integer userId, Integer productId, boolean isCompleted, Integer quantity);

}

package lt.bit.controllers;


import lt.bit.entities.Order;
import lt.bit.entities.Product;
import lt.bit.entities.User;
import lt.bit.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/API")
public class APIController {

    @Autowired
    private ShopService shopService;

    @PostMapping(value = "/add_user")
    public User addUser (@RequestParam("name") String name, @RequestParam("email") String email){
        User user = new User(name, email);
        shopService.updateUser(user);
        return user;
    }

    @GetMapping(value = "/user_info/{id}")
    public User userInfo (@PathVariable("id") Integer id){
        return shopService.getUserById(id);
    }

    @GetMapping(value = "/users_list")
    public Iterable<User> userList(){
      return shopService.getUserList();
    }

    @PutMapping(value = "/update_user/{id}")
    public User updateUser(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("email") String email ){
        User user = shopService.getUserById(id);
        user.setEmail(email);
        user.setName(name);
        shopService.updateUser(user);
        return user;
    }

    @DeleteMapping(value = "/delete_user/{id}")
    public Map<String, String> deleteUser(@PathVariable("id") Integer id){
        Map<String, String> response = new HashMap<>();
        try{
            shopService.deleteUser(id);
            response.put("Success", "Done");
        }catch (Exception e){
            response.put("Success", "Failed");
        }

        return response;
    }

    @PostMapping(value = "/add_product")
    public Product addProduct (@RequestParam("name") String name, @RequestParam("price") Double price, @RequestParam("quantity") Integer quantity){
        Product product = new Product(name, price, quantity);
        shopService.updateProduct(product);
        return product;
    }

    @GetMapping(value = "/products_list")
    public Iterable<Product> ProductList(){
        return shopService.getProductList();
    }

    @GetMapping(value = "/product_info/{id}")
    public Product productInfo (@PathVariable("id") Integer id){
        return shopService.getProductById(id);
    }

    @PutMapping(value = "/update_product/{id}")
    public Product updateProduct(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("price") Double price, @RequestParam("quantity") Integer quantity ){
        Product product = shopService.getProductById(id);
        product.setPrice(price);
        product.setName(name);
        product.setQuantity(quantity);
        shopService.updateProduct(product);
        return product;
    }

    @DeleteMapping(value = "/delete_product/{id}")
    public Map<String, String> deleteProduct(@PathVariable("id") Integer id){
        Map<String, String> response = new HashMap<>();
        try{
            shopService.deleteProduct(id);
            response.put("Success", "Done");
        }catch (Exception e){
            response.put("Success", "Failed");
        }

        return response;
    }

    @PostMapping(value = "/new_order/{usId}/{prId}")
    public Order newOrder(@PathVariable("usId") Integer userId, @PathVariable("prId") Integer productId,
                          @RequestParam("quantity") Integer quantity,
                          @RequestParam("isCompleted") boolean isCompleted){

       return shopService.newOrder(userId, productId, isCompleted, quantity);
    }

    @GetMapping(value = "/orders_list")
    public Iterable<Order> ordersList(){
        return shopService.orderList();
    }

    @GetMapping(value = "/order_info/{id}")
    public Order orderInfo (@PathVariable("id") Integer id){
        return shopService.getOrderById(id);
    }

    @DeleteMapping(value = "/delete_order/{id}")
    public Map<String, String> deleteOrder(@PathVariable("id") Integer id){
        Map<String, String> response = new HashMap<>();
        try{
            shopService.deleteOrder(id);
            response.put("Success", "Done");
        }catch (Exception e){
            response.put("Success", "Failed");
        }

        return response;
    }

    @PutMapping(value = "/update_order/{id}")
    public Order updateOrder(@PathVariable("id") Integer id, @RequestParam("isCompleted") boolean isCompleted, @RequestParam("quantity") Integer quantity ){
        Order order = shopService.getOrderById(id);
        order.setQuantity(quantity);
        order.setCompleted(isCompleted);
        shopService.updateOrder(order);
        return order;
    }
}

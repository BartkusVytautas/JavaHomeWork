package lt.bit.Controllers;


import lt.bit.DAO.CustomersDAO;
import lt.bit.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private CustomersDAO customersDAO;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(){
        for(Customer c: customersDAO.getTasks()){
            System.out.println(c);
        }
        return "home.jsp";
    }
}

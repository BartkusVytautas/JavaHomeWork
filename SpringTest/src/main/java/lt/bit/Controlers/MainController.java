package lt.bit.Controlers;

import lt.bit.Models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/home"})
    public String home(){
        return "home.jsp";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form (){
        return "form.jsp";
    }

    @RequestMapping (value = "/form", method = RequestMethod.POST)
    public String processForm(@RequestParam(name = "input") Integer value, Model model){
        value *= 2;
        model.addAttribute("value", value);
        return "answer.jsp";
    }

    @RequestMapping(value = "/darb", method = RequestMethod.GET)
    public String darbuotojoForma (Model model){

        Employee emp = new Employee();
        model.addAttribute("emp", emp);

        return "darbform.jsp";
    }
    
}

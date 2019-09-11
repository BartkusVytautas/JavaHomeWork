package lt.bit.kmi.Controllers;


import lt.bit.kmi.Models.KMI;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayForm(Model model){
        KMI kmi = new KMI();
        model.addAttribute("kmi", kmi);
        return "form.jsp";
    }
    @RequestMapping(value = "/display", method = RequestMethod.POST)
    public String displayKMI(@ModelAttribute("kmi") KMI kmi){
        return "kmidisplay.jsp";
    }


}

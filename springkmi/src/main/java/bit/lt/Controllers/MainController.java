package bit.lt.Controllers;


import bit.lt.DAO.KMIDAOImpl;
import bit.lt.Entities.KMI;
import bit.lt.Services.ServiceKMI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    private ServiceKMI serviceKMI;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayForm(Model model){
        KMI kmi = new KMI();
        model.addAttribute("kmi", kmi);
        return "form.jsp";
    }
    @RequestMapping(value = "/display", method = RequestMethod.POST)
    public String displayKMI(@ModelAttribute("kmi") KMI kmi){
        serviceKMI.saveKMI(kmi);
        return "kmidisplay.jsp";
    }

    @GetMapping (value = "/kmitable")
    public String KMItable(Model model, HttpServletRequest request){
        if(request.getParameter("mod1") != null) {
            Integer id = Integer.parseInt(request.getParameter("mod1"));
            request.setAttribute("mod1", id);
            model.addAttribute("kmimod", new KMI());
        }
        model.addAttribute("list", serviceKMI.getKMIlist());
        return "kmitable.jsp";
    }
    @GetMapping(value = "/delete")
    public String delete(@RequestParam("id") Integer id){
        serviceKMI.deleteKMI(id);
        return "kmitable";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify (@ModelAttribute("kmimod") KMI kmi){
        serviceKMI.saveKMI(kmi);

        return "redirect: kmitable";
    }
}

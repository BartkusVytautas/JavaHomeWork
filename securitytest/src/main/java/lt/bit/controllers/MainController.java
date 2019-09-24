package lt.bit.controllers;


import lt.bit.entities.Role;
import lt.bit.entities.User;
import lt.bit.repositories.RoleRepository;
import lt.bit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(value = "/")
    public String homePage(){
        return "main.jsp";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "login.jsp";
    }

    @GetMapping(value = "/register")
    public String registerForm(Model model, HttpServletRequest request){
        if(request.getParameter("failedReg") !=null){
            request.setAttribute("failedReg", 1);
        }
        User user = new User();
        model.addAttribute("user", user);
        return "register.jsp";
    }

    @PostMapping(value = "register_user")
    public String registerNewUser(@ModelAttribute("user") User user, @RequestParam("password1") String password1, @RequestParam("password2") String password2, HttpServletRequest request){
        if(!password1.equals(password2)){
            return "redirect: register?failedReg=1";
        }
        user.getRoles().add(roleRepository.findByName("user"));
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password1));
        userRepository.save(user);
        return "redirect: login";
    }

}

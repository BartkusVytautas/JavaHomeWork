package lt.bit.Servlets;

import lt.bit.photoGallery.Image;
import lt.bit.photoGallery.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletRegister", urlPatterns = {"/Register"})
public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password1");
        boolean userExists = false;
        for (Users u: Users.getUsers()){
            if (user.equals(u.getUser())){
                userExists = true;
                break;
            }
        }
        if(!userExists){
            Users.addAccount(user, password);
            response.sendRedirect("Login");
        }else {
            response.sendRedirect("Register");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/registration.jsp");
        dispatcher.forward(request, response);
    }
}

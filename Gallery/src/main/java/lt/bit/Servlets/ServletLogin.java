package lt.bit.Servlets;

import lt.bit.photoGallery.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletLogin", urlPatterns = {"/Login"})
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        boolean userExists = false;
        for (Users u: Users.getUsers()){
            if (user.equals(u.getUser()) && password.equals(u.getPassword())){
                userExists = true;
                break;
            }
        }
        if(userExists){
            request.getSession().setAttribute("login", 1);
            response.sendRedirect("Add");
        }else{
            request.getSession().setAttribute("login", 0);
            response.sendRedirect("Login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }
}

package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        if (user.equals("teacher") && password.equals("teacher")) {
            request.getSession().setAttribute("login", 1);
            if(request.getParameter("remember") !=null) {
                Cookie cookie = null;
                for (Cookie c : request.getCookies()) {
                    if (c.getName().equals("logged")) {
                        cookie = c;
                        cookie.setValue("logged");
                    }
                }
                if (cookie == null) {
                    cookie = new Cookie("logged", "logged");
                    cookie.setMaxAge(8640000);
                    response.addCookie(cookie);
                }
            }
            response.sendRedirect("Display");
        } else {
            response.sendRedirect("Login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for(Cookie c: request.getCookies()){
            if(c.getName().equals("logged") && c.getValue().equals("logged")){
                response.sendRedirect("Display");
                return;
            }
        }
        if (request.getSession().getAttribute("login") != null) {
            if ((Integer) request.getSession().getAttribute("login") == 1) {
                response.sendRedirect("Display");
                return;
            }

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}

package lt.bit.Servlets;

import lt.bit.photoGallery.Image;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = {"/Add", "/Display"})
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("url");
        String description = request.getParameter("description");
        if (request.getSession().getAttribute("login") == null) {
            if ((int) request.getSession().getAttribute("login") == 0) {
                response.sendRedirect("Login");
                return;
            }
        }
        Image.addImage(url, description );
        response.sendRedirect("gallery.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("images", Image.getImages());
        RequestDispatcher dispatcher =request.getRequestDispatcher("/displayGallery.jsp");
        dispatcher.forward(request, response);
    }
}


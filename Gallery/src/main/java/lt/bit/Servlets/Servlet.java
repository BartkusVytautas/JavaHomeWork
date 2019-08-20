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
        Image.addImage(url, description );
        RequestDispatcher dispatcher =request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("images", Image.getImages());
        RequestDispatcher dispatcher =request.getRequestDispatcher("/displayGallery.jsp");
        dispatcher.forward(request, response);
    }
}


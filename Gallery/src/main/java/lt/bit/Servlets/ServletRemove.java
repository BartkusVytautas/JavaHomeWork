package lt.bit.Servlets;

import lt.bit.photoGallery.Image;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletRemove", urlPatterns = {"/Remove"})
public class ServletRemove extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("login") == null || (int)request.getSession().getAttribute("login") == 0){
            response.sendRedirect("Login");
            return;
        }
        int index = Integer.parseInt(request.getParameter("delete"));
        Image.getImages().remove(index);
        RequestDispatcher dispatcher =request.getRequestDispatcher("/Add");
        dispatcher.forward(request, response);
    }
}

package lt.bit.CRM.Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Modify", urlPatterns = {"/Modify"})
public class Modify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("modify");
        Integer table = Integer.parseInt(request.getParameter("table"));
        switch (table){
            case 1:
                request.setAttribute("mod1", id);
                break;
            case 2 :
                request.setAttribute("mod2", id);
                break;
            case 3:
                request.setAttribute("mod3", id);
                break;
            case 4:
                request.setAttribute("mod4", id);
                break;
            default:
        }



        RequestDispatcher dispatcher =request.getRequestDispatcher("/Display");
        dispatcher.forward(request, response);
    }

}



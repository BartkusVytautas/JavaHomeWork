package lt.bit.CRM.Servlets;

import lt.bit.CRM.Connections.SingletonSession;
import lt.bit.CRM.Entities.Company;
import lt.bit.CRM.Entities.Contact;
import lt.bit.CRM.Entities.Costumer;
import lt.bit.CRM.Entities.Item;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Add", urlPatterns = {"/Add"})
public class Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = SingletonSession.getSession();
        session.beginTransaction();
        if(request.getParameter("item") != null){
            String item_name = request.getParameter("itemname");
            Double item_price = Double.parseDouble(request.getParameter("itemprice"));
            Item i = new Item(item_name, item_price);
            session.save(i);

        }

        if(request.getParameter("company") != null){
            String comp_name = request.getParameter("compname");
            String address = request.getParameter("address");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String vat = request.getParameter("vat");
            String email = request.getParameter("email");
            Company c = new Company(name, address, vat, comp_name, phone, email);
            session.save(c);
        }
        if(request.getParameter("costumer") != null){
            String cost_name = request.getParameter("costname");
            String cost_surname = request.getParameter("surname");
            String cost_address = request.getParameter("costaddress");
            String cost_email = request.getParameter("costemail");
            String cost_phone = request.getParameter("costphone");
            String cost_position = request.getParameter("position");
            Integer company_id = Integer.parseInt(request.getParameter("companyid"));
            Company comp = session.get(Company.class, company_id);
            Costumer costumer = new Costumer();
            costumer.setName(cost_name);
            costumer.setSurname(cost_surname);
            costumer.setAddress(cost_address);
            costumer.setEmail(cost_email);
            costumer.setPhone(cost_phone);
            costumer.setPosition(cost_position);
            costumer.setCompany(comp);
            session.save(costumer);
        }
        if(request.getParameter("contact") != null){
            Integer costumer_id = Integer.parseInt(request.getParameter("costumerid"));
            Contact contact = new Contact();
            Costumer c = session.get(Costumer.class, costumer_id);
            contact.setCostumer(c);
            String[] items=request.getParameterValues("itemadd");
            for(String s: items){
                c.getItems().add(session.get(Item.class, Integer.parseInt(s)));

            }
            session.save(contact);
        }
        if(request.getParameter("companymod") != null){
            Integer compId = Integer.parseInt(request.getParameter("companymod"));
            String comp_name = request.getParameter("compname2");
            String address = request.getParameter("address2");
            String name = request.getParameter("name2");
            String phone = request.getParameter("phone2");
            String vat = request.getParameter("vat2");
            String email = request.getParameter("email2");
            Company c = session.get(Company.class, compId);
            c.setAdress(address);
            c.setCompany_name(comp_name);
            c.setEmail(email);
            c.setName(name);
            c.setVat_code(vat);
            c.setPhone(phone);
            session.save(c);
            request.setAttribute("mod1", null);

        }

        if(request.getParameter("costumermod") != null){
            String cost_name = request.getParameter("costname2");
            String cost_surname = request.getParameter("costsurname2");
            String cost_address = request.getParameter("costaddress2");
            String cost_email = request.getParameter("costemail2");
            String cost_phone = request.getParameter("costphone2");
            String cost_position = request.getParameter("costposition2");
            Integer cost_id = Integer.parseInt(request.getParameter("costumermod"));
            Integer comp_id = Integer.parseInt(request.getParameter("companyid2"));
            Costumer c = session.get(Costumer.class, cost_id);
            c.setName(cost_name);
            c.setSurname(cost_surname);
            c.setPosition(cost_position);
            c.setPhone(cost_phone);
            c.setEmail(cost_email);
            c.setAddress(cost_address);
            c.setCompany(session.get(Company.class, comp_id));
            session.save(c);
            request.setAttribute("mod2", null);
        }

        if(request.getParameter("contactmod") != null){
            Integer cont_id = Integer.parseInt(request.getParameter("contactmod"));
            Integer cost_id = Integer.parseInt(request.getParameter("costumerid"));
            Contact c = session.get(Contact.class, cont_id);
            Costumer cost = session.get(Costumer.class, cost_id);
            c.setCostumer(cost);
            String[] items=request.getParameterValues("itemadd2");
            cost.getItems().clear();
            for(String s: items){
                cost.getItems().add(session.get(Item.class, Integer.parseInt(s)));

            }
            session.save(c);

            request.setAttribute("mod2", null);

        }

        if(request.getParameter("itemmod") != null){
            Integer item_id = Integer.parseInt(request.getParameter("itemmod"));
            String name = request.getParameter("itemname2");
            Double price = Double.parseDouble(request.getParameter("itemprice2"));
            Item i = session.get(Item.class, item_id);
            i.setName(name);
            i.setPrice(price);
            session.save(i);
        }




        session.getTransaction().commit();
        session.close();
        request.setAttribute("table1", null);
        request.setAttribute("table2", null);
        request.setAttribute("table3", null);
        request.setAttribute("table4", null);
        response.sendRedirect("Display");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String add = request.getParameter("add");
       switch (Integer.parseInt(add)){
           case 1:
               request.setAttribute("table1", 1);
               break;
           case 2 :
               request.setAttribute("table2", 1);
               break;
           case 3:
               request.setAttribute("table3", 1);
               break;
           case 4:
               request.setAttribute("table4", 1);
           default:
       }
        RequestDispatcher dispatcher =request.getRequestDispatcher("/Display");
        dispatcher.forward(request, response);
    }
}

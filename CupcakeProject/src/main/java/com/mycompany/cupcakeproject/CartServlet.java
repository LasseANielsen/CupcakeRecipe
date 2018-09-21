package com.mycompany.cupcakeproject;

import com.mycompany.cupcakeproject.DTO.BottomDTO;
import com.mycompany.cupcakeproject.DTO.ToppingsDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Cart", urlPatterns = {"/Cart"})
public class CartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Controller c = new Controller();
        String topName = request.getParameter("Toppings").split(" ")[0];
        String botName = request.getParameter("Bottom").split(" ")[0];
        int quantity = Integer.parseInt(request.getParameter("Quantity"));
        ToppingsDTO topDTO = c.getToppingByName(topName);
        BottomDTO botDTO = c.getBottomByName(botName);
        int totalPrice = (topDTO.getPrice() + botDTO.getPrice()) * quantity;

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Topping</th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.println("<th>Bottom</th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.println("<th>Quantity</th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.println("<th>Total price</th>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.print("<td></td>");
            out.print("<td></td>");
            out.print("<td></td>");
            out.print("<td></td>");
            out.print("<td></td>");
            out.print("<td></td>");
            out.print("<td></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>" + topName + "</td>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.println("<td>" + botName + "</td>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.println("<td>" + quantity + "</td>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.print("<th></th>");
            out.println("<td>" + totalPrice + "</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<input type=\"submit\" value=\"Bake my order\">");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

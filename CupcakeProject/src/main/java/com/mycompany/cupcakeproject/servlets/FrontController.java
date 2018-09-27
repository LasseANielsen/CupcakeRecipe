package com.mycompany.cupcakeproject.servlets;

import com.mycompany.cupcakeproject.Controller;
import com.mycompany.cupcakeproject.DTO.BottomDTO;
import com.mycompany.cupcakeproject.DTO.ToppingsDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    Controller c = new Controller();

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

        String origin = request.getParameter("origin");
        if (origin != null) {
            switch (origin) {
                case "cart":
                    // Get values
                    String topName = request.getParameter("Toppings").split(" ")[0];
                    String botName = request.getParameter("Bottom").split(" ")[0];
                    int quantity = Integer.parseInt(request.getParameter("Quantity"));
                    ToppingsDTO topDTO = c.getToppingByName(topName);
                    BottomDTO botDTO = c.getBottomByName(botName);
                    int totalPrice = (topDTO.getPrice() + botDTO.getPrice()) * quantity;
                    // forward values
                    request.setAttribute("topname", topName);
                    request.setAttribute("botname", botName);
                    request.setAttribute("quantity", quantity);
                    request.setAttribute("totalprice", totalPrice);
                    request.getRequestDispatcher("cart.jsp").forward(request, response);
                    break;
                case "login":
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    break;
                case "register":
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                    break;
                case "shop":
                    request.getRequestDispatcher("shop.jsp").forward(request, response);
                    break;
                case "user":
                    request.getRequestDispatcher("user.jsp").forward(request, response);
                    break;
                default:
                    response.sendRedirect("index.html");
            }
        } else {
            response.sendRedirect("index.html");
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

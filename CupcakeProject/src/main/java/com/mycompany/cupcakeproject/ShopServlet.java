/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cupcakeproject;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lasse
 */
@WebServlet(name = "Shop", urlPatterns = {"/Shop"})
public class ShopServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("h1 {color:deeppink;}");
            out.println("p {color:tomato;}");
            out.println("body {color:tomato; background:peachpuff}");
            out.println("</style>");
            out.println("<title>Servlet ShopServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome to the bakery! Where we bake hash!</h1>");
            out.println("<form action=\"/CupcakeProject/Cart\">");
            out.println("<p> Choose your topping</p>");
            out.println("<select name=\"Toppings\">");
            out.println("<option> Chocolate 5,-</option>");
            out.println("<option> Blueberry 5,-</option>");
            out.println("<option> Rasberry 5,-</option>");
            out.println("<option> Crispy 6,-</option>");
            out.println("<option> Strawberry 6,-</option>");
            out.println("<option> Rum/Raisin 7,-</option>");
            out.println("<option> Orange 8,-</option>");
            out.println("<option> Lemon 8,-</option>");
            out.println("<option> Blue Cheese 9,-</option>");
            out.println("</select>");
            out.println("<p> Choose your bottom</p>");
            out.println("<select name=\"Bottom\">");
            out.println("<option> Chocolate 5,-</option>");
            out.println("<option> Vanilla 5,-</option>");
            out.println("<option> Nutmeg 5,-</option>");
            out.println("<option> Pistacio 6,-</option>");
            out.println("<option> Almond 7,-</option>");
            out.println("</select>");
            out.println("<br>");
            out.println("</select>");
            out.println("<p>How many would you like?</p><input type=\"text\" name=\"Quantity\">");
            out.println("<br><br>");
            out.println("<input type=\"submit\" value=\"Add to cart\">");
            out.println("</form>");
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

package com.mycompany.cupcakeproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Back to the mixer!</h1>");
            if ("false".equals(request.getParameter("validation"))) {
                out.println("Oh no, that cake does not exist!");
            }
            out.println("<form action=\"/CupcakeProject/LoginValidator\">");
            out.println("<p>Username</p><input type=\"text\" name=\"username\">");
            out.println("<p>Password</p><input type=\"text\" name=\"password\">");
            out.println("<br><br><input type=\"submit\" value=\"Go to the mixer!\">");
            out.println("</form>");
            if ("false".equals(request.getParameter("validation"))) {
                out.println("<form action=\"/CupcakeProject/Registration\">");
                out.println("<br><br><input type=\"submit\" value=\"New recipe?\">");
                out.println("</form>");
            }
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

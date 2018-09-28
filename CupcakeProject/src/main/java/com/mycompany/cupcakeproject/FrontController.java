package com.mycompany.cupcakeproject;

import com.mycompany.cupcakeproject.DTO.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    Controller c = new Controller();
    LoginValidator lv = new LoginValidator();
    RegisterValidator rv = new RegisterValidator();

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
                    handleCart(request, response);
                    break;
                case "login":
                    handleLogin(request, response);
                    break;
                case "loginvalidator":
                    handleLoginValidator(request, response);
                    break;
                case "register":
                    handleRegister(request, response);
                    break;
                case "registervalidator":
                    handleRegisterValidator(request, response);
                    break;
                case "shop":
                    handleShop(request, response);
                    break;
                case "profile":
                    handleUser(request, response);
                    break;
                default:
                    response.sendRedirect("index.html");
            }
        } else {
            response.sendRedirect("index.html");
        }

    }

    private boolean checkLogin(HttpServletRequest request) {
        String un = request.getSession().getAttribute("username").toString();
        UserDTO user = c.getUserByUsername(un);
        boolean isLoggedIn = false;
        if (user != null) {
            isLoggedIn = true;
        }
        return isLoggedIn;
    }

    private void handleCart(HttpServletRequest request, HttpServletResponse response) throws IOException, NumberFormatException, ServletException {
        if (checkLogin(request)) {
            String topName = request.getParameter("Toppings").split(" ")[0];
            String botName = request.getParameter("Bottom").split(" ")[0];
            int quantity = Integer.parseInt(request.getParameter("Quantity"));
            ToppingsDTO topDTO = c.getToppingByName(topName);
            BottomDTO botDTO = c.getBottomByName(botName);
            int totalPrice = (topDTO.getPrice() + botDTO.getPrice()) * quantity;
            request.setAttribute("topname", topName);
            request.setAttribute("botname", botName);
            request.setAttribute("quantity", quantity);
            request.setAttribute("totalprice", totalPrice);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String error = request.getParameter("error");
            request.getRequestDispatcher("login.jsp?error=" + error).forward(request, response);
        } catch (IOException | ServletException e) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void handleLoginValidator(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean bUser = lv.validateUsername(username, password);
        if (bUser) {
            request.getSession().setAttribute("username", username);
            request.getRequestDispatcher("shop.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp?error=true").forward(request, response);
        }
    }

    private void handleRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    private void handleRegisterValidator(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        boolean bUser = rv.validateUsername(username);
        boolean bPassword = rv.validatePassword(password);
        boolean bEmail = rv.validateEmail(email);
        if (bUser && bPassword && bEmail) {
            c.newUser(email, username, password, 0);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("register.jsp?error=true").forward(request, response);
        }
    }

    private void handleShop(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (checkLogin(request)) {
            request.getRequestDispatcher("shop.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void handleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (checkLogin(request)) {
            int id = Integer.parseInt(request.getParameter("id"));
            UserDTO user = new Controller().getUserById(id);
            if (user != null) {
                int balance = user.getBalance();
                String name = user.getName();
                String username = user.getUsername();
                String password = user.getPassword();
                String email = user.getEmail();
                CustomerOrAdmin customerOrAdmin = user.getCustomerOrAdmin();
                request.setAttribute("balance", balance);
                request.setAttribute("name", name);
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.setAttribute("email", email);
                request.setAttribute("customerOrAdmin", customerOrAdmin);
                request.getRequestDispatcher("user.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
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

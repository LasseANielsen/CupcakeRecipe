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
                case "admin":
                    handleAdmin(request, response);
                    break;
                default:
                    response.sendRedirect("index.html");
            }
        } else {
            response.sendRedirect("index.html");
        }

    }

    /**
     * The handler which checks if the logged in user are admin or not. In the
     * case the user is admin then they will be forwarded to the admin page. In
     * the case they are not admin the will be forwarded to the login page, so
     * they can log into an admin account.
     *
     * @param request servlet request.
     * @param response servlet response.
     * @throws IOException if an I/O error occurs.
     * @throws ServletException if a servlet-specific error occurs.
     */
    private void handleAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (checkAdmin(request)) {
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    /**
     * The method which get the logged in users data and checks if the users is
     * admin or not.
     *
     * @param request servlet request.
     * @return the boolean value of the users admin status.
     */
    private boolean checkAdmin(HttpServletRequest request) {
        String un = (String) request.getSession().getAttribute("username");
        UserDTO user = c.getUserByUsername(un);
        boolean isAdmin = false;
        if (user != null) {
            if (user.getCustomerOrAdmin() == CustomerOrAdmin.A) {
                isAdmin = true;
            }
        }
        return isAdmin;
    }

    /**
     * Upon reaching a new site with require you to be logged in, this method
     * will check if you are logged in.
     *
     * @param request servlet request.
     * @return the boolean value of the sessions logged in status.
     */
    private boolean checkLogin(HttpServletRequest request) {
        String un = (String) request.getSession().getAttribute("username");
        UserDTO user = c.getUserByUsername(un);
        boolean isLoggedIn = false;
        if (user != null) {
            isLoggedIn = true;
        }
        return isLoggedIn;
    }

    /**
     * The handler which controlls the cart and forwards the correct data to the
     * cart so upon ariving to the cart.jsp, the wepsite will show you the
     * correct cart.
     *
     * @param request servlet request.
     * @param response servlet response.
     * @throws IOException if an I/O error occurs.
     * @throws NumberFormatException if quantity parameter does not contain
     * numbers only.
     * @throws ServletException if a servlet-specific error occurs.
     */
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

    /**
     * The handler which make sure that when arving to the login page you will
     * see the correct version of the login page (if you already tried but fail
     * error messages will be showned).
     *
     * @param request servlet request.
     * @param response servlet response.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException if an I/O error occurs.
     */
    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String error = request.getParameter("error");
            request.getRequestDispatcher("login.jsp?error=" + error).forward(request, response);
        } catch (IOException | ServletException e) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    /**
     * The handler which handles the validation of the login page.
     *
     * @param request servlet request.
     * @param response servlet response.
     * @throws IOException if an I/O error occurs.
     * @throws ServletException if a servlet-specific error occurs.
     */
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

    /**
     * The handler which forwards you to the register page.
     *
     * @param request servlet request.
     * @param response servlet response.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException if an I/O error occurs.
     */
    private void handleRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    /**
     * The handler which handles the register validation and forwards you to the
     * correct page in both cases of the registration being approved and
     * disapproved.
     *
     * @param request servlet request.
     * @param response servlet response.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException if an I/O error occurs.
     */
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

    /**
     * The handler which forwards you to the shop but in the case you are not
     * logged in you are instead being forwarded to the login page.
     *
     * @param request servlet request.
     * @param response servlet response.
     * @throws IOException if an I/O error occurs.
     * @throws ServletException if a servlet-specific error occurs.
     */
    private void handleShop(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (checkLogin(request)) {
            request.getRequestDispatcher("shop.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    /**
     * The handler which handles the user page and makes sure that the user data
     * will be forwarded with the user.
     *
     * @param request servlet request.
     * @param response servlet response.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException if an I/O error occurs.
     */
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

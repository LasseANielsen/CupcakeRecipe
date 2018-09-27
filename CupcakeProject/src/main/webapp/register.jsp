<%-- 
    Document   : registration
    Created on : Sep 26, 2018, 2:18:38 PM
    Author     : lasse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <!DOCTYPE html>
            <html>
            <head>
            <style>
            h1 {color:deeppink;}
            p {color:tomato;}
            body {color:tomato; background:peachpuff}
            </style>
            <title>Servlet RegistrationServlet</title>
            </head>
            <body>
            <h1>Mix your ingredients!</h1>
            if ("false".equals(request.getParameter("validation"))) {
                That cake is already in the oven!
            }
            <form action="/CupcakeProject/Tasting">
            <p>First ingredient - Username</p><input type="text" name="username">
            <p>Second ingredient - Password</p><input type="text" name="password">
            <p>Third ingredient - Email</p><input type="text" name="email">
            <br><br><input type="submit" value="Bake Account">
            </form>
            </body>
            </html>
    </body>
</html>

<%-- 
    Document   : login
    Created on : 26-09-2018, 14:14:14
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/cupcakeStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Back to the mixer!</h1>
        <% if ("false".equals(request.getParameter("validation"))) {
                out.println("oh no, that cake does not exist!");
            }%>
        <form action="/CupcakeProject/LoginValidator">
            <p>Username</p><input type="text" name="username">
            <p>Password</p><input type="text" name="password">
            <br><br><input type="submit" value="Go to the mixer!">
        </form>
        <% if ("false".equals(request.getParameter("validation"))) {
        %> <form action="/CupcakeProject/Registration">
            <br><br><input type="submit" value="New recipe?">
        </form> <%
            }%>
    </body>
</html>

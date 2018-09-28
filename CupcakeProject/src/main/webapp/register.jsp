<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/cupcakeStyle.css" rel="stylesheet" type="text/css"/>
        <link href="css/topBorderStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="topnav" id="myTopnav">
            <a href="FrontController?origin=register" class="active">Register</a>
            <a href="FrontController?origin=login">Login</a>
            <a href="FrontController?origin=shop">Shop</a>
            <a href="FrontController?origin=profile">Profile</a>
            <a href="FrontController?origin=admin">Admin</a>
        </div>
        <h1>Mix your ingredients!</h1>
        <%
            if ("true".equals(request.getParameter("error"))) {
        %>
        <p> That cake is already in the oven! </p>
        <%
            }
        %>
        <form action="FrontController?origin=registervalidator">
            <p>First ingredient - Username</p><input type="text" name="username">
            <p>Second ingredient - Password</p><input type="text" name="password">
            <p>Third ingredient - Email</p><input type="text" name="email">
            <br><br><input type="submit" value="Bake Account">
        </form>
    </body>
</html>

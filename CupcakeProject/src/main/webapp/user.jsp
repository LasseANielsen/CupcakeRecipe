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
            <a href="FrontController?origin=register">Register</a>
            <a href="FrontController?origin=login">Login</a>
            <a href="FrontController?origin=shop">Shop</a>
            <a href="FrontController?origin=profile" class="active">Profile</a>
            <a href="FrontController?origin=admin">Admin</a>
        </div>
        <h1>Her er dit dumme lorte data " + name + "!</h1>
        <p> <% request.getAttribute("username"); %> </p>
        <p> <% request.getAttribute("password"); %>" </p>
        <p> <% request.getAttribute("email"); %>" </p>
        <p> <% request.getAttribute("customerOrAdmin"); %>" </p>
        <p> <% request.getAttribute("balance");%>" </p>
    </body>
</html>

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
        <h1>Sut min højre daddel, din abe, ved navn <% request.getAttribute("name"); %>!</h1>
        <table class="blueTable">
            <tbody>
                <tr>
                    <td>Username</td><td><% request.getAttribute("username"); %></td></tr>
                <tr>
                    <td>Password</td><td><% request.getAttribute("password"); %></td></tr>
                <tr>
                    <td>E-mail</td><td><% request.getAttribute("email"); %></td></tr>
                <tr>
                    <td>Status</td><td><% request.getAttribute("customerOrAdmin"); %>
                    </td></tr>
                <tr>
                    <td>Balance</td><td><% request.getAttribute("balance");%></td></tr>
            </tbody>
        </tr>
    </table>
</body>
</html>

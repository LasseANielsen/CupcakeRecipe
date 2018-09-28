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
            <a href="FrontController?origin=profile">Profile</a>
            <a href="FrontController?origin=admin">Admin</a>
        </div>
        <h1>Give the baker your order</h1>
        <table>
            <tr>
                <th>Topping</th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th>Bottom</th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th>Quantity</th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th>Total price</th>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td> <%= request.getAttribute("topname")%> </td>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <td> <%= request.getAttribute("botname")%> </td>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <td> <%= request.getAttribute("quantity")%> </td>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <td> <%= request.getAttribute("totalprice")%> </td>
            </tr>
        </table>
        <br>
        <input type="submit" value="Bake my order">
    </body>
</html>

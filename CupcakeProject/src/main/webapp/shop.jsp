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
            <a href="FrontController?origin=shop" class="active">Shop</a>
            <a href="FrontController?origin=profile">Profile</a>
            <a href="FrontController?origin=admin">Admin</a>
        </div>
        <h1>Welcome to the bakery!</h1>
        <form action="FrontController?origin=cart">
            <p> Choose your topping</p>
            <select name="Toppings">
                <option> Chocolate 5,-</option>
                <option> Blueberry 5,-</option>
                <option> Rasberry 5,-</option>
                <option> Crispy 6,-</option>
                <option> Strawberry 6,-</option>
                <option> Rum/Raisin 7,-</option>
                <option> Orange 8,-</option>
                <option> Lemon 8,-</option>
                <option> Blue Cheese 9,-</option>
            </select>
            <p> Choose your bottom</p>
            <select name="Bottom">
                <option> Chocolate 5,-</option>
                <option> Vanilla 5,-</option>
                <option> Nutmeg 5,-</option>
                <option> Pistacio 6,-</option>
                <option> Almond 7,-</option>
            </select>
            <br>
            </select>
            <p>How many would you like?</p><input type="text" name="Quantity">
            <br><br>
            <input type="submit" value="Add to cart">
        </form>
    </body>
</html>
}
</body>
</html>

<%-- 
    Document   : shop
    Created on : Sep 26, 2018, 2:13:14 PM
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
            <title>Servlet ShopServlet</title>
            </head>
            <body>
            <h1>Welcome to the bakery! Where we bake hash!</h1>
            <form action="/CupcakeProject/Cart">
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

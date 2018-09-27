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
    </head>
    <body>
        <h1>Her er dit dumme lorte data " + name + "!</h1>
        <p> <% request.getAttribute("username"); %> </p>
        <p> <% request.getAttribute("password"); %>" </p>
        <p> <% request.getAttribute("email"); %>" </p>
        <p> <% request.getAttribute("customerOrAdmin"); %>" </p>
        <p> <% request.getAttribute("balance");%>" </p>
    </body>
</html>

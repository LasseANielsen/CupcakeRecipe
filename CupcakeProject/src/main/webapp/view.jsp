<%@page import="java.util.List, mandag.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/testStyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Person list</h1>
        <% List<Person> persons = (List) request.getAttribute("Persons"); %>
        <ul> 
            <% for (Person person : persons) {
                    out.println("<li>" + person.getName() + ": " + person.getAge() + "</li>");
                }%>
        </ul>
        <div id="idTest">
            <p> Id Test </p>
        </div>
        <div class="classTest">
            <p> Class Test </p>
        </div>
    </body>
</html>

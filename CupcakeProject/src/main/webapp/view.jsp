
<%@page import="java.util.List, Mandag.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Person list</h1>
        <% List<Person> persons = (List) request.getAttribute("Persons"); %>
        <ul> 
            <% for (Person person : persons) {
                    out.println("<li>" + person.getName() + ": " + person.getAge() + "</li>");
                }%>
        </ul>
    </body>
</html>

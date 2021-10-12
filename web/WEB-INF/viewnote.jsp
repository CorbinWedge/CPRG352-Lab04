<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <form method="GET" action="NoteServlet">
            <h3>Title:</h3>
            <p>${titleAttribute}</p>
            <br>
            <h3>Contents:</h3>
            <p>${contentAttribute}</p>
            <a href="note?edit=true">Edit</a>
        </form>
    </body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="POST" action="note">
            <h3>Title:</h3>
            <input type="text" id="titleBox" name="tbox" value="${titleAttribute}"><br><br>
            <br>
            <h3>Contents:</h3>
            <textarea id="contentBox" name="cbox" value="${contentAttribute}"></textarea>
            <br>
            <br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
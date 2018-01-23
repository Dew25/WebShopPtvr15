<%-- 
    Document   : addBook
    Created on : Jan 17, 2018, 8:56:07 AM
    Author     : Melnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Добавить книгу!</h1>
        <form method="POST" action="addBook">
            Заголовок книги: <input type="text" name="name"><br>
            Автор: <input type="text" name="author"><br>
            Год издания: <input type="text" name="year"><br>
            ISBN: <input type="text" name="isbn"><br>
            <input type="submit" value="Добавить книгу в базу">
        </form>
    </body>
</html>

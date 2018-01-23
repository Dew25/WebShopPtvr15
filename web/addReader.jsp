<%-- 
    Document   : addReader
    Created on : Jan 17, 2018, 3:15:11 PM
    Author     : Melnikov
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить пользователя</title>
    </head>
    <body>
        <h1>Добавить пользователя!</h1>
        <form method="POST" action="addReader">
            Имя: <input type="text" name="name"><br>
            Фамилия: <input type="text" name="surname"><br>
            code: <input type="text" name="code"><br>
            
            <input type="submit" value="Добавить читателя в базу">
        </form>
    </body>
</html>

<%-- 
    Document   : addMap
    Created on : Jan 17, 2018, 2:11:41 PM
    Author     : Melnikov
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="addBookToReader">
            <p>Читатель:</p>
            <select name="reader_id">
                <c:forEach var="reader" items="${readers}">
                    <option value="${reader.id}">${reader.name} ${reader.surname}</option>
                </c:forEach>
            </select>
            <p>Книга:</p>
            <select name="book_id">
                <c:forEach var="book" items="${books}">
                    <option value="${book.id}">${book.name}</option>
                </c:forEach>
            </select>
            <br>
            На сколько дней взята книга: <input type="text" name="back_time">
            <br>
            <input type="submit" value="Добавить книгу пользователю">
        </form>
    </body>
</html>

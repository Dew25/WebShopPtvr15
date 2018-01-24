<%-- 
    Document   : maps
    Created on : Jan 17, 2018, 2:02:57 PM
    Author     : Melnikov
--%>

<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/maps.css"/>
        <title>Карточки пользователей</title>
    </head>
    <body>
        <h1>Карточки пользователей</h1>
        Сегодня: <fmt:formatDate value="${today}" pattern="dd.MM.yyyy"/><br>
        Пользователи, которые взяли книги:
        <ul>
            <c:forEach var="entry" items="${mapReaderWithBooks}">
                <li>${entry.key.name} ${entry.key.surname}:<br>
                    <c:forEach var="maps" items="${entry.value}">
                        ${maps.book.name}. Срок возврата книги: 
                        <fmt:formatDate value="${maps.backTime}" pattern="dd.MM.yyyy"/>
                        <c:if test="${maps.backFlag == 0}">
                            (возврат книги сегодня)<br>
                        </c:if>
                        <c:if test="${maps.backFlag < 0}">
                            (долг!)<br>
                        </c:if>   
                    </c:forEach>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>

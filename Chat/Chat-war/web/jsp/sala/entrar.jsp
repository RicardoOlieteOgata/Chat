<%-- 
    Document   : entar
    Created on : 29/09/2014, 15:08:57
    Author     : Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <nav id="nav_bar">
            <a href="${pageContext.request.contextPath}/index.jsp">principal</a> |                                
        </nav>
        <h1>Sala</h1>
        <form method="POST" action="ChatServlet?opcao=sala.conversar">                 
            <br/>        
            <select name="sala" style="width:211px">
                <option value=""></option>
                <c:forEach var="sala" items="${salas}">
                    <option value="${sala.nome}"><c:out value="${sala.nome}"/></option>
                </c:forEach>
            </select><br>           
            <input type="submit" value="Entar">
        </form>
    </body>   
</html>

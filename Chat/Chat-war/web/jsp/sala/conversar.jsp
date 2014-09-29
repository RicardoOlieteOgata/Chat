<%-- 
    Document   : conversar
    Created on : 29/09/2014, 15:25:32
    Author     : Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <nav id="nav_bar">
            <a href="${pageContext.request.contextPath}/index.jsp">sair</a> |                               
        </nav>
        <form method="POST" action="ChatServlet?opcao=sala.conversar">
            Mensagem: <input type="text" name="mensagem" autofocus="true">   
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>

<%-- 
    Document   : inserir
    Created on : 25/09/2014, 21:24:53
    Author     : Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
    </head>
    <body>
         <nav id="nav_bar">
            <a href="${pageContext.request.contextPath}/index.jsp">principal</a> |        
        </nav>
        <form method="POST" action="${pageContext.request.contextPath}/ChatServlet?opcao=sala.inserir">
            Nome: <input type="text" name="nome">
            <input type="submit" value="Criar">
        </form>       
    </body>
</html>


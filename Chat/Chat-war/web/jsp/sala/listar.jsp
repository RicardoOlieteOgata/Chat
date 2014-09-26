<%-- 
    Document   : listar
    Created on : 25/09/2014, 19:14:22
    Author     : Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="br.mackenzie.modelo.Sala"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
    </head>    
    <body>
        <h1>Salas</h1>
        <nav id="nav_bar">
            <a href="${pageContext.request.contextPath}/index.jsp">principal</a> |
            <a href="${pageContext.request.contextPath}/ChatServlet?opcao=sala.inserir">criar sala</a> |
            <a href="${pageContext.request.contextPath}/ChatServlet?opcao=sala.excluir">excluir sala</a> |
            <a href="${pageContext.request.contextPath}/ChatServlet?opcao=sala.entrar">entrar sala</a> |                        
        </nav>
        <%               
            ArrayList<Sala> salas = new ArrayList<Sala>();
            salas.clear();
            salas = (ArrayList<Sala>) request.getAttribute("salas");
            if (salas != null)            
                 for (Sala sala : salas)
                 {                    
                     out.println(sala.getNome());
                     %><br><%
                 }            
        %>                
    </body>
</html>
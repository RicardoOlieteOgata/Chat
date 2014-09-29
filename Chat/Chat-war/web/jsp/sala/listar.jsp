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
        <nav id="nav_bar">
            <a href="${pageContext.request.contextPath}/index.jsp">principal</a> |
            <a href="${pageContext.request.contextPath}/jsp/sala/inserir.jsp">criar sala</a> |
            <a href="${pageContext.request.contextPath}/ChatServlet?opcao=sala.excluir.form">excluir sala</a> |
            <a href="${pageContext.request.contextPath}/ChatServlet?opcao=sala.entrar.form">entrar sala</a> |                        
        </nav>
        <h1>Salas</h1>
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
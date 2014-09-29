/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.servlet;

import br.mackenzie.chat.Chat;
import br.mackenzie.modelo.Sala;
import br.mackenzie.util.JNDIUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo
 */
//@EJB
@WebServlet(urlPatterns = {"/ChatServlet"})
public class ChatServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {
        
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("opcao") != null) {
            if ("sala.listar".equalsIgnoreCase(request.getParameter("opcao"))) {            
                Context context = JNDIUtil.getCORBAInitialContext();
                Chat chat = (Chat)context.lookup("ChatBean");          
                request.setAttribute("salas", chat.listarSalas());
                RequestDispatcher view = request.getRequestDispatcher("/jsp/sala/listar.jsp");
                view.forward(request, response);               
            } 
            
            if ("sala.inserir".equalsIgnoreCase(request.getParameter("opcao"))) {                
                Context context = JNDIUtil.getCORBAInitialContext();
                Chat chat = (Chat)context.lookup("ChatBean");        
                chat.criaSala(new Sala(request.getParameter("nome")));                
                RequestDispatcher view = request.getRequestDispatcher("./ChatServlet?opcao=sala.listar");                
                view.forward(request, response);
                
            }
            
             if ("sala.excluir.form".equalsIgnoreCase(request.getParameter("opcao"))) {               
                Context context = JNDIUtil.getCORBAInitialContext();
                Chat chat = (Chat)context.lookup("ChatBean");   
                request.setAttribute("salas", chat.listarSalas());
                RequestDispatcher view = request.getRequestDispatcher("./jsp/sala/excluir.jsp");                
                view.forward(request, response);              
            }
             
            if ("sala.excluir".equalsIgnoreCase(request.getParameter("opcao"))) {                
                Context context = JNDIUtil.getCORBAInitialContext();
                Chat chat = (Chat)context.lookup("ChatBean");
                chat.removeSala(new Sala(request.getParameter("sala")));      
                RequestDispatcher view = request.getRequestDispatcher("./ChatServlet?opcao=sala.listar");                
                view.forward(request, response);               
            }
            
            if ("sala.entrar.form".equalsIgnoreCase(request.getParameter("opcao"))) {
                Context context = JNDIUtil.getCORBAInitialContext();
                Chat chat = (Chat)context.lookup("ChatBean");   
                request.setAttribute("salas", chat.listarSalas());                
                RequestDispatcher view = request.getRequestDispatcher("./jsp/sala/entrar.jsp");
                view.forward(request, response);  
            }
            
            if ("sala.conversar".equalsIgnoreCase(request.getParameter("opcao"))) {
                Context context = JNDIUtil.getCORBAInitialContext();
                Chat chat = (Chat)context.lookup("ChatBean");                
                Sala sala = new Sala(request.getParameter("sala"));                
                chat.escreveNaSala(sala, request.getParameter("mensagem"));
                RequestDispatcher view = request.getRequestDispatcher("./jsp/sala/conversar.jsp");
                view.forward(request, response);          
            }
            
        }        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(ChatServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(ChatServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

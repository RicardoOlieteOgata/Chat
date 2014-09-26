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
                Chat chat = (Chat)context.lookup("ChatBeanRemote");          
                request.setAttribute("salas", chat.listarSalas());
                RequestDispatcher view = request.getRequestDispatcher("/jsp/sala/listar.jsp");
                view.forward(request, response);
                //request.getRequestDispatcher("./jsp/sala/listar.jsp").forward(request, response);               
            } 
            
            if ("sala.inserir".equalsIgnoreCase(request.getParameter("opcao"))) {
                Context context = JNDIUtil.getCORBAInitialContext();
                Chat chat = (Chat)context.lookup("ChatBeanRemote");          
                //Sala sala = new Sala();
                //sala.setNome("sala2");
                //chat.criaSala(sala);
                
                
                chat.criaSala(new Sala(request.getParameter("nome")));
                
                request.getRequestDispatcher("./jsp/sala/inserir.jsp").forward(request, response);
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

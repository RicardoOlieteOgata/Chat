/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.chatcliente;

import br.mackenzie.chat.Chat;
import br.mackenzie.modelo.Sala;
import br.mackenzie.util.JNDIUtil;
import javax.naming.Context;


/**
 *
 * @author Ricardo
 */
public class ChatCliente {
    public static void main(String[] args) {
        Sala sala1 = new Sala("Sala1");
        Sala sala2 = new Sala("Sala1");
        try {
            Context context = JNDIUtil.getCORBAInitialContext();
            Chat chat = (Chat)context.lookup("ChatBeanSingleton");
            System.out.println("Adicionando Salas");
            chat.criaSala(sala1);
            chat.criaSala(sala2);
                    System.out.println("Escrevendo Sala1");
                    chat.escreveNaSala(sala1, "Ola");
                    chat.escreveNaSala(sala1, "Tubo bem?");
                    System.out.println("Lendo Sala1");
                    System.out.println(chat.retornaTexto(sala1));
                    System.out.println("Removendo Sala2");
                    chat.removeSala(sala1);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }    
}

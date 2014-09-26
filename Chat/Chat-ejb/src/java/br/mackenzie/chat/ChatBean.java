/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.chat;

import br.mackenzie.modelo.Sala;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Ricardo
 */
@Startup
@Singleton(mappedName = "ChatBeanRemote")
public class ChatBean implements Chat{    
    private List<Sala> salas = new ArrayList<Sala>();    

    @Override
    public boolean criaSala(Sala sala) {
        if (salas.contains(sala)){            
            return false;
        }
        salas.add(sala);
        return true;
    }

    @Override
    public boolean removeSala(Sala sala) {
        if (salas.contains(sala)){
            salas.remove(sala);
            return true;
        }
        return false;        
    }

    @Override
    public boolean existeSala(Sala sala) {
        if (salas.contains(sala))
            return true;
        return false;        
    }

    @Override
    public String retornaTexto(Sala sala) {
        return salas.get(salas.indexOf(sala)).getTexto();        
    }

    @Override
    public void escreveNaSala(Sala sala, String texto) {
        salas.get(salas.indexOf(sala)).setTexto(salas.get(salas.indexOf(sala)).getTexto() + texto);
    }

    @Override
    public List<Sala> listarSalas() {
        return salas;
    }
    
}

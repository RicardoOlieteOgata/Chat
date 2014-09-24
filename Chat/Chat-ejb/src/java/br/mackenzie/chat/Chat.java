/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.chat;

import br.mackenzie.modelo.Sala;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Ricardo
 */
@Remote
public interface Chat {
    public boolean criaSala(Sala sala);
    public boolean removeSala(Sala sala);
    public boolean existeSala(Sala sala);
    public String retornaTexto(Sala sala);
    public void escreveNaSala(Sala sala, String texto);
    public List<Sala> listarSalas();

    
}

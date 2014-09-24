/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Ricardo
 */
public class Sala implements Serializable{
    private String nome;
    private String texto;

    public Sala() {
    }

    public Sala(String nome) {
        this.nome = nome;
    }

    public Sala(String nome, String texto) {
        this.nome = nome;
        this.texto = texto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public int hashCode() {        
        return nome.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Sala) {
            Sala toComapare = (Sala)obj;
            return this.nome.equals(toComapare.nome);
        }
        return false;        
    }
    
    
    
}

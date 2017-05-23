/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.pojos;

import java.io.Serializable;

/**
 *
 * @author omarl
 */
public class DiscoWithTipo extends Disco implements Serializable{
    private int idTipo;

    public DiscoWithTipo() {
    }

    public DiscoWithTipo(String titulo, int agno, int idInterprete, int idTipo) {
        super(titulo, agno, idInterprete);
        this.idTipo = idTipo;
    }

    public DiscoWithTipo(int idDisco, String titulo, int agno, int idInterprete, int idTipo) {
        super(idDisco, titulo, agno, idInterprete);
        this.idTipo = idTipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    
    
    
}

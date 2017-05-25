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
public class DiscoDetailed extends Disco implements Serializable {
    
    private String interprete;

    public DiscoDetailed() {
    }

    public DiscoDetailed(String titulo, int agno, int idInterprete, String interprete) {
        super(titulo, agno, idInterprete);
        this.interprete = interprete;
    }

    public DiscoDetailed(int idDisco, String titulo, int agno, int idInterprete, String interprete) {
        super(idDisco, titulo, agno, idInterprete);
        this.interprete = interprete;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }


    
    
    
}

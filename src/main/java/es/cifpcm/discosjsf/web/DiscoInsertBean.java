/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.web;

import es.cifpcm.discosjsf.connection.DaoFactory;
import es.cifpcm.discosjsf.interfaces.DiscoDao;
import es.cifpcm.discosjsf.pojos.DiscoDetailed;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author omarl
 */
@Named(value = "discoInsertBean")
@RequestScoped
public class DiscoInsertBean extends DiscoDetailed {

    public DiscoInsertBean() {

    }

    @NotNull(message = "El campo es obligatorio")
    @Size(min = 1, max = 255)
    @Override
    public String getTitulo() {
        return super.getTitulo();
    }

    @NotNull(message = "El campo es obligatorio")
    @Override
    public int getAgno() {
        return super.getAgno();
    }

    @NotNull(message = "El campo es obligatorio")
    @Override
    public int getIdInterprete() {
        return super.getIdInterprete();
    }
    
    public void insertDisc(){
        DaoFactory fac = DaoFactory.getInstance();
        DiscoDao dd = fac.getDiscoDao();
        DiscoDetailed d = dd.addDisc(this);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.web;

import es.cifpcm.discosjsf.connection.DaoFactory;
import es.cifpcm.discosjsf.interfaces.DiscoDao;
import es.cifpcm.discosjsf.pojos.Disco;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;

/**
 *
 * @author omarl
 */
@Named(value = "discoBeanInsert")
@RequestScoped
public class DiscoBeanInsert extends Disco implements Serializable {

    public DiscoBeanInsert() {
    }
    
    
    @NotNull(message = "El idInterprete no puede ir en blanco")
    @Override
    public int getIdInterprete() {
        return super.getIdInterprete(); //To change body of generated methods, choose Tools | Templates.
    }

    @NotNull(message = "El año no puede ir en blanco y/o no puede ser menor que 1800")
    @Override
    public int getAgno() {
        return super.getAgno(); //To change body of generated methods, choose Tools | Templates.
    }

    @NotNull(message = "El título no puede ir en blanco")
    @Override
    public String getTitulo() {
        return super.getTitulo(); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public int getIdDisco() {
        return super.getIdDisco(); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertDisc() {
        DaoFactory df = DaoFactory.getInstance();
        DiscoDao dd = df.getDiscoDao();
        Disco d = dd.insertDisc(this);

        if (d != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Disco insertado correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al insertar el disco"));
        }
    }

}

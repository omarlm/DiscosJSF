/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.web;

import es.cifpcm.discosjsf.logic.DiscoFacade;
import es.cifpcm.discosjsf.pojos.Disco;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author omarl
 */
@Named(value = "discoBeanInsert")
@RequestScoped
public class DiscoBeanInsert extends Disco implements Serializable {

    private final Logger logger = LoggerFactory.getLogger(DiscoBeanInsert.class);

    private Integer newTipo;

    public DiscoBeanInsert() {
    }

    @NotNull(message = "El idInterprete no puede ir en blanco")
    @Override
    public int getIdInterprete() {
        return super.getIdInterprete(); //To change body of generated methods, choose Tools | Templates.
    }

    @NotNull(message = "El año no puede ir en blanco y/o no puede ser menor que 1800")
    @Min(value = 1800)
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

        logger.debug("insertDisco tipo sel={}", newTipo);

        DiscoFacade discoFacade = new DiscoFacade();

        try {
            discoFacade.insertDisc(this, newTipo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Disco insertado correctamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al insertar el disco " + ex.getMessage()));

        }

    }

    public Integer getNewTipo() {
        return newTipo;
    }

    public void setNewTipo(Integer newTipo) {
        this.newTipo = newTipo;
    }

}

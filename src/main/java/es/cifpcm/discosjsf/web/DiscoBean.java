/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.web;

import es.cifpcm.discosjsf.connection.DaoFactory;
import es.cifpcm.discosjsf.interfaces.DiscoDao;
import es.cifpcm.discosjsf.pojos.DiscoDetailed;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author omarl
 */
@Named(value = "discoBean")
@ViewScoped
public class DiscoBean implements Serializable {

    private List<DiscoDetailed> disco;

    public DiscoBean() {
        DaoFactory fac = DaoFactory.getInstance();
        DiscoDao dd = fac.getDiscoDao();
        this.setDiscos(dd.selectDetails());
    }


    public List<DiscoDetailed> getDiscos() {
        return disco;
    }

    public void setDiscos(List<DiscoDetailed> disco) {
        this.disco = disco;
    }

}

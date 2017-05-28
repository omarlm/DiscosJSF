/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.web;

import es.cifpcm.discosjsf.connection.DaoFactory;
import es.cifpcm.discosjsf.interfaces.TipoDao;
import es.cifpcm.discosjsf.pojos.Tipo;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author omarl
 */
@Named(value = "tiposBean")
@ApplicationScoped
public class TiposBean {
    
    private final List<Tipo> tipos;

    /**
     * Creates a new instance of TiposBean
     */
    public TiposBean() {
        TipoDao tipoDao = DaoFactory.getInstance().getTipoDao();
        this.tipos = tipoDao.selectAll();
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

}

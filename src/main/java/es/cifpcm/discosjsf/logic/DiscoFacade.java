/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.logic;

import es.cifpcm.discosjsf.connection.DaoFactory;
import es.cifpcm.discosjsf.interfaces.DiscoDao;
import es.cifpcm.discosjsf.interfaces.DiscoTipoDao;
import es.cifpcm.discosjsf.pojos.Disco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author omarl
 */
public class DiscoFacade {
    
    private final Logger logger = LoggerFactory.getLogger(DiscoFacade.class);

    public void insertDisc(Disco disco, int newTipo) {

        DaoFactory df = DaoFactory.getInstance();
        
        DiscoDao dd = df.getDiscoDao();
        DiscoTipoDao dt = df.getDiscoTipoDao();
        
        
        Disco d = dd.insertDisc(disco);
        // nos cogemos el idDisco generado
        logger.debug("IdDisco generado={}", d.getIdDisco());
        dt.insert(d.getIdDisco(), newTipo);

    }

}

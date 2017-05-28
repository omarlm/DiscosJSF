/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.data;

import es.cifpcm.discosjsf.connection.ConnectionProvider;
import es.cifpcm.discosjsf.connection.DaoFactory;
import es.cifpcm.discosjsf.interfaces.DiscoTipoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author omarl
 */
public class MySqlDiscoTipoDao implements DiscoTipoDao {

    private Logger logger = LoggerFactory.getLogger(MySqlDiscoTipoDao.class);

    private ConnectionProvider provider;

    public MySqlDiscoTipoDao(DaoFactory aThis) {
        this.provider = aThis;
    }

    @Override
    public void insert(Integer idDisco, Integer idTipo) {

        //TODO implementar insert
        //logger.debug("Se inserta el tipo disco");      
        logger.debug("Generando insertTipo");
        
        String query = "INSERT INTO DiscoTipo (idTipo, idDisco) VALUES(?,?)";
        
        try (Connection conn = provider.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, idTipo);
            pstmt.setInt(2, idDisco);
            
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            logger.error("Error en la consulta de insert", ex);
        }
        

    }

}

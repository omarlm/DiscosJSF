/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.connection;

import es.cifpcm.discosjsf.data.MySqlClienteDao;
import es.cifpcm.discosjsf.data.MySqlDiscoDao;
import es.cifpcm.discosjsf.data.MySqlDiscoTipoDao;
import es.cifpcm.discosjsf.data.MySqlTipoDao;
import es.cifpcm.discosjsf.interfaces.ClienteDao;
import es.cifpcm.discosjsf.interfaces.DiscoDao;
import es.cifpcm.discosjsf.interfaces.DiscoTipoDao;
import es.cifpcm.discosjsf.interfaces.TipoDao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author omarl
 */
public class DaoFactory implements ConnectionProvider {

    private InitialContext ctx;
    private DataSource ds;

    private static DaoFactory instance;

    private final static Logger LOGGER = LoggerFactory.getLogger(DaoFactory.class);

    private DaoFactory() {
        try {
            this.ctx = new InitialContext();
            LOGGER.debug("Pidiendo datasource jdbc/discos");
            this.ds = (DataSource) ctx.lookup("jdbc/discos");

        } catch (NamingException ex) {
            LOGGER.error("Error al buscar el recurso JDBC ---> DaoFactory", ex);
        }
    }

    public static synchronized DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }

        return instance;
    }

    @Override
    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException ex) {
            LOGGER.error("Error al obtener la conexión ---> DaoFactory", ex);
            return null;
        }
    }

    @Override
    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                LOGGER.error("Error al cerrar la conexión ---> DaoFactory", ex);
            }
        }
    }

    public DiscoDao getDiscoDao() {
        return new MySqlDiscoDao(this);
    }

    public ClienteDao getClientesDao() {
        return new MySqlClienteDao(this);
    }

    public TipoDao getTipoDao() {
        return new MySqlTipoDao(this);
    }

    public DiscoTipoDao getDiscoTipoDao() {
        return new MySqlDiscoTipoDao(this);
    }
}

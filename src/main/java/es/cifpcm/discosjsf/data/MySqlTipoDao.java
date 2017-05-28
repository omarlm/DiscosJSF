/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.data;

import es.cifpcm.discosjsf.connection.ConnectionProvider;
import es.cifpcm.discosjsf.interfaces.TipoDao;
import es.cifpcm.discosjsf.pojos.Tipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author omarl
 */
public class MySqlTipoDao implements TipoDao {

    private final Logger logger = LoggerFactory.getLogger(MySqlTipoDao.class);

    private ConnectionProvider provider;

    public MySqlTipoDao() {
    }

    public MySqlTipoDao(ConnectionProvider provider) {
        this.provider = provider;
    }

    @Override
    public List<Tipo> selectAll() {
        final String query = "SELECT IdTipo, Tipo FROM Tipo";

        List<Tipo> tipos = new ArrayList<>();

        try (Connection conn = provider.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Tipo tipo = new Tipo();
                tipo.setIdTipo(rs.getInt(1));
                tipo.setTipo(rs.getString(2));
                tipos.add(tipo);
            }

        } catch (SQLException ex) {
            logger.error("selectAll", ex);
        }


        return tipos;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.data;

import es.cifpcm.discosjsf.connection.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import es.cifpcm.discosjsf.interfaces.ClienteDao;
import es.cifpcm.discosjsf.pojos.Cliente;

/**
 *
 * @author omarl
 */
public class MySqlClienteDao implements ClienteDao {

    ConnectionProvider provider;
    Connection conn;

    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MySqlClienteDao.class);

    public MySqlClienteDao(ConnectionProvider aThis) {
        this.provider = aThis;
        this.conn = provider.getConnection();
    }

    @Override
    public List<Cliente> selectAll() {
        LOGGER.debug("Generando un selectIntérprete");

        List<Cliente> listClient = new ArrayList<>();
        final String query = "SELECT Nombre, Email, FechaNacimiento, FechaRegistro FROM Cliente";

        try (Statement st = conn.createStatement()) {
            try (ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    
                    cliente.setNombre(rs.getString("Nombre"));
                    cliente.setEmail(rs.getString("Email"));
                    cliente.setFechaNacimiento(rs.getDate("FechaNacimiento"));
                    cliente.setFechaRegistro(rs.getDate("FechaRegistro"));
                    listClient.add(cliente);
                }
            }
        } catch (SQLException ex) {
            LOGGER.error("Error al hacer la consulta de Interprete" + ex);
            listClient = null;
        }
        return listClient;
    }
}

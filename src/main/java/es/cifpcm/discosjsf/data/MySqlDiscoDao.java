/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.data;

import es.cifpcm.discosjsf.connection.ConnectionProvider;
import es.cifpcm.discosjsf.interfaces.DiscoDao;
import es.cifpcm.discosjsf.pojos.Disco;
import es.cifpcm.discosjsf.pojos.DiscoDetailed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;

/**
 *
 * @author omarl
 */
public class MySqlDiscoDao implements DiscoDao {

    ConnectionProvider provider;
    Connection conn;

    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MySqlDiscoDao.class);

    public MySqlDiscoDao(ConnectionProvider aThis) {
        this.provider = aThis;
        this.conn = provider.getConnection();
    }

//    @Override
//    public List<Disco> selectAll() {
//        LOGGER.debug("Generando un selectAll");
//
//        List<Disco> listadoDisco = new ArrayList<>();
//        final String query = "SELECT Titulo FROM Disco";
//
//        try (Statement st = conn.createStatement()) {
//            try (ResultSet rs = st.executeQuery(query)) {
//                while (rs.next()) {
//                    Disco disc = new Disco();
//                    disc.setTitulo(rs.getString("Titulo"));
//                    /*disc.setAgno(rs.getInt("Agno"));
//                disc.setIdInterprete(rs.getInt("idInterprete"));*/
//                    listadoDisco.add(disc);
//                }
//            }
//        } catch (SQLException ex) {
//            LOGGER.error("****** Error al hacer la consulta de Discos --> " + ex + " ******");
//            listadoDisco = null;
//        }
//        return listadoDisco;
//        try (Connection conn = provider.getConnection();
//                PreparedStatement pstmt = conn.prepareStatement(query)) {
//
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                Disco disc = new Disco();
//                disc.setTitulo(rs.getString("Titulo"));
//                /*disc.setAgno(rs.getInt("Agno"));
//                disc.setIdInterprete(rs.getInt("idInterprete"));*/
//                listadoDiscoDetails.add(disc);
//
//            }
//            provider.closeConnection(conn);
//        } catch (SQLException ex) {
//            LOGGER.error("Error en el selectAll: ", ex);
//        }
//        return listadoDiscoDetails;
//    }
    @Override
    public List<DiscoDetailed> selectDetails() {
        LOGGER.debug("Generando un selectDetails");

        List<DiscoDetailed> listadoDiscoDetails = new ArrayList<>();
        final String query = "SELECT d.Titulo, d.agno, d.idInterprete, i.Interprete FROM Disco d INNER JOIN Interprete i ON d.idInterprete = i.idInterprete";

        try (Statement st = conn.createStatement()) {
            try (ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    DiscoDetailed disc = new DiscoDetailed();
                    disc.setTitulo(rs.getString("Titulo"));
                    disc.setAgno(rs.getInt("Agno"));
                    disc.setIdInterprete(rs.getInt("idInterprete"));
                    disc.setInterprete(rs.getString("Interprete"));
                    listadoDiscoDetails.add(disc);
                }
            }
        } catch (SQLException ex) {
            LOGGER.error("Error al hacer la consulta de Discos" + ex);
            listadoDiscoDetails = null;
        }
        return listadoDiscoDetails;
    }

    @Override
    public Disco insertDisc(Disco disco) {
        LOGGER.debug("Generando addDisc");

        String query = "INSERT INTO Disco (Titulo, Agno, idInterprete) VALUES(?,?,?)";
        //String query = "INSERT INTO Disco (Titulo, Agno) VALUES(?,?)";

        try (PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, disco.getTitulo());
            st.setInt(2, disco.getAgno());
            st.setInt(3, disco.getIdInterprete());

            int discInserted = st.executeUpdate();
            if (discInserted > 0) {
                LOGGER.debug("Disco Insertado!!");

                try (ResultSet rs = st.getGeneratedKeys()) {
                    if (rs.next()) {

                        disco.setIdDisco(rs.getInt(1));

                    }

                }

            }

        } catch (SQLException ex) {
            LOGGER.error("Error en la consulta de addDisc", ex);
            disco = null;
        }

        return disco;
    }
}

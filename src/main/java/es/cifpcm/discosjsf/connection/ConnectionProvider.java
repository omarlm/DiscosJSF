/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.connection;

import java.sql.Connection;

/**
 *
 * @author omarl
 */
public interface ConnectionProvider {
    Connection getConnection();
    void closeConnection(Connection conn);
}

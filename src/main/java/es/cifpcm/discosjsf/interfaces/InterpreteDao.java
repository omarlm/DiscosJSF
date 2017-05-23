/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.interfaces;

import es.cifpcm.discosjsf.pojos.Interprete;
import java.util.List;

/**
 *
 * @author omarl
 */
public interface InterpreteDao {
    public List<Interprete> selectAll();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.web;

import es.cifpcm.discosjsf.connection.DaoFactory;
import es.cifpcm.discosjsf.interfaces.ClienteDao;
import es.cifpcm.discosjsf.pojos.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author omarl
 */
@Named(value = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable{

    private List<Cliente> cliente;
    public ClienteBean() {
        DaoFactory fac = DaoFactory.getInstance();
        ClienteDao cd = fac.getClientesDao();
        this.setClientes(cd.selectAll());
    }
    
    public List<Cliente> getClientes(){
        return cliente;
    }
    
    public void setClientes(List<Cliente> cliente){
        this.cliente = cliente;
    }
    
}

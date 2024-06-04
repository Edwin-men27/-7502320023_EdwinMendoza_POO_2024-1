/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.metodos;

import co.edu.udec.poo.edwinmendoza.persistencia.OrganizacionJpaController;
import co.edu.udec.poo.edwinmendoza.persistencia.exceptions.NonexistentEntityException;
import dominio.Organizacion;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Edwin
 */
public class OrganizacionMetodosController {
    
    private OrganizacionJpaController organizacionJpa = new OrganizacionJpaController();
    
    public void crearOrganizacion(Organizacion objeto){
        try {
            if (existeOrganizacion(objeto)) {
                throw new Exception("La organizacion ya se encuentra agregado en la base de datos");
            }
            organizacionJpa.create(objeto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    public void eliminarOrganizacion(String codigo) throws Exception{
        Organizacion buscar = traerOrganizacion(codigo);
        
        try {
            if (buscar == null) {
                throw new Exception("La organizacion no se encuentra agregado en la base de datos");
            }
            organizacionJpa.destroy(buscar.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClienteMetodosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void editarOrganizacion(Organizacion objeto){
        try {
            if (!existeOrganizacion(objeto)) {
                throw new Exception("La organizacion no se encuentra agregado en la base de datos");
            }
            organizacionJpa.edit(objeto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public Organizacion buscarOrganizacion(String codigo) throws Exception{
        Organizacion buscar = traerOrganizacion(codigo);
        
        try {
            if (buscar == null) {
                throw new Exception("La organizacion no se encuentra agregado en la base de datos");
            }
            return organizacionJpa.findOrganizacion(buscar.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClienteMetodosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Organizacion> traerListaOrganizacion() {
        List<Organizacion> listaOrganizacions = organizacionJpa.findOrganizacionEntities();
        
        return listaOrganizacions;
    }
    
    public Organizacion traerOrganizacion(String usuario){
        Organizacion buscar = null;
        List<Organizacion> listaEmpleados = traerListaOrganizacion();
        
        Map<String, Organizacion> map = new HashMap<>();
        
        for (Organizacion op: listaEmpleados){
            map.put(op.getIdentificacion(), op);
        }
        
        buscar = map.get(usuario);
        
        if (!(buscar == null)) {
            return buscar;
        }else{
        return null;
        } 
    }
    
    public boolean existeOrganizacion(Organizacion elemento){
    try {
            String codigo = elemento.getIdentificacion();

            List<Organizacion> lista = traerListaOrganizacion();

            Map<String, Organizacion> listaClientes = new HashMap<>();

            for (Organizacion ver : lista) {
                listaClientes.put(ver.getIdentificacion(), ver);
            }

            Organizacion buscar = listaClientes.get(elemento.getIdentificacion()); 

             String tipo = buscar == null ? "" : buscar.getIdentificacion();

            if (codigo.equals(tipo)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        
    }
}

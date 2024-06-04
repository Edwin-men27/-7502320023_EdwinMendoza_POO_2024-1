/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.metodos;

import co.edu.udec.poo.edwinmendoza.persistencia.ClienteJpaController;
import co.edu.udec.poo.edwinmendoza.persistencia.exceptions.NonexistentEntityException;
import dominio.Cliente;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Edwin
 */
public class ClienteMetodosController {
    
    private ClienteJpaController clienteBd = new ClienteJpaController();
    
    public void crearCliente(Cliente objeto){
        try {
            if (existeCliente(objeto)) {
                throw new Exception("El cliente ya se encuentra agregado en la base de datos");
            }
        clienteBd.create(objeto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void eliminarCliente(String codigo) throws Exception{
        Cliente buscar = traerCliente(codigo);
        
        try {
            if (buscar == null) {
                throw new Exception("El cliente no se encuentra agregado en la base de datos");
            }
            clienteBd.destroy(buscar.getId());
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void editarCliente(Cliente objeto){
        try {
            if (!(existeCliente(objeto))) {
                throw new Exception("El cliente no se encuentra agregado en la base de datos");
            }
        clienteBd.edit(objeto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public Cliente buscarCliente(String codigo) throws Exception{
        Cliente buscar = traerCliente(codigo);
        
        try {
            if (buscar == null) {
                throw new Exception("El cliente no se encuentra agregado en la base de datos");
            }
            return clienteBd.findCliente(buscar.getId());
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
        return null;
    }
    
    public List<Cliente> traerListaClientes() {
        List<Cliente> listaClientes = clienteBd.findClienteEntities();
        
        return listaClientes;
    }
    
    public Cliente traerCliente(String usuario){
        Cliente buscar = null;
        List<Cliente> listaClientes = traerListaClientes();
        
        Map<String, Cliente> map = new HashMap<>();
        
        for (Cliente op: listaClientes){
            map.put(op.getIdentificacion(), op);
        }
        
        buscar = map.get(usuario);
        
        if (!(buscar == null)) {
            return buscar;
        }else{
        return null;
        } 
    }
    public Cliente buscarPorIdentificacion(String usuario,String clave){
        List<Cliente> listaClientes = traerListaClientes();
        
        Map<String, Cliente> map = new HashMap<>();
        
        for (Cliente op: listaClientes){
            map.put(op.getIdentificacion(), op);
        }
        
        Cliente buscar = map.get(usuario);
        
        if (clave.equals(buscar.getClave())) {
            return buscar;
        }else{
        return null;
        } 
    }
    
    
    
    public boolean existeCliente(Cliente elemento){
    try {
            String codigo = elemento.getIdentificacion();

            List<Cliente> lista = traerListaClientes();

            Map<String, Cliente> listaClientes = new HashMap<>();

            for (Cliente ver : lista) {
                listaClientes.put(ver.getIdentificacion(), ver);
            }

            Cliente buscar = listaClientes.get(elemento.getIdentificacion()); 

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

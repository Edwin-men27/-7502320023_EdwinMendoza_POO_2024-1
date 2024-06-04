/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.metodos;

import co.edu.udec.poo.edwinmendoza.persistencia.PersonaFisicaJpaController;
import co.edu.udec.poo.edwinmendoza.persistencia.exceptions.NonexistentEntityException;
import dominio.PersonaFisica;
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
public class PersonaFisicaMetodosController{
    
    private PersonaFisicaJpaController personaBd = new PersonaFisicaJpaController();
    
    public void crearPersonaFisica(PersonaFisica objeto){
        try {
            if (existePersonaFisica(objeto)) {
                throw new Exception("El cliente ya existe");
            }
            personaBd.create(objeto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }    
    }
    
    public void eliminarPersonaFisica(String codigo) throws Exception{
        PersonaFisica buscar = traerPersonaFisica(codigo);
        try {
            if (buscar == null) {
                throw new Exception("El cliente no se encuentra en la base de datos");
            }
            personaBd.destroy(buscar.getId());
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void editarPersonaFisica(PersonaFisica objeto){
        try {
            if (!existePersonaFisica(objeto)) {
                throw new Exception("El cliente no existe en la base datos");
            }
            personaBd.edit(objeto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public PersonaFisica buscarPersonaFisica(String codigo) throws Exception{
        PersonaFisica buscar = traerPersonaFisica(codigo);
        try {
            if (buscar == null) {
                throw new Exception("El cliente no se encuentra en la base de datos");
            }
            return personaBd.findPersonaFisica(buscar.getId());
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public List<PersonaFisica> traerListaPersonaFisicas() {
        List<PersonaFisica> listaPersonaFisicas = personaBd.findPersonaFisicaEntities();
        
        return listaPersonaFisicas;
    }
    
    public PersonaFisica traerPersonaFisica(String usuario){
        PersonaFisica buscar = null;
        List<PersonaFisica> listaEmpleados = traerListaPersonaFisicas();
        
        Map<String, PersonaFisica> map = new HashMap<>();
        
        for (PersonaFisica op: listaEmpleados){
            map.put(op.getIdentificacion(), op);
        }
        
        buscar = map.get(usuario);
        
        if (!(buscar == null)) {
            return buscar;
        }else{
        return null;
        } 
    }
    
    public boolean existePersonaFisica(PersonaFisica elemento){
    try {
            String codigo = elemento.getIdentificacion();

            List<PersonaFisica> lista = traerListaPersonaFisicas();

            Map<String, PersonaFisica> listaClientes = new HashMap<>();

            for (PersonaFisica ver : lista) {
                listaClientes.put(ver.getIdentificacion(), ver);
            }

            PersonaFisica buscar = listaClientes.get(elemento.getIdentificacion()); 

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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.metodos;

import co.edu.udec.poo.edwinmendoza.persistencia.EmpleadoJpaController;
import co.edu.udec.poo.edwinmendoza.persistencia.exceptions.NonexistentEntityException;
import dominio.Empleado;
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
public class EmpleadoMetodosController{
    
    private EmpleadoJpaController empleadoBd = new EmpleadoJpaController();
    
    public void crearEmpleado(Empleado objeto){
        try {
            if (existeEmpleado(objeto)) {
                throw new Exception("El empleado ya existe en la base de datos");
            }
            empleadoBd.create(objeto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void eliminarEmpleado(String codigo) throws Exception{
        Empleado buscar = traerEmpleado(codigo);
        
        try {
            if (buscar == null) {
                throw new Exception("El empleado no se encuentra agregado en la base de datos");
            }
            empleadoBd.destroy(buscar.getId());
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void editarEmpleado(Empleado objeto){
        
        try {
            if (!existeEmpleado(objeto)) {
                throw new Exception("El cliente no existe en la base de datos");
            }
            empleadoBd.edit(objeto);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public Empleado buscarEmpleado(String codigo) throws Exception{
        Empleado buscar = traerEmpleado(codigo);
        
        try {
            if (buscar == null) {
                throw new Exception("El cliente no se encuentra agregado en la base de datos");
            }
            return empleadoBd.findEmpleado(buscar.getId());
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    

    public LinkedList<Empleado> traerListaEmpleados(){
        List<Empleado> empleados = empleadoBd.findEmpleadoEntities();
        LinkedList<Empleado> listaEmpleados = new LinkedList(empleados);
        
        return listaEmpleados;
    }
    
    public Empleado traerEmpleado(String usuario){
        Empleado buscar = null;
        List<Empleado> listaEmpleados = traerListaEmpleados();
        
        Map<String, Empleado> map = new HashMap<>();
        
        for (Empleado op: listaEmpleados){
            map.put(op.getIdentificacion(), op);
        }
        
        buscar = map.get(usuario);
        
        if (!(buscar == null)) {
            return buscar;
        }else{
        return null;
        } 
    }
    
    public boolean existeEmpleado(Empleado elemento){
    try {
            String codigo = elemento.getIdentificacion();

            List<Empleado> lista = traerListaEmpleados();

            Map<String, Empleado> listaClientes = new HashMap<>();

            for (Empleado ver : lista) {
                listaClientes.put(ver.getIdentificacion(), ver);
            }

            Empleado buscar = listaClientes.get(elemento.getIdentificacion()); 

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

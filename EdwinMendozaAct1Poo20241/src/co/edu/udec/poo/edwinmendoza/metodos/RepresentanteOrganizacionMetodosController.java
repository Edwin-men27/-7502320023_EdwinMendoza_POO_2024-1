/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.metodos;

import co.edu.udec.poo.edwinmendoza.persistencia.RepresentanteOrganizacionJpaController;
import co.edu.udec.poo.edwinmendoza.persistencia.exceptions.NonexistentEntityException;
import dominio.RepresentanteOrganizacion;
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
public class RepresentanteOrganizacionMetodosController {
    
    RepresentanteOrganizacionJpaController representanteBd = new RepresentanteOrganizacionJpaController();
    
    public void crearRepresentante(RepresentanteOrganizacion objeto){
        RepresentanteOrganizacion representante = encontrarBanco(objeto.getNombre());
        try {
            if (!(representante == null)) {
                throw new Exception("El representante ya se encuentra agregado en la base de datos");
            }
            
            representanteBd.create(objeto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } 
    
    public void eliminarRepresentante(String codigo){
        RepresentanteOrganizacion representante = encontrarBanco(codigo);
        try {
            if (representante == null) {
                throw new Exception("El representante no se encuentra agregado en la base de datos");
            }
            
            representanteBd.destroy(representante.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    
    public void editarRepresentante(RepresentanteOrganizacion objeto){
        RepresentanteOrganizacion representante = encontrarBanco(objeto.getNombre());
        try {
            if (representante == null) {
                throw new Exception("El representante no se encuentra agregado en la base de datos");
            }
            
            representanteBd.edit(objeto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public RepresentanteOrganizacion buscarRepresentante(String codigo){
        RepresentanteOrganizacion representante = encontrarBanco(codigo);
        try {
            if (representante == null) {
                throw new Exception("El representante no se encuentra agregado en la base de datos");
            }
            return representanteBd.findRepresentanteOrganizacion(representante.getId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public LinkedList<RepresentanteOrganizacion> traerLisTaRepresentantes() {
        List<RepresentanteOrganizacion> representantes = representanteBd.findRepresentanteOrganizacionEntities();
        LinkedList<RepresentanteOrganizacion> listaRepresentantes = new LinkedList<RepresentanteOrganizacion>(representantes);
        
        return listaRepresentantes;
    }
    
    public RepresentanteOrganizacion encontrarBanco(String codigo){
        RepresentanteOrganizacion encontrado = null;
        
        
            List<RepresentanteOrganizacion> lista = traerLisTaRepresentantes();
            
            Map<String, RepresentanteOrganizacion> listaBancos = new HashMap<>();
            
            for (RepresentanteOrganizacion entry : lista) {
                listaBancos.put(entry.getNombre(), entry);   
            }
            
            encontrado = listaBancos.get(codigo);
            
            if (!(encontrado == null)) {
                return encontrado;
            }else{
                return null;
            }
    }
}

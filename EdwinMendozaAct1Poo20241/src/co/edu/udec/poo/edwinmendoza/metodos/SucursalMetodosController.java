/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.metodos;


import co.edu.udec.poo.edwinmendoza.Principal;
import co.edu.udec.poo.edwinmendoza.persistencia.SucursalJpaController;
import co.edu.udec.poo.edwinmendoza.persistencia.exceptions.NonexistentEntityException;
import dominio.Sucursal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class SucursalMetodosController {

    private SucursalJpaController sucursalBd = new SucursalJpaController();

    public void crearSucursal(Sucursal objeto) throws Exception {
        try {
            if (ExisteSucursal(objeto)) {
                throw new Exception("La sucursal ya se encuentra agregado en la base de datos");
            }
            sucursalBd.create(objeto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void eliminarSucursal(String codigo) throws Exception {
        Sucursal buscar = traerSucursal(codigo);
        try {
            if ( buscar == null) {
                throw new Exception("La sucursal no se encuentra agregado en la base de datos");

            }
            sucursalBd.destroy(buscar.getId());
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void editarSucursal(Sucursal objeto) {
        try {
            if (!(ExisteSucursal(objeto))) {
                throw new Exception("La sucursal no se encuentra agregado en la base de datos");
            }
            sucursalBd.edit(objeto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Sucursal buscarSucursal(String codigo) throws Exception {
        Sucursal buscar = traerSucursal(codigo);
        try {
            if ( buscar == null) {
                throw new Exception("La sucursal no se encuentra agregado en la base de datos");

            }
            return sucursalBd.findSucursal(buscar.getId());
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public LinkedList<Sucursal> traerListaSucursales() {
        List<Sucursal> sucursales = sucursalBd.findSucursalEntities();
        LinkedList<Sucursal> listaSucursales = new LinkedList(sucursales);

        return listaSucursales;
    }

    public boolean ExisteSucursal(Sucursal elemento) {

        try {
            String codigo = elemento.getCodigo();

            LinkedList<Sucursal> lista = traerListaSucursales();

            Map<String, Sucursal> listaSucursales = new HashMap<>();

            for (Sucursal ver : lista) {
                listaSucursales.put(ver.getCodigo(), ver);
            }

            Sucursal buscar = listaSucursales.get(elemento.getCodigo()); // no se puede buscar


            String codigoSuc = (buscar == null) ? "" : buscar.getCodigo();

            if (codigo.equals(codigoSuc)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public Sucursal traerSucursal(String codigo){
        Sucursal encontrado = null;
        
        
            List<Sucursal> lista = traerListaSucursales();
            
            Map<String, Sucursal> listaBancos = new HashMap<>();
            
            for (Sucursal entry : lista) {
                listaBancos.put(entry.getCodigo(), entry);   
            }
            
            encontrado = listaBancos.get(codigo);
            
            if (!(encontrado == null)) {
                return encontrado;
            }else{
                return null;
            }
    }
    
    public Sucursal[] arraySucursales(){
        
        
        List<Sucursal> listado = traerListaSucursales();
        Sucursal[] elementos = new Sucursal[listado.size()];
        for(int i = 0; i < listado.size();i++){
            elementos[i] = listado.get(i);
        }
    
    return elementos;
    }
    
//    
}

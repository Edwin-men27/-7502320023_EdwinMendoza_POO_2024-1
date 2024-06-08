/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.metodos;

import co.edu.udec.poo.edwinmendoza.Principal;
import co.edu.udec.poo.edwinmendoza.persistencia.exceptions.NonexistentEntityException;
import co.edu.udec.poo.edwinmendoza.persistencia.BancoJpaController;
import dominio.Banco;
import java.util.ArrayList;
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
public class BancoMetodosController {

    private BancoJpaController bancoBd = new BancoJpaController();

    public void crearBanco(Banco objeto) throws Exception {
        try {
            if (existeBanco(objeto)) {
                throw new Exception("El banco ya se encuentra agregado en la base de datos");
            }
            bancoBd.create(objeto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void eliminarBanco(String codigo) throws Exception {
        Banco buscar = encontrarBanco(codigo);
        try {
            if (!existeBanco(buscar)) {
               throw new Exception("El banco no se encuentra agregado en la base de datos");
            }
            bancoBd.destroy(buscar.getCodigoIdentificador());
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void editarBanco(Banco objeto) {
        try {
            if (!existeBanco(objeto)) {
                throw new Exception("El banco no se encuentra agregado en la base de datos");
            }
            bancoBd.edit(objeto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    public int cantidadBancos(){
        return bancoBd.getBancoCount();
    }

    public Banco buscarBanco(String id) throws Exception {
        Banco buscar = encontrarBanco(id);
        try {
            if (buscar == null) {
               throw new Exception("El banco no se encuentra agregado en la base de datos");
            }
            return bancoBd.findBanco(buscar.getCodigoIdentificador());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    public ArrayList<Banco> traerListaBancos() {
        List<Banco> bancos = bancoBd.findBancoEntities();
        ArrayList<Banco> listaBancos = new ArrayList<Banco>(bancos);

        return listaBancos;
    }

    public Banco encontrarBanco(String codigo){
        Banco encontrado = null;
        
        
            List<Banco> lista = traerListaBancos();
            
            Map<String, Banco> listaBancos = new HashMap<>();
            
            for (Banco entry : lista) {
                listaBancos.put(entry.getCodigoIdentificador(), entry);   
            }
            
            encontrado = listaBancos.get(codigo);
            
            if (!(encontrado == null)) {
                return encontrado;
            }else{
                return null;
            }
    }
    
    public boolean existeBanco(Banco elemento) {
        try {
            String codigo = elemento.getCodigoIdentificador();

            List<Banco> lista = traerListaBancos();

            Map<String, Banco> listaBancos = new HashMap<>();

            for (Banco ver : lista) {
                listaBancos.put(ver.getCodigoIdentificador(), ver);
            }

            Banco buscar = listaBancos.get(elemento.getCodigoIdentificador());

            String tipo = (buscar == null) ? "" : buscar.getCodigoIdentificador();

            if (codigo.equals(tipo)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
    public Banco[] arrayBancos(){
        
        
        ArrayList<Banco> listado = traerListaBancos();
        Banco[] elementos = new Banco[listado.size()];
        for(int i = 0; i < listado.size();i++){
            elementos[i] = listado.get(i);
        }
    
    return elementos;
    }
    
    
}

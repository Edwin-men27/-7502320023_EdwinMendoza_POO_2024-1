/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.metodos;

import static co.edu.udec.poo.edwinmendoza.Principal.tipoCuentaBd;
import co.edu.udec.poo.edwinmendoza.persistencia.TipoDeCuentaJpaController;
import co.edu.udec.poo.edwinmendoza.persistencia.exceptions.NonexistentEntityException;
import dominio.TipoDeCuenta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Edwin
 */
public class TipoDeCuentaMetodosController {

    TipoDeCuentaJpaController tipoDeCuentaBd = new TipoDeCuentaJpaController();

    public void crearTipoDeCuenta(TipoDeCuenta objeto) throws Exception {
        try {
            if (existeTipoDeCuenta(objeto)) {
                throw new Exception("El tipo de cuenta ya se encuentra agregado en la base de datos");
            }
            
            tipoDeCuentaBd.create(objeto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }

    public void eliminarTipoDeCuenta(String codigo) throws Exception {
        TipoDeCuenta buscar = traerCuenta(codigo);
        try {
            if ( buscar == null) {
                throw new Exception("El tipo de cuenta no se encuentra agregado en la base de datos");

            }
            tipoDeCuentaBd.destroy(buscar.getId());
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
    }

    public void editarTipoDeCuenta(TipoDeCuenta objeto) {
        try {
            if (!(existeTipoDeCuenta(objeto))) {
                throw new Exception("El tipo de cuenta no se encuentra agregado en la base de datos");
            }
            
            tipoDeCuentaBd.edit(objeto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public TipoDeCuenta buscarTipoDeCuenta(String codigo) throws Exception {
        TipoDeCuenta buscar = traerCuenta(codigo);
        try {
            if ( buscar == null) {
                throw new Exception("El tipo de cuenta no se encuentra agregado en la base de datos");

            }
            return tipoDeCuentaBd.findTipoDeCuenta(buscar.getId());
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
        
    }

    public ArrayList<TipoDeCuenta> traerListaTipoDeCuenta() {
        List<TipoDeCuenta> tipoDeCuentas = tipoDeCuentaBd.findTipoDeCuentaEntities();
        ArrayList<TipoDeCuenta> listaTiposDeCuentas = new ArrayList(tipoDeCuentas);

        return listaTiposDeCuentas;

    }
    
    public boolean existeTipoDeCuenta(TipoDeCuenta elemento){ 
        try {
            String codigo = elemento.getTipo();

            List<TipoDeCuenta> lista = traerListaTipoDeCuenta();

            Map<String, TipoDeCuenta> listaTipos = new HashMap<>();

            for (TipoDeCuenta ver : lista) {
                listaTipos.put(ver.getTipo(), ver);
            }

            TipoDeCuenta buscar = listaTipos.get(elemento.getTipo()); 

            String tipo = buscar == null ? "" : buscar.getTipo();

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
    
    public TipoDeCuenta traerCuenta(String tipo){
        TipoDeCuenta encontrado = null;
        
        
            List<TipoDeCuenta> lista = traerListaTipoDeCuenta();
            
            Map<String, TipoDeCuenta> listaBancos = new HashMap<>();
            
            for (TipoDeCuenta entry : lista) {
                listaBancos.put(entry.getTipo(), entry);   
            }
            
            encontrado = listaBancos.get(tipo);
            
            if (!(encontrado == null)) {
                return encontrado;
            }else{
                return null;
            }
    }
    public String[] ArrayTipoCuentas() throws Exception {

        try {
            ArrayList<TipoDeCuenta> tipoCuentas = traerListaTipoDeCuenta();

            if (tipoCuentas.size() == 0) {
                throw new Exception("No hay tipos de cuentas para mostrar");
            }

            String[] arrayDeTiposDeCuentas = new String[tipoCuentas.size()];

            for (int i = 0; i < tipoCuentas.size(); i++) {
                System.out.println("Tipo de cuenta: " + tipoCuentas.get(i).getTipo() + "asd: " + i);
                arrayDeTiposDeCuentas[i] = tipoCuentas.get(i).getTipo();
            }

            return arrayDeTiposDeCuentas;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

    }
}

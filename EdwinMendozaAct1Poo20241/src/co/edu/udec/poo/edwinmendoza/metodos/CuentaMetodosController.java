/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.metodos;

import co.edu.udec.poo.edwinmendoza.persistencia.CuentaJpaController;
import co.edu.udec.poo.edwinmendoza.persistencia.exceptions.NonexistentEntityException;
import dominio.Cuenta;
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
public class CuentaMetodosController {

    private CuentaJpaController cuentaBd = new CuentaJpaController();

    public void crearCuenta(Cuenta objeto) {
        try {
            if (existeCuenta(objeto)) {
                throw new Exception("La cuenta ya se encuentra agregado en la base de datos");
            }
            cuentaBd.create(objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminarCuenta(String codigo) throws Exception {
        Cuenta buscar = encontrarBanco(codigo);
        
        try {
            if (buscar == null) {
                throw new Exception("El cliente no se encuentra agregado en la base de datos");
            }
            cuentaBd.destroy(buscar.getId());
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void editarCuenta(Cuenta objeto) {
        try {
            if (!existeCuenta(objeto)) {
                throw new Exception("La cuenta no se encuentra agregado en la base de datos");
            }
            cuentaBd.edit(objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Cuenta buscarCuenta(String codigo) throws Exception {
        Cuenta buscar = encontrarBanco(codigo);
        
        try {
            if (buscar == null) {
                throw new Exception("El cliente no se encuentra agregado en la base de datos");
            }
            return cuentaBd.findCuenta(buscar.getId());
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    public LinkedList<Cuenta> traerListaCuentas() {
        List<Cuenta> cuentas = cuentaBd.findCuentaEntities();
        LinkedList<Cuenta> listaCuentas = new LinkedList(cuentas);

        return listaCuentas;
    }

    public Cuenta encontrarBanco(String codigo){
        Cuenta encontrado = null;
        
            List<Cuenta> lista = traerListaCuentas();
            
            Map<String, Cuenta> listaBancos = new HashMap<>();
            
            for (Cuenta entry : lista) {
                listaBancos.put(entry.getCodigoCuentaCliente(), entry);   
            }
            encontrado = listaBancos.get(codigo);
            
            if (!(encontrado == null)) {
                return encontrado;
            }else{
                return null;
            }
    }
    public boolean existeCuenta(Cuenta elemento) {
        try {
            String codigo = elemento.getCodigoCuentaCliente();

            LinkedList<Cuenta> lista = traerListaCuentas();

            Map<String, Cuenta> listaCuentas = new HashMap<>();

            for (Cuenta ver : lista) {
                listaCuentas.put(ver.getCodigoCuentaCliente(), ver);
            }

            Cuenta buscar = listaCuentas.get(elemento.getCodigoCuentaCliente());

             String tipo = buscar == null ? "" : buscar.getCodigoCuentaCliente();

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
}

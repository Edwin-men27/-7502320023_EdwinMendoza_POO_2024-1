/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import Model.InterfasCrud;
import dominio.Cuenta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Edwin
 */
public class CuentaCrud implements InterfasCrud<Cuenta> {

    private HashMap<String, Cuenta> listaCuenta = new HashMap<>();

    public CuentaCrud() {
        this.listaCuenta = new HashMap<>();
    }
    

    @Override
    public void agregar(Cuenta objeto) throws Exception {
        try {
            if (listaCuenta.containsKey(objeto.getCodigoCuentaCliente())) {
                throw new Exception("La cuenta ya se encuentra agregado en el sistema");
            }

            listaCuenta.put(objeto.getCodigoCuentaCliente(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Cuenta buscar(String codigo) throws Exception {
        try {
            if (!listaCuenta.containsKey(codigo)) {
                throw new Exception("La cuenta no se encuentra registrado");
            }
            return listaCuenta.get(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void editar(Cuenta objeto) throws Exception {
        try {
            if (!listaCuenta.containsKey(objeto.getCodigoCuentaCliente())) {
                throw new Exception("La Cuenta no se encuentra registrado");
            }
            listaCuenta.put(objeto.getCodigoCuentaCliente(), objeto);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!listaCuenta.containsKey(codigo)) {
                throw new Exception("La cuenta no se encuentra en la base de datos");
            }

            listaCuenta.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Cuenta> listarTodo() throws Exception {
        List<Cuenta> cuentas = new ArrayList<>();
        try {
            if (listaCuenta.isEmpty()) {
                throw new Exception("No existen cuentas en el sistema");
            }

            for (Map.Entry<String, Cuenta> parte : listaCuenta.entrySet()) {
                String codigo = parte.getKey();
                Cuenta cuenta = parte.getValue();

                cuentas.add(cuenta);
            }
            return cuentas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int contar() throws Exception {
        List<Cuenta> cuentas = new ArrayList<>();
        int tamaño = 0;

        try {

            tamaño = cuentas.size();

            if (tamaño == 0) {
                throw new Exception("No existen cuentas en el sistema, El numero de elementos de la lista es: ");
            }

            return tamaño;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import Model.InterfasCrud;
import dominio.Sucursal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Edwin
 */
public class SucursalCrud implements InterfasCrud<Sucursal> {
    private static HashMap<String, Sucursal> sucursales = new HashMap<>();

    public SucursalCrud() {
        this.sucursales = new HashMap<>();
    }
    
    @Override
    public void agregar(Sucursal objeto) throws Exception {
    try {
            if (sucursales.containsKey(objeto.getCodigo())) {
                throw new Exception("La sucursal "+objeto.getNombre() + " ya se encuentra agregado en la base de datos");
            }

            sucursales.put(objeto.getCodigo(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    @Override
    public Sucursal buscar(String codigo) throws Exception {
        try {
            if (!sucursales.containsKey(codigo)) {
                throw new Exception("La sucursal con el codigo "+codigo+" no se encuentra registrado");
            }
            return sucursales.get(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
        
    }

    @Override
    public void editar(Sucursal objeto) throws Exception {
        try {
            if (!sucursales.containsKey(objeto.getCodigo())) {
                throw new Exception("la sucursal "+objeto.getNombre() + " no se encuentra registrado");
            }
            sucursales.put(objeto.getCodigo(), objeto);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {
               try {
            if (!sucursales.containsKey(codigo)) {
                throw new Exception("la sucursal con el codigo "+codigo+" no se encuentra en la base de datos");
            }

            sucursales.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

       
        
    }

    @Override
    public List<Sucursal> listarTodo() throws Exception {
        List<Sucursal> listSucursales = new ArrayList<>();
        try {
            if (sucursales.isEmpty()) {
                throw new Exception("No existen sucursal en el sistema");
            }

            for (Map.Entry<String, Sucursal> parte : sucursales.entrySet()) {
                String codigo = parte.getKey();
                Sucursal sucursal = parte.getValue();

                listSucursales.add(sucursal);
            }
            return listSucursales;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public int contar()throws Exception {
        
        List<Sucursal> numeroDeSucursales = listarTodo();
        
        int tamaño = 0;

        try {

            tamaño = numeroDeSucursales.size();

            if (tamaño == 0) {
                throw new Exception("No existen sucursales en el sistema");
            }

            return tamaño;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}

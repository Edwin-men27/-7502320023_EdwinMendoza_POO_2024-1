/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import dominio.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Model.InterfasCrud;

/**
 *
 * @author Edwin
 */
public class ClienteCrud implements InterfasCrud<Cliente>{
    
    private HashMap<String,Cliente> clientes = new HashMap<>();

    public ClienteCrud() {
        this.clientes = new HashMap<>();
    }

    @Override
    public void agregar(Cliente objeto) throws Exception {
        try {
            if (clientes.containsKey(objeto.getIdentificacion())) {
                throw new Exception("El Cliente "+objeto.getNombre()+" ya se encuentra agregado en el sistema");
            }

            clientes.put(objeto.getIdentificacion(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Cliente buscar(String codigo) throws Exception {
    try {
            if (!clientes.containsKey(codigo)) {
                throw new Exception("El Cliente con el codigo "+codigo+" no se encuentra registrado");
            }
            return clientes.get(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void editar(Cliente objeto) throws Exception {
        
        try {
            if (!clientes.containsKey(objeto.getIdentificacion())) {
                throw new Exception("El Cliente "+objeto.getNombre()+" no se encuentra registrado");
            }
            clientes.put(objeto.getIdentificacion(), objeto);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {
    try {
            if (!clientes.containsKey(codigo)) {
                throw new Exception("El Cliente con el codigo "+codigo+" no se encuentra en la base de datos");
            }

            clientes.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Cliente> listarTodo() throws Exception {
        List<Cliente> listCliente = new ArrayList<>();
        try {
            if (clientes.isEmpty()) {
                throw new Exception("No existen clientes en el sistema");
            }

            for (Map.Entry<String, Cliente> parte : clientes.entrySet()) {
                String codigo = parte.getKey();
                Cliente cliente = parte.getValue();

                listCliente.add(cliente);
            }
            return listCliente;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int contar() throws Exception {
    List<Cliente> numeroDeClientes = listarTodo();
        
        int tamaño =  0; 
        
        try {
            
            tamaño = numeroDeClientes.size();
            
            if (tamaño == 0) {
                throw new Exception("No existen clientes en el sistema");
            }
            
            return tamaño;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
}

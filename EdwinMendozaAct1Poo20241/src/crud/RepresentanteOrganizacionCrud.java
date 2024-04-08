/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import Model.InterfasCrud;
import dominio.RepresentanteOrganizacion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Edwin
 */
public class RepresentanteOrganizacionCrud implements InterfasCrud<RepresentanteOrganizacion> {

    private HashMap<String,RepresentanteOrganizacion> representantes;
    
    public RepresentanteOrganizacionCrud() {
        this.representantes = new HashMap<>();
    }

    @Override
    public void agregar(RepresentanteOrganizacion objeto) throws Exception {
        try {
            if (representantes.containsKey(objeto.getNombre())) {
                throw new Exception("El Representante ya se encuentra agregado en la base de datos");
            }

            representantes.put(objeto.getNombre(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }}

    @Override
    public RepresentanteOrganizacion buscar(String codigo) throws Exception {
        try {
            if (!representantes.containsKey(codigo)) {
                throw new Exception("El Representante no se encuentra registrado");
            }
            return representantes.get(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;}

    @Override
    public void editar(RepresentanteOrganizacion objeto) throws Exception {
        try {
            if (!representantes.containsKey(objeto.getNombre())) {
                throw new Exception("El representante "+objeto.getNombre() + " no se encuentra registrado");
            }
            representantes.put(objeto.getNombre(), objeto);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }}

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!representantes.containsKey(codigo)) {
                throw new Exception("El representante no se encuentra en la base de datos");
            }

            representantes.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<RepresentanteOrganizacion> listarTodo() throws Exception {
        List<RepresentanteOrganizacion> listrepresentantes = new ArrayList<>();
        try {
            if (representantes.isEmpty()) {
                throw new Exception("No existen representantes en el sistema");
            }

            for (Map.Entry<String, RepresentanteOrganizacion> parte : representantes.entrySet()) {
                String codigo = parte.getKey();
                RepresentanteOrganizacion sucursal = parte.getValue();

                listrepresentantes.add(sucursal);
            }
            return listrepresentantes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;}

    @Override
    public int contar() throws Exception {
        List<RepresentanteOrganizacion> numeroRepresentantes = listarTodo();
        int tamaño =  0; 
        
        try {
            
            tamaño = numeroRepresentantes.size();
            
            if (tamaño == 0) {
                throw new Exception("No existen representantes en el sistema");
            }
            
            return tamaño;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;}
   

    
}

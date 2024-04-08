/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import Model.InterfasCrud;
import dominio.Organizacion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Edwin
 */
public class OrganizacionCrud implements InterfasCrud<Organizacion> {

    private HashMap<String, Organizacion> listaOrganizaciones = new HashMap<>();

    public OrganizacionCrud() {
        this.listaOrganizaciones = new HashMap<>();
    }

    
    @Override
    public void agregar(Organizacion objeto) throws Exception {
        try {
            if (listaOrganizaciones.containsKey(objeto.getIdentificacion())) {
                throw new Exception("La Organizacion ya se encuentra agregado en el sistema");
            }

            listaOrganizaciones.put(objeto.getIdentificacion(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Organizacion buscar(String codigo) throws Exception {
        try {
            if (!listaOrganizaciones.containsKey(codigo)) {
                throw new Exception("La Organizacion no se encuentra registrado");
            }
            return listaOrganizaciones.get(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void editar(Organizacion objeto) throws Exception {
        try {
            if (!listaOrganizaciones.containsKey(objeto.getIdentificacion())) {
                throw new Exception("La Organizacion no se encuentra registrado");
            }
            listaOrganizaciones.put(objeto.getIdentificacion(), objeto);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!listaOrganizaciones.containsKey(codigo)) {
                throw new Exception("La Organizacion no se encuentra en la base de datos");
            }

            listaOrganizaciones.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Organizacion> listarTodo() throws Exception {
        List<Organizacion> organizaciones = new ArrayList<>();
        try {
            if (listaOrganizaciones.isEmpty()) {
                throw new Exception("No existen organizaciones en el sistema");
            }

            for (Map.Entry<String, Organizacion> parte : listaOrganizaciones.entrySet()) {
                String codigo = parte.getKey();
                Organizacion organizacion = parte.getValue();

                organizaciones.add(organizacion);
            }
            return organizaciones;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int contar() throws Exception {
        List<Organizacion> organizaciones = listarTodo();
        int tamaño = 0;

        try {

            tamaño = organizaciones.size();

            if (tamaño == 0) {
                throw new Exception("No existen organizaciones en el sistema, El numero de elementos de la lista es: ");
            }

            return tamaño;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

}

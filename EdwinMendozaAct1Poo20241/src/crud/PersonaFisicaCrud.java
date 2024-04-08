/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import Model.InterfasCrud;
import dominio.PersonaFisica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Edwin
 */
public class PersonaFisicaCrud implements InterfasCrud<PersonaFisica> {

    private HashMap<String, PersonaFisica> listaPersonaFisica = new HashMap<>();

    public PersonaFisicaCrud() {
        this.listaPersonaFisica = new HashMap<>();
    }

    @Override
    public void agregar(PersonaFisica objeto) throws Exception {
        try {
            if (listaPersonaFisica.containsKey(objeto.getIdentificacion())) {
                throw new Exception("La Persona ya se encuentra agregado en el sistema");
            }

            listaPersonaFisica.put(objeto.getIdentificacion(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public PersonaFisica buscar(String codigo) throws Exception {
        try {
            if (!listaPersonaFisica.containsKey(codigo)) {
                throw new Exception("La Persona no se encuentra registrado");
            }
            return listaPersonaFisica.get(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void editar(PersonaFisica objeto) throws Exception {
        try {
            if (!listaPersonaFisica.containsKey(objeto.getIdentificacion())) {
                throw new Exception("La Persona no se encuentra registrado");
            }
            listaPersonaFisica.put(objeto.getIdentificacion(), objeto);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!listaPersonaFisica.containsKey(codigo)) {
                throw new Exception("La Persona no se encuentra en la base de datos");
            }

            listaPersonaFisica.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<PersonaFisica> listarTodo() throws Exception {
        List<PersonaFisica> personas = new ArrayList<>();
        try {
            if (listaPersonaFisica.isEmpty()) {
                throw new Exception("No existen personas en el sistema");
            }

            for (Map.Entry<String, PersonaFisica> parte : listaPersonaFisica.entrySet()) {
                String codigo = parte.getKey();
                PersonaFisica persona = parte.getValue();

                personas.add(persona);
            }
            return personas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int contar() throws Exception {
        List<PersonaFisica> personas = listarTodo();
        int tamaño = 0;

        try {

            tamaño = personas.size();

            if (tamaño == 0) {
                throw new Exception("No existen personas en el sistema, El numero de elementos de la lista es: ");
            }

            return tamaño;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

}

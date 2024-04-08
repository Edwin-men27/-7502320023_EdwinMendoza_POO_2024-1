/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import Model.InterfasCrud;
import dominio.Empleado;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Edwin
 */
    public class EmpleadoCrud implements InterfasCrud<Empleado>{

        private HashMap<String, Empleado> listaEmpleado = new HashMap<>();

    public EmpleadoCrud() {
        this.listaEmpleado = new HashMap<>();
    }
        
        
    @Override
    public void agregar(Empleado objeto) throws Exception {
        try {
            if (listaEmpleado.containsKey(objeto.getIdentificacion())) {
                throw new Exception("El empleado ya se encuentra agregado en el sistema");
            }

            listaEmpleado.put(objeto.getIdentificacion(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }}

    @Override
    public Empleado buscar(String codigo) throws Exception {
        try {
            if (!listaEmpleado.containsKey(codigo)) {
                throw new Exception("El empleado no se encuentra registrado");
            }
            return listaEmpleado.get(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;}

    @Override
    public void editar(Empleado objeto) throws Exception {
        try {
            if (!listaEmpleado.containsKey(objeto.getIdentificacion())) {
                throw new Exception("El empleado no se encuentra registrado");
            }
            listaEmpleado.put(objeto.getIdentificacion(), objeto);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }}

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!listaEmpleado.containsKey(codigo)) {
                throw new Exception("El empleado no se encuentra en la base de datos");
            }

            listaEmpleado.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }}

    @Override
    public List<Empleado> listarTodo() throws Exception {
        List<Empleado> empleados = new ArrayList<>();
        try {
            if (listaEmpleado.isEmpty()) {
                throw new Exception("No existen empleados en el sistema");
            }

            for (Map.Entry<String, Empleado> parte : listaEmpleado.entrySet()) {
                String codigo = parte.getKey();
                Empleado empleado = parte.getValue();

                empleados.add(empleado);
            }
            return empleados;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;}

    @Override
    public int contar() throws Exception {
        List<Empleado> empleados = listarTodo();
        int tamaño = 0;

        try {

            tamaño = empleados.size();

            if (tamaño == 0) {
                throw new Exception("No existen empleados en el sistema, El numero de elementos de la lista es: ");
            }

            return tamaño;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;}
    
}

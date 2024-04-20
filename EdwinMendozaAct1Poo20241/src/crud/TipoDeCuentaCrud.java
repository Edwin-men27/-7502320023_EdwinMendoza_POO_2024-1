/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import Model.InterfasCrud;
import dominio.TipoDeCuenta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Edwin
 */
public class TipoDeCuentaCrud implements InterfasCrud<TipoDeCuenta>{
    
    private HashMap<String,TipoDeCuenta> ListaTipoDeCuentas = new HashMap<>();

    public TipoDeCuentaCrud() {
        this.ListaTipoDeCuentas = new HashMap<>();
    }

    @Override
    public void agregar(TipoDeCuenta objeto) throws Exception {
        try {
            if (ListaTipoDeCuentas.containsKey(objeto.getIdentificacion())) {
                throw new Exception("La cuenta "+objeto.getIdentificacion()+" ya se encuentra agregado en el sistema");
            }

            ListaTipoDeCuentas.put(objeto.getIdentificacion(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }}

    @Override
    public TipoDeCuenta buscar(String codigo) throws Exception {
        try {
            if (!ListaTipoDeCuentas.containsKey(codigo)) {
                throw new Exception("La cuenta con el codigo "+codigo+" no se encuentra registrado");
            }
            return ListaTipoDeCuentas.get(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;}

    @Override
    public void editar(TipoDeCuenta objeto) throws Exception {
       try {
            if (!ListaTipoDeCuentas.containsKey(objeto.getIdentificacion())) {
                throw new Exception("La cuenta "+objeto.getIdentificacion()+" no se encuentra registrado");
            }
            ListaTipoDeCuentas.put(objeto.getIdentificacion(), objeto);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }}

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!ListaTipoDeCuentas.containsKey(codigo)) {
                throw new Exception("La cuenta con el codigo "+codigo+" no se encuentra en la base de datos");
            }

            ListaTipoDeCuentas.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }}

    @Override
    public List<TipoDeCuenta> listarTodo() throws Exception {
        List<TipoDeCuenta> tiposDeCuentas = new ArrayList<>();
        try {
            if (ListaTipoDeCuentas.isEmpty()) {
                throw new Exception("No existen Cuentas en el sistema");
            }

            for (Map.Entry<String, TipoDeCuenta> parte : ListaTipoDeCuentas.entrySet()) {
                String codigo = parte.getKey();
                TipoDeCuenta tipoDeCuenta = parte.getValue();

                tiposDeCuentas.add(tipoDeCuenta);
            }
            return tiposDeCuentas;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;}

    @Override
    public int contar() throws Exception {
        List<TipoDeCuenta> tiposDeCuentas = new ArrayList<>();
        int tamaño = 0;

        try {

            tamaño = tiposDeCuentas.size();

            if (tamaño == 0) {
                throw new Exception("No existen Cuentas en el sistema");
            }

            return tamaño;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
}

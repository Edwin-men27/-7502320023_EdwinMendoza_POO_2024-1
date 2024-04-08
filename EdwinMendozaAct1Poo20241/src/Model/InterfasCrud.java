/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author Edwin
 */
public interface InterfasCrud<Dato> {

    public void agregar(Dato objeto)throws Exception;

    public Dato buscar(String codigo)throws Exception;

    public void editar(Dato objeto)throws Exception;

    public void eliminar(String codigo) throws Exception;

    public List<Dato> listarTodo() throws Exception;

    public int contar()throws Exception;
}

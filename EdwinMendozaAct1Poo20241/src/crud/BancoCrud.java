package crud;

import dominio.Banco;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Model.InterfasCrud;

/**
 *
 * @author Edwin
 */
public class BancoCrud implements InterfasCrud<Banco> {

    private HashMap<Integer, Banco> bancos = new HashMap<>();

    public BancoCrud() {
        this.bancos = new HashMap<>();
    }
   

    @Override
    public void agregar(Banco objeto) throws Exception {

        try {
            if (bancos.containsKey(objeto.getId())) {
                throw new Exception("El Banco ya se encuentra agregado en la base de datos");
            }

            bancos.put(objeto.getId(), objeto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Banco buscar(String codigo) throws Exception {

        try {
            if (!bancos.containsKey(codigo)) {
                throw new Exception("El banco no se encuentra registrado");
            }
            return bancos.get(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void editar(Banco objeto) throws Exception {

        try {
            if (!bancos.containsKey(objeto.getId())) {
                throw new Exception("El banco no se encuentra registrado");
            }
            bancos.put(objeto.getId(), objeto);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void eliminar(String codigo) throws Exception {
        try {
            if (!bancos.containsKey(codigo)) {
                throw new Exception("El banco no se encuentra registrado");
            }

            bancos.remove(codigo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Banco> listarTodo() throws Exception {

        List<Banco> ban = new ArrayList<>();
        try {
            if (bancos.isEmpty()) {
                throw new Exception("No existen bancos en el sistema");
            }

            for (Map.Entry<Integer, Banco> parte : bancos.entrySet()) {
                int id = parte.getKey();
                Banco bano = parte.getValue();

                ban.add(bano);
            }
            return ban;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int contar() throws Exception {
        List<Banco> numeroDeBancos = listarTodo();
        
        int tamaño =  0; 
        
        try {
            
            tamaño = numeroDeBancos.size();
            
            if (tamaño == 0) {
                throw new Exception("No existen Bancos en el sistema, El numero de elementos de la lista es: ");
            }
            
            return tamaño;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

}

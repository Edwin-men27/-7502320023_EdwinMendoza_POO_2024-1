package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banco implements Serializable {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String codigoIdentificador;
    
    @Basic
    private String nombre;
    
    @OneToMany (mappedBy = "bancoAfiliado")
    private LinkedList<Sucursal> sucursales= new LinkedList<>();

    public Banco() {

    }

    public Banco(String nombre, String codigoIdentificador) {
        this.nombre = nombre;
        this.codigoIdentificador = codigoIdentificador;
        this.sucursales = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(String identificador) {
        codigoIdentificador = identificador;
    }

    public void agregarSucursal(Sucursal objeto){
        this.sucursales.add(objeto);
    }
    
    public void removerSucursal(Sucursal objeto){
        this.sucursales.remove(objeto);
    }
    
    public LinkedList<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(LinkedList<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    //metodo para convertir un arreglo
    public Vector<String> convertirAVector(){
        Vector<String> datos = new Vector<String>();
        
        datos.addElement(nombre);
        datos.addElement(codigoIdentificador);
        
        List<String> nombreDatos = new ArrayList<>();
        
        for(Sucursal sucursal : sucursales){
            String nombreSucursales = sucursal.getNombre();
            nombreDatos.add(nombreSucursales);
        }
        
        datos.addElement(nombreDatos.toString());
        
        return datos;
    }
}

package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Banco implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    
    @Basic
    private String nombre;
    private String codigoIdentificador;
    
    @OneToMany (mappedBy = "bancoAfiliado")
    private LinkedList<Sucursal> sucursales;

    public Banco() {

    }

    public Banco(int id, String nombre, String codigoIdentificador, LinkedList<Sucursal> sucursales) {
        this.id = id;
        this.nombre = nombre;
        this.codigoIdentificador = codigoIdentificador;
        this.sucursales = sucursales;
    }

    

    public int getId() {
        return id;
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

    public LinkedList<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(LinkedList<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

   

    @Override
    public String toString() {
        return "---------------------------------------------------------------"+
                "\n Datos del Banco" + "\n Nombre: " + nombre
                + "\n Codigo De Identificacion: " + codigoIdentificador
                + "\n Lista de Sucursales: " + sucursales;
    }
}

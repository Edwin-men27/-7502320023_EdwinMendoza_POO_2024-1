package dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class RepresentanteOrganizacion implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Basic
    private String nombre;
    
    @ManyToOne
    private Organizacion organizacionAfiliada;

    public RepresentanteOrganizacion() {

    }

    public RepresentanteOrganizacion(String nombre, Organizacion organizacionAfiliada) {
        this.nombre = nombre;
        this.organizacionAfiliada = organizacionAfiliada;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Organizacion getOrganizacion() {
        return organizacionAfiliada;
    }

    public void setOrganizacion(Organizacion organizacionAfiliada) {
        this.organizacionAfiliada = organizacionAfiliada;
    }

    @Override
    public String toString() {
        return "RepresentanteOrganizacion{" + "nombre=" + nombre + ", organizacionAfiliada=" + organizacionAfiliada + '}';
    }

}

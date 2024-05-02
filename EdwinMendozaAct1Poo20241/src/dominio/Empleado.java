package dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Empleado implements Serializable {

    @Id
    private int id;
    
    @Basic
    private String identificacion;
    private String ciudad;
    private String cargo;
    
    @OneToOne
    private PersonaFisica empleado;
    
    @ManyToOne
    private Sucursal afiliado;

    public Empleado() {

    }

    public Empleado(String identificacion,String ciudad, String cargo, PersonaFisica empleado, Sucursal afiliado) {
        this.identificacion = identificacion;
        this.ciudad = ciudad;
        this.cargo = cargo;
        this.empleado = empleado;
        this.afiliado = afiliado;
    }

    public int getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public PersonaFisica getEmpleado() {
        return empleado;
    }

    public void setEmpleado(PersonaFisica empleado) {
        this.empleado = empleado;
    }

    public Sucursal getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Sucursal afiliado) {
        this.afiliado = afiliado;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    
    @Override
    public String toString() {
        return "Datos De Empleado" + "\n Ciudad=" + ciudad
                + "\n Cargo: " + cargo
                + "\n Empleado: " + empleado
                + "\n Sucursal Afiliado: " + afiliado;
    }

}

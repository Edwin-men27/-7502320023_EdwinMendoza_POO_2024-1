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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    
    @Basic
    protected String nombre;
    protected String identificacion;
    protected String direccion;
    protected float saldo;
    
    @OneToMany (mappedBy = "clienteDueño")
    protected LinkedList<Cuenta> cuentas;

    public Cliente() {

    }

    public Cliente(int id, String nombre, String identificacion, String direccion, float saldo, LinkedList<Cuenta> cuentas) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.saldo = saldo;
        this.cuentas = cuentas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreCliente) {
        this.nombre = nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public LinkedList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(LinkedList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
    @Override
    public String toString() {
        return "Datos DEL Cliente" + "\n Nombre=" + nombre
                + "\n Identificacion=" + identificacion
                + "\n direccion=" + direccion
                + "\n saldo=" + saldo;
    }

}

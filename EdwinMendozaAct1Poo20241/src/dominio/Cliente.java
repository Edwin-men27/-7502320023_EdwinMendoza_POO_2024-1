package dominio;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Column;
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
    protected String clave;
    protected String direccion;
    protected double saldo;
    
    @Column(unique = true)
    protected String identificacion;
    
    @OneToMany (mappedBy = "clienteDueño")
    protected LinkedList<Cuenta> cuentas;

    public Cliente() {

    }

    public Cliente(String nombre,
                    String clave,
                    String identificacion,
                    String direccion,
                    double saldo) {
        this.nombre = nombre;
        this.clave = clave;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.saldo = saldo;
        this.cuentas = new LinkedList<>();// arreglar en la base de dat0s
        
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    public void agregarCuenta(Cuenta objeto){
        this.cuentas.add(objeto);
    }

    public LinkedList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(LinkedList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
    public void agregarCuentas(Cuenta objeto){
        this.cuentas.add(objeto);
    }
    
    public void removeCuentas(Cuenta objeto){
        this.cuentas.remove(objeto);
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", clave=" + clave + ", direccion=" + direccion + ", saldo=" + saldo + ", identificacion=" + identificacion + '}';
    }

    

}

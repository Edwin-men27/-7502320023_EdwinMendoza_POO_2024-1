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
public class Sucursal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Basic
    private String nombre;
    private String codigo;
    private String direccion;
    private String codigoPostal;
    private String informe;
    
    @ManyToOne
    private Banco bancoAfiliado;
    
    @OneToMany (mappedBy = "afiliado")
    private LinkedList<Empleado> empleados;
    
    @OneToMany (mappedBy = "cuentaCreada")
    private LinkedList<Cuenta> cuentas;

    public Sucursal() {

    }

    public Sucursal(int id, String nombre, String codigo, String direccion, String codigoPostal, String informe, Banco bancoAfiliado, LinkedList<Empleado> empleados, LinkedList<Cuenta> cuentas) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.informe = informe;
        this.bancoAfiliado = bancoAfiliado;
        this.empleados = empleados;
        this.cuentas = cuentas;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public Banco getBanco() {
        return bancoAfiliado;
    }

    public void setBanco(Banco banco) {
        this.bancoAfiliado = banco;
    }

    public LinkedList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(LinkedList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public LinkedList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(LinkedList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
    @Override
    public String toString() {
        return "Datos Sucursal" + "\nNombre: " + nombre
                + "\nCodigo: " + codigo
                + "\nDireccion: " + direccion
                + "\nCodigo Postal=" + codigoPostal
                + "\nInforme=" + informe;
    }

}

package dominio;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {

    private int id;
    private String nombre;
    private String codigo;
    private String direccion;
    private String codigoPostal;
    private String informe;
    private Banco banco;
    private List<Empleado> empleados;
    private List<Cuenta> cuentas;

    public Sucursal() {

    }

    public Sucursal(String nombre, String codigo, String direccion, String codigoPostal, String informe, Banco banco, Empleado empleado, Cuenta cuenta) {
        this.codigo = codigo;
        this.codigoPostal = codigoPostal;
        this.direccion = direccion;
        this.informe = informe;
        this.nombre = nombre;
        this.banco = banco;
        this.empleados = new ArrayList<>();
        this.cuentas = new ArrayList<>();
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
        return banco;
    }

    public List<Empleado> getEmpleados() {
        return this.empleados;
    }

    public List<Cuenta> getCuentas() {
        return this.cuentas;
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

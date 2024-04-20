package dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    protected String nombre;
    protected String identificacion;
    protected String direccion;
    protected float saldo;
    protected List<Cuenta> cuentas;

    public Cliente() {

    }

    public Cliente(String nombre, String identificacion, String direccion, float saldo, Cuenta cuenta) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.saldo = saldo;
        this.cuentas =new ArrayList<Cuenta>();
        this.cuentas.add(cuenta);
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

    public List<Cuenta> getCuentas() {
        return this.cuentas;
    }

    public void setCuentas(Cuenta cuenta) {
        this.cuentas = new ArrayList<Cuenta>();
        this.cuentas.add(cuenta);
    }

    
    @Override
    public String toString() {
        return "Datos DEL Cliente" + "\n Nombre=" + nombre
                + "\n Identificacion=" + identificacion
                + "\n direccion=" + direccion
                + "\n saldo=" + saldo;
    }

}

package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Basic
    private String codigoCuentaCliente;
    private float saldoActual;
    private float saldoMedio;
    private float deposito;
    
    @ManyToOne
    private Sucursal cuentaCreada;
    
    @ManyToOne
    private Cliente clienteDueño;
    
    @OneToOne
    private TipoDeCuenta tipoDeCuenta;
    
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;
    
    public Cuenta() {

    }

    public Cuenta(int id, String codigoCuentaCliente, float saldoActual, float saldoMedio, float deposito, Sucursal cuentaCreada, Cliente clienteDueño, TipoDeCuenta tipoDeCuenta, Date fechaApertura) {
        this.id = id;
        this.codigoCuentaCliente = codigoCuentaCliente;
        this.saldoActual = saldoActual;
        this.saldoMedio = saldoMedio;
        this.deposito = deposito;
        this.cuentaCreada = cuentaCreada;
        this.clienteDueño = clienteDueño;
        this.tipoDeCuenta = tipoDeCuenta;
        this.fechaApertura = fechaApertura;
    }

    

    public void setCodigoCuentaCliente(String codigoCuentaCliente) {
        this.codigoCuentaCliente = codigoCuentaCliente;
    }

    public int getId() {
        return id;
    }

    public String getCodigoCuentaCliente() {
        return codigoCuentaCliente;
    }

    public float getSaldoMedio() {
        return saldoMedio;
    }

    public void setSaldoMedio(float saldoMedio) {
        this.saldoMedio = saldoMedio;
    }

    public float getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(float saldoActual) {
        this.saldoActual = saldoActual;
    }

    public float getDeposito() {
        return deposito;
    }

    public void setDeposito(float deposito) {
        this.deposito = deposito;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Cliente getCliente() {
        return clienteDueño;
    }

    public void setCliente(Cliente cliente) {
        this.clienteDueño = cliente;
    }

    public TipoDeCuenta getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(TipoDeCuenta tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public Sucursal getCuentaCreada() {
        return cuentaCreada;
    }

    public void setCuentaCreada(Sucursal cuentaCreada) {
        this.cuentaCreada = cuentaCreada;
    }

    public Cliente getClienteDueño() {
        return clienteDueño;
    }

    public void setClienteDueño(Cliente clienteDueño) {
        this.clienteDueño = clienteDueño;
    }

    
    @Override
    public String toString() {
        return "Datos de Cuenta" + "\nCodigo Cuenta Cliente=" + codigoCuentaCliente
                + "\n Saldo Actual=" + saldoActual
                + "\n Saldo Medio=" + saldoMedio
                + "\n Deposito=" + deposito
                + "\n Fecha De Apertura=" + fechaApertura;
    }

}

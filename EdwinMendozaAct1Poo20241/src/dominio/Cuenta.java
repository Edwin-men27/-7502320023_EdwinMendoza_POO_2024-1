package dominio;

import java.util.Date;

public class Cuenta {

    private int id;
    private String codigoCuentaCliente;
    private float saldoActual;
    private float saldoMedio;
    private float deposito;
    private Date fechaApertura;
    private Cliente cliente;
    private TipoDeCuenta tipoDeCuenta;

    public Cuenta() {

    }

    public Cuenta(float saldoActual, float saldoMedio, float deposito, Date fechaApertura, String codigoCuentaCliente, TipoDeCuenta tipoDeCuenta, Cliente cliente) {
        this.codigoCuentaCliente = codigoCuentaCliente;
        this.fechaApertura = fechaApertura;
        this.saldoActual = saldoActual;
        this.saldoMedio = saldoMedio;
        this.deposito = deposito;
        this.tipoDeCuenta = tipoDeCuenta;
        this.cliente = cliente;
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
        return cliente;
    }

    public TipoDeCuenta getTipoDeCuenta() {
        return tipoDeCuenta;
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

package dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Basic
    private double saldoActual;
    private double saldoMedio;
    private double deposito; // crear ventana
    
    @Column(unique = true) 
    private String codigoCuentaCliente;
    @ManyToOne
    private Sucursal cuentaCreada;
    
    @ManyToOne// campo de lista
    private Cliente clienteDueño;
    
    @ManyToOne
    private TipoDeCuenta tipoDeCuenta;
    
    @Temporal(TemporalType.DATE)
    private Date fechaApertura;
    
    public Cuenta() {

    }

    public Cuenta( String codigoCuentaCliente,
                    double saldoActual,
                    double saldoMedio,
                    double deposito,
                    Sucursal cuentaCreada,
                    Cliente clienteDueño,
                    TipoDeCuenta tipoDeCuenta,
                    Date fechaApertura) {
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

    public double getSaldoMedio() {
        return saldoMedio;
    }

    public void setSaldoMedio(double saldoMedio) {
        this.saldoMedio = saldoMedio;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
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
        return "Cuenta{" + "saldoActual=" + saldoActual + ", saldoMedio=" + saldoMedio + ", deposito=" + deposito + ", codigoCuentaCliente=" + codigoCuentaCliente + ", cuentaCreada=" + cuentaCreada.getNombre() + ", clienteDue\u00f1o=" + clienteDueño.getNombre() + ", tipoDeCuenta=" + tipoDeCuenta.getTipo() + ", fechaApertura=" + fechaApertura + '}';
    }

//    "Dueño","Codigo Identificador","Tipo cuenta", "Sucursal","Saldo actual", "Fecha Creacion"

    public Vector<String> convertirAVector(){
        Vector<String> datos = new Vector<String>();
        
        datos.addElement(codigoCuentaCliente);
        datos.addElement(String.valueOf(saldoActual));
        datos.add(cuentaCreada.getNombre());
        datos.add(tipoDeCuenta.getTipo());
        datos.add(clienteDueño.getNombre());
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
        
        String fecha = formatter.format(fechaApertura);
        datos.add(fecha);
        

        return datos;
    }
}

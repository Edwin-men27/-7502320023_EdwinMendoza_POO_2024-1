package dominio;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoDeCuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Basic()
    private String tipo;
    private String beneficios = "";
    private double porcentajeAmortizacion = 0;
    private double saldoMinimo = 0;
    
    @OneToMany(mappedBy = "tipoDeCuenta")
    private LinkedList<Cuenta> cuentas;

    public TipoDeCuenta() {

    }
    
    public TipoDeCuenta(String tipo, double saldoMinimo) {
        this.tipo = tipo;
        this.saldoMinimo = saldoMinimo;
    }

    public TipoDeCuenta( String tipo, String beneficios, double porcentajeAmortizacion, double saldoMinimo) {
        this.tipo = tipo;
        this.beneficios = beneficios;
        this.porcentajeAmortizacion = porcentajeAmortizacion;
        this.saldoMinimo = saldoMinimo;
        this.cuentas = new LinkedList<>(); // arreglar en la base de dat0s
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public double getPorcentajeAmortizacion() {
        return porcentajeAmortizacion;
    }

    public void setPorcentajeAmortizacion(double porcentajeAmortizacion) {
        this.porcentajeAmortizacion = porcentajeAmortizacion;
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    public void setSaldoMinimo(double saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
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
        return "TipoDeCuenta{" + "tipo=" + tipo + ", beneficios=" + beneficios + ", porcentajeAmortizacion=" + porcentajeAmortizacion + ", saldoMinimo=" + saldoMinimo + '}';
    }

}

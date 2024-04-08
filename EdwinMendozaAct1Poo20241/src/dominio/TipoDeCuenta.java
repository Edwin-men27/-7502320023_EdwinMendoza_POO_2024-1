package dominio;

public class TipoDeCuenta {

    private int id;
    private String identificacion;
    private String nombre;
    private String beneficios;    
    private float porcentajeAmortizacion;
    private float saldoMinimo;

    public TipoDeCuenta() {

    }

    public TipoDeCuenta(String identificacion,String nombre, String beneficios, float porcentajeAmortizacion, float saldoMinimo) {
        this.porcentajeAmortizacion = porcentajeAmortizacion;
        this.nombre = nombre;
        this.beneficios = beneficios;
        this.saldoMinimo = saldoMinimo;
        this.identificacion = identificacion;
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

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public float getPorcentajeAmortizacion() {
        return porcentajeAmortizacion;
    }

    public void setPorcentajeAmortizacion(float porcentajeAmortizacion) {
        this.porcentajeAmortizacion = porcentajeAmortizacion;
    }

    public float getSaldoMinimo() {
        return saldoMinimo;
    }

    public void setSaldoMinimo(float saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "Tipo De Cuenta" + "\n Nombre: " + nombre
                + "\nPorcentaje De Amortizacion: " + porcentajeAmortizacion
                + "\nBeneficios: " + beneficios
                + "\nSaldo Minimo: " + saldoMinimo;
    }

}

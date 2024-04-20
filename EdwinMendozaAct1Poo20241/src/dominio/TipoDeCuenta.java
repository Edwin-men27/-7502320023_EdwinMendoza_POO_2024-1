package dominio;

public class TipoDeCuenta {

    private int id;
    private String identificacion;
    private String tipo;
    private String beneficios;    
    private double porcentajeAmortizacion;
    private float saldoMinimo;

    public TipoDeCuenta() {

    }

    public TipoDeCuenta(String identificacion,String tipo, String beneficios, double porcentajeAmortizacion, float saldoMinimo) {
        this.porcentajeAmortizacion = porcentajeAmortizacion;
        this.tipo = tipo;
        this.beneficios = beneficios;
        this.saldoMinimo = saldoMinimo;
        this.identificacion = identificacion;
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
        return "Tipo De Cuenta" + "\n Nombre: " + tipo
                + "\nPorcentaje De Amortizacion: " + porcentajeAmortizacion
                + "\nBeneficios: " + beneficios
                + "\nSaldo Minimo: " + saldoMinimo;
    }

}

package dominio;

import java.util.List;

public class Organizacion extends Cliente {

    private int id;
    private String tipoOrganizacion;
    private String cantidadEmpleados;
    private String concepto;
    private List<RepresentanteOrganizacion> representantes;

    public Organizacion() {

    }

    public Organizacion(String nombre, String direccion, String identificacion, float saldo, String tipoOrganizacion, String cantidadEmpleados, String concepto, Cuenta cuenta, RepresentanteOrganizacion representantes) {
        super(nombre, identificacion, direccion, saldo, cuenta);
        this.cantidadEmpleados = cantidadEmpleados;
        this.tipoOrganizacion = tipoOrganizacion;
        this.concepto = concepto;
        this.representantes.add(representantes);
    }

    public int getId() {
        return id;
    }

    public String getTipoOrganizacion() {
        return tipoOrganizacion;
    }

    public void setTipoOrganizacion(String tipoOrganizacion) {
        this.tipoOrganizacion = tipoOrganizacion;
    }

    public String getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(String cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public List<RepresentanteOrganizacion> getRepresentantes() {
        return this.representantes;
    }

    @Override
    public String toString() {
        return "Datos De Organizacion"
                + "\n Tipo De Organizacion: " + tipoOrganizacion
                + "\n Cantidad De Empleados: " + cantidadEmpleados
                + "\n Concepto De Organizacion: " + concepto;
    }

}

package dominio;


import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="Cliente_Organizacion")
public class Organizacion extends Cliente {
  
    @Basic
    private String tipoOrganizacion;
    private String cantidadEmpleados;
    private String concepto;
    
    @OneToMany (mappedBy = "organizacionAfiliada")
    private LinkedList<RepresentanteOrganizacion> representantes;

    public Organizacion() {

    }

    public Organizacion(String tipoOrganizacion, String cantidadEmpleados, String concepto, LinkedList<RepresentanteOrganizacion> representantes, int id, String nombre, String identificacion, String direccion, float saldo, LinkedList<Cuenta> cuentas) {
        super(id, nombre, identificacion, direccion, saldo, cuentas);
        this.tipoOrganizacion = tipoOrganizacion;
        this.cantidadEmpleados = cantidadEmpleados;
        this.concepto = concepto;
        this.representantes = representantes;
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

    public LinkedList<RepresentanteOrganizacion> getRepresentantes() {
        return representantes;
    }

    public void setRepresentantes(LinkedList<RepresentanteOrganizacion> representantes) {
        this.representantes = representantes;
    }

    @Override
    public String toString() {
        return "Datos De Organizacion"
                + "\n Tipo De Organizacion: " + tipoOrganizacion
                + "\n Cantidad De Empleados: " + cantidadEmpleados
                + "\n Concepto De Organizacion: " + concepto;
    }

}

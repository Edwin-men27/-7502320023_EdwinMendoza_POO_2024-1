package dominio;


import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Organizacion extends Cliente {
  
    @Basic
    private String tipoOrganizacion;
    private String cantidadEmpleados;
    private String concepto;
    
    @OneToMany (mappedBy = "organizacionAfiliada")
    private LinkedList<RepresentanteOrganizacion> representantes;

    public Organizacion() {

    }

    public Organizacion(
            String tipoOrganizacion,
            String clave, 
            String cantidadEmpleados, 
            String concepto, 
            String nombre, 
            String identificacion, 
            String direccion, 
            double saldo) {
        super( nombre,clave, identificacion, direccion, saldo);
        this.tipoOrganizacion = tipoOrganizacion;
        this.cantidadEmpleados = cantidadEmpleados;
        this.concepto = concepto;
        this.representantes = new LinkedList<>();// arreglar en la base de datos
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
    
    public void agregarRepresentante(RepresentanteOrganizacion objeto){
        this.representantes.add(objeto);
    }

    public LinkedList<RepresentanteOrganizacion> getRepresentantes() {
        return representantes;
    }

    public void setRepresentantes(LinkedList<RepresentanteOrganizacion> representantes) {
        this.representantes = representantes;
    }
    
    public void agregarRepresentantes(RepresentanteOrganizacion objeto){
        this.representantes.add(objeto);
    }
    
    public void removeRepresentantes(RepresentanteOrganizacion objeto){
        this.representantes.remove(objeto);
    }

    @Override
    public String toString() {
        return "Organizacion{" + "tipoOrganizacion=" + tipoOrganizacion + ", cantidadEmpleados=" + cantidadEmpleados + ", concepto=" + concepto + '}';
    }

    

}

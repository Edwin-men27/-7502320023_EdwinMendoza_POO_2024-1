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
public class Empleado extends Cliente{
    
    @Basic
    private String ciudad;
    private String cargo;
    
    private String sexo;
    
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    @ManyToOne
    private Sucursal afiliado;

    public Empleado() {

    }

    public Empleado( 
            String ciudad, 
            String cargo, 
            Sucursal afiliado,
            String sexo, 
            Date fechaNacimiento,
            String nombre, 
            String clave, 
            String identificacion, 
            String direccion, 
            double saldo) {
        super(nombre, clave, identificacion, direccion, saldo);
        this.ciudad = ciudad;
        this.cargo = cargo;
        this.afiliado = afiliado;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Sucursal getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Sucursal afiliado) {
        this.afiliado = afiliado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    

    @Override
    public String toString() {
        return "Empleado{" + ", ciudad=" + ciudad + ", cargo=" + cargo + ", afiliado=" + afiliado.getNombre() + '}';
    }

}

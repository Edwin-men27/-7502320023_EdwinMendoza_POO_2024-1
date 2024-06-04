package dominio;

import java.util.Date;
import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Entity;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PersonaFisica extends Cliente {

    @Basic
    private String sexo;
    
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    public PersonaFisica() {
        super();
    }

    public PersonaFisica(String sexo,
                         Date fechaNacimiento,
                         String nombre,
                         String clave,
                         String identificacion,
                         String direccion,
                         double saldo) {
        super(nombre, clave, identificacion, direccion, saldo);
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
    }

    

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return "PersonaFisica{" + "sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

}

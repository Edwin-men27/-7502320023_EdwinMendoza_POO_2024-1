package dominio;

import java.util.Date;
import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="Cliente_PersonaFisica")
public class PersonaFisica extends Cliente {

    @Basic
    private String sexo;
    
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    public PersonaFisica() {
        super();
    }

    public PersonaFisica(String sexo, Date fechaNacimiento, int id, String nombre, String identificacion, String direccion, float saldo, LinkedList<Cuenta> cuentas) {
        super(id, nombre, identificacion, direccion, saldo, cuentas);
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
        return "Datos Persona Fisica "
                + "\nSexo=" + sexo
                + "\nFecha De Nacimiento: " + fechaNacimiento;
    }

}

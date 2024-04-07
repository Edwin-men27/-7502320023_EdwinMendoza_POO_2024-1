package dominio;

import java.util.Date;

public class PersonaFisica extends Cliente {

    private int id;
    private String sexo;
    private Date fechaNacimiento;

    public PersonaFisica() {
        super();
    }

    public PersonaFisica(String nombre, String identificacion, String direccion, float saldo, Date fechaNacimiento, String sexo, Cuenta cuenta) {
        super(nombre, identificacion, direccion, saldo, cuenta);
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
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

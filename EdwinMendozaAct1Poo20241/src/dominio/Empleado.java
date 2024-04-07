package dominio;

public class Empleado {

    private int id;
    private String ciudad;
    private String cargo;
    private PersonaFisica empleado;
    private Sucursal afiliado;

    public Empleado() {

    }

    public Empleado(String ciudad, String cargo, PersonaFisica empleado, Sucursal afiliado) {
        this.ciudad = ciudad;
        this.cargo = cargo;
        this.empleado = empleado;
        this.afiliado = afiliado;
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

    public PersonaFisica getEmpleado() {
        return empleado;
    }

    public Sucursal getAfiliado() {
        return afiliado;
    }

    @Override
    public String toString() {
        return "Datos De Empleado" + "\n Ciudad=" + ciudad
                + "\n Cargo: " + cargo
                + "\n Empleado: " + empleado
                + "\n Sucursal Afiliado: " + afiliado;
    }

}

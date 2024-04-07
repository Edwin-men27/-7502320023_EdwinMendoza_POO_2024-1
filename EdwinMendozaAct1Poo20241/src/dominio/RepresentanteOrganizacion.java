package dominio;

public class RepresentanteOrganizacion {

    private int id;
    private String nombre;
    private Organizacion organizacion;

    public RepresentanteOrganizacion() {

    }

    public RepresentanteOrganizacion(String nombre, Organizacion organizacion) {
        this.nombre = nombre;
        this.organizacion = organizacion;
    }

    public int getId() {
        return id;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getnombre() {
        return nombre;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    @Override
    public String toString() {
        return "Representante Organizacion" + "\nNombre=" + nombre
                + "\nOrganizacion=" + organizacion;
    }

}

package dominio;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private int id;
    private String nombre;
    private String codigoIdentificador;
    private List<Sucursal> sucursales;

    public Banco() {

    }

    public Banco(String nombre, String CodigoIdentificador, Sucursal sucursal) {
        this.nombre = nombre;
        this.codigoIdentificador = CodigoIdentificador;
        this.sucursales = new ArrayList<Sucursal>();

    }

    public int getId() {
        return id;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(String identificador) {
        codigoIdentificador = identificador;
    }

    public List<Sucursal> getSucursal() {
        return this.sucursales;
    }

    @Override
    public String toString() {
        return "Datos del Banco" + "\n Nombre=" + nombre
                + "\n Codigo De Identificacion" + codigoIdentificador;
    }
}

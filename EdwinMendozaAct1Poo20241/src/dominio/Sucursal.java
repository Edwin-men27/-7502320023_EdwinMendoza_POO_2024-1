package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Sucursal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String nombre;
    private String direccion;
    private String codigoPostal;
    private String informe;
    
    @Column(unique = true)
    private String codigo;
    
    @ManyToOne
    private Banco bancoAfiliado;

    @OneToMany(mappedBy = "afiliado")
    private LinkedList<Empleado> empleados = new LinkedList<>();;

    @OneToMany(mappedBy = "cuentaCreada")
    private LinkedList<Cuenta> cuentas = new LinkedList<>();;

    public Sucursal() {

    }

    public Sucursal(String nombre,
                    String codigo,
                    String direccion,
                    String codigoPostal,
                    String informe,
                    Banco bancoAfiliado) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.informe = informe;
        this.bancoAfiliado = bancoAfiliado;
        this.empleados = new LinkedList<>();
        this.cuentas = new LinkedList<>();
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public Banco getBancoAfiliado() {
        return bancoAfiliado;
    }


    public void setBancoAfiliado(Banco bancoAfiliado) {
        this.bancoAfiliado = bancoAfiliado;
    }

    public LinkedList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(LinkedList<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    public void agregarEmpleados(Empleado objeto){
        this.empleados.add(objeto);
    }
    
    public void removeEmpleados(Empleado objeto){
        this.empleados.remove(objeto);
    }

    public LinkedList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(LinkedList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
    public void agregarCuentas(Cuenta objeto){
        this.cuentas.add(objeto);
    }
    
    public void removeCuentas(Cuenta objeto){
        this.cuentas.remove(objeto);
    }

    @Override
    public String toString() {
        return nombre;
    }    
    
 
    public Vector<String> convertirAVector(){
        Vector<String> datos = new Vector<String>();
        
        datos.addElement(nombre);
        datos.addElement(codigoPostal);
        datos.add(codigo);
        datos.add(direccion);
        datos.add(informe);
        datos.add(bancoAfiliado.getNombre());
        
        List<String> nombreDatos = new ArrayList<>();
        
        for(Empleado empleado : empleados){
            String nombreEmpleado = empleado.getNombre();
            nombreDatos.add(nombreEmpleado);
        }
        
        datos.addElement(nombreDatos.toString());
        
        List<String> nombreDatos2 = new ArrayList<>();
        
        for(Cuenta cuenta : cuentas){
            String cuentaIdentificacion = cuenta.getCodigoCuentaCliente();
            nombreDatos2.add(cuentaIdentificacion);
        }
        
        datos.addElement(nombreDatos2.toString());
        
        return datos;
    }

}

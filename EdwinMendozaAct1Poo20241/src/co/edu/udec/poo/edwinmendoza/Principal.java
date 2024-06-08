package co.edu.udec.poo.edwinmendoza;

import co.edu.udec.poo.edwinmendoza.metodos.BancoMetodosController;
import co.edu.udec.poo.edwinmendoza.metodos.ClienteMetodosController;
import co.edu.udec.poo.edwinmendoza.metodos.CuentaMetodosController;
import co.edu.udec.poo.edwinmendoza.metodos.EmpleadoMetodosController;
import co.edu.udec.poo.edwinmendoza.metodos.OrganizacionMetodosController;
import co.edu.udec.poo.edwinmendoza.metodos.PersonaFisicaMetodosController;
import co.edu.udec.poo.edwinmendoza.metodos.RepresentanteOrganizacionMetodosController;
import co.edu.udec.poo.edwinmendoza.metodos.SucursalMetodosController;
import co.edu.udec.poo.edwinmendoza.metodos.TipoDeCuentaMetodosController;
import co.edu.udec.poo.edwinmendoza.vistas.gui.Login;
import co.edu.udec.poo.edwinmendoza.vistas.gui.VentanaPrincipal;
import java.util.Date;
import java.util.LinkedList;
import dominio.Banco;
import dominio.Cliente;
import dominio.Cuenta;
import dominio.Empleado;
import dominio.Organizacion;
import dominio.PersonaFisica;
import dominio.RepresentanteOrganizacion;
import dominio.Sucursal;
import dominio.TipoDeCuenta;
import javax.swing.JOptionPane;

public class Principal {

    public static BancoMetodosController bancoBd = new BancoMetodosController();
    public static SucursalMetodosController sucursalBd = new SucursalMetodosController();
    public static CuentaMetodosController cuentaBd = new CuentaMetodosController();
    public static EmpleadoMetodosController empleadoBd = new EmpleadoMetodosController();
    public static PersonaFisicaMetodosController personaBd = new PersonaFisicaMetodosController();
    public static OrganizacionMetodosController organizacionBd = new OrganizacionMetodosController();
    public static TipoDeCuentaMetodosController tipoCuentaBd = new TipoDeCuentaMetodosController();
    public static ClienteMetodosController clienteBd = new ClienteMetodosController();
    public static RepresentanteOrganizacionMetodosController representanteBd = new RepresentanteOrganizacionMetodosController();

    public static Cliente clienteSesion = new Cliente();
    
    public static void main(String[] args) throws Exception {
        Login venti = new Login();
        venti.setLocationRelativeTo(null);
        venti.setVisible(true);

    }

    public static Cliente getClienteSesion() {
        return clienteSesion;
    }

    public static void setClienteSesion(Cliente clienteSesion) {
        Principal.clienteSesion = clienteSesion;
    }

    public static void cerrarSesion(){
        Principal.clienteSesion = null;
    }
}

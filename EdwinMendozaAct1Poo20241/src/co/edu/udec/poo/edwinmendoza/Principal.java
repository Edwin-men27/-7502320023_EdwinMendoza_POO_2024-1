
package co.edu.udec.poo.edwinmendoza;
import dominio.Cliente;
import dominio.Cuenta;
import java.util.Date;

import dominio.Empleado;
import dominio.PersonaFisica;
import dominio.TipoDeCuenta;


public class Principal {

    
    public static void main(String[] args) {
        
        Date creacion = new Date(04/04/2024);
        Date fechaNacimiento = new Date(27/04/2005);
        TipoDeCuenta crearCuenta = new TipoDeCuenta();
        Cliente cliente1 = new Cliente(); 
        Cuenta cuenta = new Cuenta(600,600,600,creacion,"1043",crearCuenta,cliente1);
//(String nombre, String identificacion, String direccion, float saldo, Date fechaNacimiento, String sexo, Cuenta cuenta) {
        
        Cliente cliente = new PersonaFisica("edwin","1043671489","el educador",600,fechaNacimiento,"masculino",cuenta);
        
        System.out.println(cliente);
    }
    
}

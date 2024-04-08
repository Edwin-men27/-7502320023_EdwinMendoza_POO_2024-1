
package co.edu.udec.poo.edwinmendoza;
import dominio.Banco;
import dominio.Cliente;
import dominio.Cuenta;
import java.util.Date;

import dominio.Empleado;
import dominio.Organizacion;
import dominio.PersonaFisica;
import dominio.RepresentanteOrganizacion;
import dominio.Sucursal;
import dominio.TipoDeCuenta;


public class Principal {

    
    public static void main(String[] args) {
        
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        
        cliente1.setNombre("Juan");
        cliente1.setIdentificacion("1234567890");
        cliente1.setDireccion("Calle 123");
        cliente1.setSaldo(1500.0f);

        cliente2.setNombre("María");
        cliente2.setIdentificacion("0987654321");
        cliente2.setDireccion("Avenida XYZ");
        cliente2.setSaldo(2000.0f);
        
         Banco banco1 = new Banco();
        Banco banco2 = new Banco();
        
        banco1.setnombre("Banco X");
        banco1.setCodigoIdentificador("123456");

        banco2.setnombre("Banco Y");
        banco2.setCodigoIdentificador("789012");
        
        Cuenta cuenta1 = new Cuenta();
        Cuenta cuenta2 = new Cuenta();
        
        cuenta1.setCodigoCuentaCliente("123456789");
        cuenta1.setSaldoActual(1500.0f);
        cuenta1.setSaldoMedio(1000.0f);
        cuenta1.setDeposito(500.0f);
        cuenta1.setFechaApertura(new Date()); // Utilizando la fecha actual

        cuenta2.setCodigoCuentaCliente("987654321");
        cuenta2.setSaldoActual(2000.0f);
        cuenta2.setSaldoMedio(1200.0f);
        cuenta2.setDeposito(800.0f);
        cuenta2.setFechaApertura(new Date());
        
        Empleado empleado1 = new Empleado();
        Empleado empleado2 = new Empleado();
        
        empleado2.setIdentificacion("0987654321");
        empleado2.setCiudad("Ciudad B");
        empleado2.setCargo("Asistente");
        empleado1.setIdentificacion("1234567890");
        empleado1.setCiudad("Ciudad A");
        empleado1.setCargo("Gerente");
        
        Organizacion organizacion1 = new Organizacion();
        Organizacion organizacion2 = new Organizacion();
        
        organizacion1.setNombre("Empresa A");
        organizacion1.setIdentificacion("1234567890");
        organizacion1.setDireccion("Dirección A");
        organizacion1.setSaldo(50000.0f);
        organizacion1.setTipoOrganizacion("Corporación");
        organizacion1.setCantidadEmpleados("1000");
        organizacion1.setConcepto("Empresa líder en su sector");

        organizacion2.setNombre("Empresa B");
        organizacion2.setIdentificacion("0987654321");
        organizacion2.setDireccion("Dirección B");
        organizacion2.setSaldo(75000.0f);
        organizacion2.setTipoOrganizacion("Pyme");
        organizacion2.setCantidadEmpleados("50");
        organizacion2.setConcepto("Empresa innovadora en tecnología");
        
        PersonaFisica persona1 = new PersonaFisica();
        PersonaFisica persona2 = new PersonaFisica();
        
        persona1.setNombre("Juan Pérez");
        persona1.setIdentificacion("1234567890");
        persona1.setDireccion("Dirección 1");
        persona1.setSaldo(2000.0f);
        persona1.setFechaNacimiento(new Date()); // Utilizando la fecha actual
        persona1.setSexo("Masculino");
        
        persona2.setNombre("María Gómez");
        persona2.setIdentificacion("0987654321");
        persona2.setDireccion("Dirección 2");
        persona2.setSaldo(3000.0f);
        persona2.setFechaNacimiento(new Date()); // Utilizando la fecha actual
        persona2.setSexo("Femenino");
        
        
        
    }
    
}

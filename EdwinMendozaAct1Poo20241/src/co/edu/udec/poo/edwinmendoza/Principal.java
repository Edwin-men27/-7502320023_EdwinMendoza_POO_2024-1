package co.edu.udec.poo.edwinmendoza;

import crud.BancoCrud;
import crud.CuentaCrud;
import crud.EmpleadoCrud;
import crud.OrganizacionCrud;
import crud.PersonaFisicaCrud;
import crud.RepresentanteOrganizacionCrud;
import crud.SucursalCrud;
import crud.TipoDeCuentaCrud;

import dominio.Banco;
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

        //objetos Persona Fisica
        //
        PersonaFisica cliente1 = new PersonaFisica();
        PersonaFisica cliente2 = new PersonaFisica();
        PersonaFisica cliente3 = new PersonaFisica();

        cliente1.setNombre("Juan");
        cliente1.setIdentificacion("1234567890");
        cliente1.setDireccion("Calle 123");
        cliente1.setSaldo(1500.0f);
        cliente1.setFechaNacimiento(new Date(04 / 04 / 1904));
        cliente1.setSexo("Masculino");

        cliente2.setNombre("María");
        cliente2.setIdentificacion("0987654321");
        cliente2.setDireccion("Avenida XYZ");
        cliente2.setSaldo(2000.0f);
        cliente2.setFechaNacimiento(new Date(23 / 03 / 1995));
        cliente2.setSexo("Femenino");

        cliente3.setNombre("Lauren");
        cliente3.setIdentificacion("5432167890");
        cliente3.setDireccion("Avenida ZDE");
        cliente3.setSaldo(2500.0f);
        cliente3.setFechaNacimiento(new Date(07 / 07 / 1980));

        //objetos Banco
        //
        Banco banco1 = new Banco();
        Banco banco2 = new Banco();
        Sucursal sucursal00 = new Sucursal();
        Sucursal sucursal01 = new Sucursal();

        banco1.setNombre("Banco X");
        banco1.setCodigoIdentificador("123456");
        sucursal00.setBanco(banco1);
        sucursal00.setCodigo("5454");
        sucursal00.setCodigoPostal("130001");
        sucursal00.setDireccion("Britania Mz-B Lt-3, Nuevo Bosque, Cartagena");
        sucursal00.setNombre("Sucursal X");
        banco1.setSucursales(sucursal00);

        banco2.setNombre("Banco Y");
        banco2.setCodigoIdentificador("122456");
        sucursal01.setBanco(banco2);
        sucursal01.setCodigo("5353");
        sucursal01.setCodigoPostal("B1636BFDA");
        sucursal01.setDireccion("Calle Falsa 123, Ciudad Autónoma de Buenos Aires, Argentina");
        sucursal01.setNombre("Sucursal y");
        banco2.setSucursales(sucursal00);

        //objetos Cuenta y TipoDeCuenta
        //
        Cuenta cuenta1 = new Cuenta();
        TipoDeCuenta cuenta01 = new TipoDeCuenta();
        Cuenta cuenta2 = new Cuenta();
        TipoDeCuenta cuenta02 = new TipoDeCuenta();

        cuenta1.setCodigoCuentaCliente("121256789");
        cuenta1.setSaldoActual(1500.0f);
        cuenta1.setSaldoMedio(1000.0f);
        cuenta1.setDeposito(500.0f);
        cuenta1.setFechaApertura(new Date(16 / 03 / 2024));
        cuenta1.setCliente(cliente1);
        cuenta01.setTipo("Corriente");
        cuenta01.setBeneficios("No presenta");
        cuenta01.setIdentificacion("121256789");
        cuenta1.setTipoDeCuenta(cuenta01);

        cuenta2.setCodigoCuentaCliente("989854321");
        cuenta2.setSaldoActual(2000.0f);
        cuenta2.setSaldoMedio(1200.0f);
        cuenta2.setDeposito(800.0f);
        cuenta2.setFechaApertura(new Date(03 / 03 / 2023));
        cuenta2.setCliente(cliente2);
        cliente2.setCuentas(cuenta2);
        cuenta02.setBeneficios("Descuentos de 10% en compras");
        cuenta02.setIdentificacion("989854321");
        cuenta02.setTipo("Ahorro");
        cuenta02.setPorcentajeAmortizacion(0.05);
        cuenta02.setSaldoMinimo(1000.0f);

        Empleado empleado1 = new Empleado();
        PersonaFisica empleado01 = new PersonaFisica();
        Empleado empleado2 = new Empleado();
        PersonaFisica empleado02 = new PersonaFisica();

        empleado1.setIdentificacion("0087676321");
        empleado1.setCiudad("Ciudad B");
        empleado1.setCargo("Asistente");
        empleado01.setNombre("Mateo");
        empleado01.setIdentificacion("1454569090");
        empleado01.setDireccion("Calle 1ui");
        empleado01.setSaldo(1200.0f);
        empleado01.setFechaNacimiento(new Date(04 / 05 / 1964));
        empleado01.setSexo("Masculino");
        empleado1.setEmpleado(empleado01);
        empleado1.setAfiliado(sucursal01);

        empleado2.setIdentificacion("1234667890");
        empleado2.setCiudad("Ciudad A");
        empleado2.setCargo("Gerente");
        empleado02.setNombre("Camila");
        empleado02.setIdentificacion("1222566690");
        empleado02.setDireccion("Calle 321");
        empleado02.setSaldo(1000.0f);
        empleado02.setFechaNacimiento(new Date(28 / 02 / 1954));
        empleado02.setSexo("Femenino");
        empleado2.setEmpleado(empleado02);
        empleado2.setAfiliado(sucursal01);

        //objeto Organizacion
        Organizacion organizacion1 = new Organizacion();
        RepresentanteOrganizacion representante1 = new RepresentanteOrganizacion();
        Organizacion organizacion2 = new Organizacion();
        RepresentanteOrganizacion representante2 = new RepresentanteOrganizacion();

        organizacion1.setNombre("Empresa A");
        organizacion1.setIdentificacion("1234567890");
        organizacion1.setDireccion("Dirección A");
        organizacion1.setSaldo(50000.0f);
        organizacion1.setTipoOrganizacion("Corporación");
        organizacion1.setCantidadEmpleados("1000");
        organizacion1.setConcepto("Empresa líder en su sector");
        representante1.setNombre("carlos");
        representante1.setOrganizacion(organizacion1);

        organizacion2.setNombre("Empresa B");
        organizacion2.setIdentificacion("0987654321");
        organizacion2.setDireccion("Dirección B");
        organizacion2.setSaldo(75000.0f);
        organizacion2.setTipoOrganizacion("Pyme");
        organizacion2.setCantidadEmpleados("50");
        organizacion2.setConcepto("Empresa innovadora en tecnología");
        representante2.setNombre("Edwin");
        representante2.setOrganizacion(organizacion2);

        BancoCrud listaBanco = new BancoCrud();
        CuentaCrud listaCuenta = new CuentaCrud();
        EmpleadoCrud listaEmpleado = new EmpleadoCrud();
        OrganizacionCrud listaOrganizacion = new OrganizacionCrud();
        PersonaFisicaCrud listaPersonaFisica = new PersonaFisicaCrud();
        RepresentanteOrganizacionCrud listaRepresentantes =new RepresentanteOrganizacionCrud();
        SucursalCrud listaSucursal = new SucursalCrud();
        TipoDeCuentaCrud listaTipoDeCuenta = new TipoDeCuentaCrud();

        try {
            listaBanco.agregar(banco1);
            listaBanco.agregar(banco2);
            listaSucursal.agregar(sucursal00);
            listaSucursal.agregar(sucursal01);
            listaPersonaFisica.agregar(cliente1);
            listaPersonaFisica.agregar(cliente2);
            listaPersonaFisica.agregar(empleado01);
            listaPersonaFisica.agregar(empleado02);
            listaCuenta.agregar(cuenta1);
            listaCuenta.agregar(cuenta2);
            listaTipoDeCuenta.agregar(cuenta01);
            listaTipoDeCuenta.agregar(cuenta02);
            listaEmpleado.agregar(empleado2);
            listaEmpleado.agregar(empleado1);
            listaOrganizacion.agregar(organizacion1);
            listaOrganizacion.agregar(organizacion2);
            listaRepresentantes.agregar(representante1);
            listaRepresentantes.agregar(representante2);
            
            
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("usamos el metodo buscar");
        
        try {
            
            listaBanco.buscar("123456");
            listaBanco.buscar("12345");
            listaSucursal.buscar("5454");
            listaSucursal.buscar("54545");
            listaPersonaFisica.buscar("00000");
            listaPersonaFisica.buscar("1234567890");
            listaCuenta.buscar("989854321");
            listaCuenta.buscar("989555521");
            listaTipoDeCuenta.buscar("000000001");
            listaTipoDeCuenta.buscar("121256789");
            listaEmpleado.buscar("0087676321");
            listaEmpleado.buscar("0087600001");
            listaOrganizacion.buscar("1234567890");
            listaOrganizacion.buscar("1334567790");
            listaRepresentantes.buscar("carlos");
            listaRepresentantes.buscar("matias");
            

      
       
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         System.out.println("usamos el metodo editar");
         
         banco1.setNombre("Banco Z");
         cuenta02.setSaldoMinimo(1500.0f);
         empleado2.setCargo("Director");
         
        try {
            listaBanco.editar(banco1);
            listaPersonaFisica.editar(cliente3);
            listaTipoDeCuenta.editar(cuenta02);
            listaEmpleado.editar(empleado2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("usamos el metodo eliminar");

        try {
            listaOrganizacion.eliminar("1234567890");
            listaTipoDeCuenta.eliminar("121256789");
            listaRepresentantes.eliminar("Edwin");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("usamos el metodo contar");        
        try {
            System.out.println("El numero de bancos es: "+listaBanco.contar());
            System.out.println("El numero de sucursales es: "+listaSucursal.contar());
            System.out.println("El numero de cuentas es: "+listaCuenta.contar());
            System.out.println("El numero de personas es: "+listaPersonaFisica.contar());
            System.out.println("El numero de organizaciones es: "+listaOrganizacion.contar());
            System.out.println("El numero de Tipo de cuentas es: "+listaTipoDeCuenta.contar());
            System.out.println("El numero de Empleados es: "+listaEmpleado.contar());
            System.out.println("El numero de representantes es: "+listaRepresentantes.contar());
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("usamos el metodo listar todo");
        try {
            System.out.println(listaBanco.listarTodo());
            System.out.println(listaCuenta.listarTodo());
            System.out.println(listaTipoDeCuenta.listarTodo());
            System.out.println(listaSucursal.listarTodo());
            System.out.println(listaEmpleado.listarTodo());
            System.out.println(listaOrganizacion.listarTodo());
            System.out.println(listaPersonaFisica.listarTodo());
            System.out.println(listaRepresentantes.listarTodo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

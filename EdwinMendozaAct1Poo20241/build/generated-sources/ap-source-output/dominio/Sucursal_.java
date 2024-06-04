package dominio;

import dominio.Banco;
import dominio.Cuenta;
import dominio.Empleado;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-02T11:44:29", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile SingularAttribute<Sucursal, Banco> bancoAfiliado;
    public static volatile SingularAttribute<Sucursal, String> codigo;
    public static volatile SingularAttribute<Sucursal, String> codigoPostal;
    public static volatile SingularAttribute<Sucursal, String> direccion;
    public static volatile SingularAttribute<Sucursal, String> informe;
    public static volatile ListAttribute<Sucursal, Cuenta> cuentas;
    public static volatile ListAttribute<Sucursal, Empleado> empleados;
    public static volatile SingularAttribute<Sucursal, Integer> id;
    public static volatile SingularAttribute<Sucursal, String> nombre;

}
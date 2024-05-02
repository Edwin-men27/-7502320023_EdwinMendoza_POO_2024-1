package dominio;

import dominio.Cliente;
import dominio.Sucursal;
import dominio.TipoDeCuenta;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-30T22:24:18", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, Date> fechaApertura;
    public static volatile SingularAttribute<Cuenta, Cliente> clienteDueño;
    public static volatile SingularAttribute<Cuenta, Float> saldoMedio;
    public static volatile SingularAttribute<Cuenta, Sucursal> cuentaCreada;
    public static volatile SingularAttribute<Cuenta, TipoDeCuenta> tipoDeCuenta;
    public static volatile SingularAttribute<Cuenta, Float> deposito;
    public static volatile SingularAttribute<Cuenta, Integer> id;
    public static volatile SingularAttribute<Cuenta, String> codigoCuentaCliente;
    public static volatile SingularAttribute<Cuenta, Float> saldoActual;

}
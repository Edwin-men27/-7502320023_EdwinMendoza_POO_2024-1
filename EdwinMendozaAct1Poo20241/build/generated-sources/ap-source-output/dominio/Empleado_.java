package dominio;

import dominio.PersonaFisica;
import dominio.Sucursal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-30T22:24:18", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, PersonaFisica> empleado;
    public static volatile SingularAttribute<Empleado, String> ciudad;
    public static volatile SingularAttribute<Empleado, Sucursal> afiliado;
    public static volatile SingularAttribute<Empleado, String> identificacion;
    public static volatile SingularAttribute<Empleado, Integer> id;
    public static volatile SingularAttribute<Empleado, String> cargo;

}
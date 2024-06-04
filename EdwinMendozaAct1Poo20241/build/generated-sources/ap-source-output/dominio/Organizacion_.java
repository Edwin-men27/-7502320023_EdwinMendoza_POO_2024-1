package dominio;

import dominio.RepresentanteOrganizacion;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-02T11:44:30", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Organizacion.class)
public class Organizacion_ extends Cliente_ {

    public static volatile ListAttribute<Organizacion, RepresentanteOrganizacion> representantes;
    public static volatile SingularAttribute<Organizacion, String> concepto;
    public static volatile SingularAttribute<Organizacion, String> cantidadEmpleados;
    public static volatile SingularAttribute<Organizacion, String> tipoOrganizacion;

}
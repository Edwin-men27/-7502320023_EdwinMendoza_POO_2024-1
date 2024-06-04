package dominio;

import dominio.Sucursal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-02T11:44:29", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Banco.class)
public class Banco_ { 

    public static volatile ListAttribute<Banco, Sucursal> sucursales;
    public static volatile SingularAttribute<Banco, String> codigoIdentificador;
    public static volatile SingularAttribute<Banco, String> nombre;

}
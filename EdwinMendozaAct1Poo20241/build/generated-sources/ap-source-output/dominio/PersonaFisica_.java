package dominio;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-02T11:44:30", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(PersonaFisica.class)
public class PersonaFisica_ extends Cliente_ {

    public static volatile SingularAttribute<PersonaFisica, Date> fechaNacimiento;
    public static volatile SingularAttribute<PersonaFisica, String> sexo;

}
package dominio;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-30T22:24:17", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(TipoDeCuenta.class)
public class TipoDeCuenta_ { 

    public static volatile SingularAttribute<TipoDeCuenta, String> tipo;
    public static volatile SingularAttribute<TipoDeCuenta, String> identificacion;
    public static volatile SingularAttribute<TipoDeCuenta, Float> saldoMinimo;
    public static volatile SingularAttribute<TipoDeCuenta, Integer> id;
    public static volatile SingularAttribute<TipoDeCuenta, Double> porcentajeAmortizacion;
    public static volatile SingularAttribute<TipoDeCuenta, String> beneficios;

}
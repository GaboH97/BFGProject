package SuscriptionModule.products;

import SuscriptionModule.Utils.Utils;
import java.math.BigDecimal;

/**
 *
 * @author Cesar Cardozo, Gabriel Amaya
 * Descripción: Clase concreta que extiende de la clase Suscripción la cual tiene por herencia acceso a
                los métodos de la interfaz IsuscriptionData. Esta clase contiene la información referente a
                las suscripciones mensuales.
 */
public class MonthlySuscription extends Suscription {
    
    /**
    * Atributo que refiere a un enumerado que contiene los tipos de suscripción mensual
    */
    private MonthlySuscritionType mst;
    
    /*
    * @param Valor de enumerado que orrespondiente al tipo de suscripción mensual.
    * Constructor de la clase que recibe como parámetro un valor de enumerado correspondiente al tipo de
    * suscripción mensual.
    */
    public MonthlySuscription(MonthlySuscritionType mst) {
        this.mst = mst;
    }
    
    /**
    * @return Precio de la suscripción de acuerdo al tipo de suscripción mensual.
    */
    @Override
    public BigDecimal getPrice() {
        switch (mst.valueOf(mst.name())) {
            case SPINNING:
                return Utils.MONTHLY_SUSCRIPTION_SPINNING_BASIC_PRICE;
            case WEIGHTLIFINTG:
                return Utils.MONTHLY_SUSCRIPTION_BASIC_PRICE;
            case ALL:
                return Utils.MONTHLY_SUSCRIPTION_ALL_BASIC_PRICE;
        }
        return null;
    }
    
     /**
    * @return Descripción de la suscripción de acuerdo al tipo de suscripción mensual.
    */
    @Override
    public String getDescription() {
        switch (mst.valueOf(mst.name())) {
            case SPINNING:
                return Utils.MONTHLY_SUSCRIPTION_SPINNING_DESCRIPTION;
            case WEIGHTLIFINTG:
                return Utils.MONTHLY_SUSCRIPTION_DESCRIPTION;
            case ALL:
                return Utils.MONTHLY_SUSCRIPTION_ALL_DESCRIPTION;
        }
        return null;
    }
    
     /**
    * @return Nombre de la suscripción de acuerdo al tipo de suscripción mensual.
    */
    @Override
    public String getName() {
        return Utils.MONTHLY_SUSCRIPTION_NAME;
    }
}

package SuscriptionModule.decorators;

import SuscriptionModule.Utils.Utils;
import SuscriptionModule.products.ISuscriptionData;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Cesar Cardozo, Gabriel Amaya
 * Description: decorator para susripciones mensuales en el que deacuerdo a 
 * la cantidad de meses se dara un descuento y saldra mas economico que comprar
 * la misma cantidad pero de una en una
 */
public class MontlyPayment extends Decorator {

    /**
    *
    * dictara el numero de meses que se desean adquirir para una mensualidad, 
    * este pordra ser 2, 3, 6, 12, o 0 para referirce a una suscripcion mensual pero
    * que solo comprenda 15 dias.
    */
    private int monthAmount;

    /**
    *
    * @param mountAmount: dicta la cantidad de meses que se desean adquirr
    */
    public MontlyPayment(ISuscriptionData isuscriptionM, int monthAmount) {
        super(isuscriptionM);
        this.monthAmount = monthAmount;
    }

    /**
    *
    * @return: retorna el nombre de la suscripcion deacuerdo a la cantidad de meses
    * deseados en monthAmount, en caso de ser 0 se refiere a 15 dias.
    */
    @Override
    public String getName() {
        switch (monthAmount) {
            case 0:
                return Utils.HALF_MONTH_MP_NAME;
            case 2:
                return Utils.TWO_MONTH_MP_NAME;
            case 3:
                return Utils.THREE_MONTH_MP_NAME;
            case 6:
                return Utils.SIX_MONTH_MP_NAME;
            case 12:
                return Utils.ONE_YEAR_MP_NAME;
            default:
                return Utils.ERROR_MESSAGE;
        }
    }
    
    /**
    *
    * @return: retorna el precio de la suscripcion deacuerdo a la cantidad de mesese
    * deseados en monthAmount, para esto les aplica el ratio de descuento deacuerdo a
    * la cantidad y este resultado lo multiplica por el monthAmount para obtener el
    * precio final del paquete de meses que se desea adquirir
    */
    @Override
    public BigDecimal getPrice() {
        BigDecimal bd = super.getPrice();
        switch (monthAmount) {
            case 0:
                return ((bd.multiply(Utils.X1_2MONTH_RATIO)).divide(new BigDecimal(2))).setScale(1, RoundingMode.HALF_UP);
            case 2:
                bd = bd.multiply(Utils.X2MONTH_RATIO);
                break;
            case 3:
                bd = bd.multiply(Utils.X3MONTH_RATIO);
                break;
            case 6:
                bd = bd.multiply(Utils.X6MONTH_RATIO);
                break;
            case 12:
                bd = bd.multiply(Utils.X12MONTH_RATIO);
                break;
        }
        bd = bd.multiply(new BigDecimal(monthAmount));
        return bd.setScale(1, RoundingMode.HALF_UP);
    }
    
    /**
    *
    * @return: retorna la descripcion de la suscripcion deacuerdo a la cantidad de meses
    * deseados en monthAmount, en caso de ser 0 se refiere a 15 dias.
    */
    @Override
    public String getDescription() {
        String desc = super.getDescription();
        switch (monthAmount) {
             case 0:
                desc += Utils.HALF_MONTH_MP_DESCRIPTION;
                break;
            case 2:
                desc += Utils.TWO_MONTH_MP_DESCRIPTION;
                break;
            case 3:
                desc += Utils.THREE_MONTH_MP_DESCRIPTION;
                break;
            case 6:
                desc += Utils.SIX_MONTH_MP_DESCRIPTION;
                break;
            case 12:
                desc += Utils.ONE_YEAR_MP_DESCRIPTION;
                break;
        }
        return desc;
    }
}

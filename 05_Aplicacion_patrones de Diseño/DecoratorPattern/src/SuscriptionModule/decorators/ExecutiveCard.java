package SuscriptionModule.decorators;

import SuscriptionModule.Utils.Utils;
import SuscriptionModule.products.ISuscriptionData;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Cesar Cardozo, Gabriel Amaya
 * Description: realizacion de una clase decorator para una tarjeta ejecutiva
 * que sera la agrupacion de diferentes sessiones en paquetes para disminuir
 * su precio.
 */
public class ExecutiveCard extends Decorator {

    /**
    *
    * dictara el numero de sesiones que tendra la tarjeta ejecutiva, esta podra ser
    * de 5, 10, 15, 20, 30.
    */
    private int sessionAmount;

    public ExecutiveCard(ISuscriptionData isuscriptionM, int sessionAmount) {
        super(isuscriptionM);
        this.sessionAmount = sessionAmount;
    }

    /**
    *
    * @return: retorna el nombre de la tarjeta ejecutiva deacuerdo a al numero de 
    * sesiones introducido, deacuerdo al atrib sessionAmount.
    */
    @Override
    public String getName() {
        switch (sessionAmount) {
            case 5:
                return Utils.X5CARD_NAME;
            case 10:
                return Utils.X10CARD_NAME;
            case 15:
                return Utils.X15CARD_NAME;
            case 20:
                return Utils.X20CARD_NAME;
            case 30:
                return Utils.X30CARD_NAME;
            default:
                return Utils.ERROR_MESSAGE;
        }
    }
    
     /**
    *
    * @return: retorna la descripcion de la tarjeta ejecutiva deacuerdo a al numero de 
    * sesiones introducido, deacuerdo al atrib sessionAmount.
    */
    @Override
    public String getDescription() {
        switch (sessionAmount) {
            case 5:
                return Utils.X5CARD_DESCRITION;
            case 10:
                return Utils.X10CARD_DESCRITION;
            case 15:
                return Utils.X15CARD_DESCRITION;
            case 20:
                return Utils.X20CARD_DESCRITION;
            case 30:
                return Utils.X30CARD_DESCRITION;
            default:
                return Utils.ERROR_MESSAGE;
        }
    }

    /**
    *
    * @return: retorna el precio de la tarjeta ejecutiva deacuerdo a al numero de 
    * sesiones introducido, al precio base de una sesion se le multiplica por el
    * ratio de conversion dictado por el tipo de tarjeta y se multiplica por el 
    * numero de sesiones introducido
    */
    @Override
    public BigDecimal getPrice() {
        BigDecimal bd = super.getPrice();
        switch (sessionAmount) {
            case 5:
                bd = bd.multiply(Utils.X5CARD_RATIO);
                break;
            case 10:
                bd = bd.multiply(Utils.X10CARD_RATIO);
                break;
            case 15:
                bd.multiply(Utils.X15CARD_RATIO);
                break;
            case 20:
                bd.multiply(Utils.X20CARD_RATIO);
                break;
            case 30:
                bd.multiply(Utils.X30CARD_RATIO);
                break;
        }
        bd = bd.multiply(new BigDecimal(sessionAmount));
        return bd.setScale(1, RoundingMode.HALF_UP);
    }

}

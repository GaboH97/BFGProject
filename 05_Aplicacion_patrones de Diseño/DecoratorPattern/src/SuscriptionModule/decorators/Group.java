package SuscriptionModule.decorators;

import SuscriptionModule.Utils.Utils;
import SuscriptionModule.products.ISuscriptionData;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Cesar Cardozo, Gabriel Amaya decorator para una suscripcion a la que se 
 * le aplica el beneficio de suscripcion en grupo, lo que le da un descuento al 
 * precio final, dictado por el ratio de conversion para grupos.
 */
public class Group extends Decorator {

    public Group(ISuscriptionData isuscriptionM) {
        super(isuscriptionM);
    }

    @Override
    public String getName() {
        return super.getName() + Utils.GROUP_NAME;
    }

    @Override
    public BigDecimal getPrice() {
        return (super.getPrice().multiply(Utils.GROUP_RATIO)).setScale(1, RoundingMode.HALF_UP);//escala el precio con una precicion de 0.1 redondeandolo a la sig unidad despues de 0.5
    }
}

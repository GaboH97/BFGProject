package SuscriptionModule.decorators;

import SuscriptionModule.Utils.Utils;
import SuscriptionModule.products.ISuscriptionData;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Cesar Cardozo, Gabriel Amaya
 * Description: describe una modificacion a un tipo de suscripcion en la que el servicio
 * es personalizado por tanto mas costoso
 */
public class Personal extends Decorator {

    public Personal(ISuscriptionData isuscriptionM) {
        super(isuscriptionM);
    }

    @Override
    public String getName() {
        return super.getName() + Utils.PERSONAL_NAME;
    }

    @Override
    public BigDecimal getPrice() {
        return (super.getPrice().multiply(Utils.PERSONAL_RATIO)).setScale(1, RoundingMode.HALF_UP);//redonde al resultado si la parte decimal supera .5
    }
}

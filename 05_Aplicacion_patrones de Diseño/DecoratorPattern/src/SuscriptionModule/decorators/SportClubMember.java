package SuscriptionModule.decorators;

import SuscriptionModule.Utils.Utils;
import SuscriptionModule.products.ISuscriptionData;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Cesar Cardozo, Gabriel Amaya
 * Description: describe una modificacion a un tipo de suscripcion en la que el intere
 * sado en suscribirse pertenese a algun club deportivo, lo que le da un descuento en
 * el precio final dictado deacuerdo al ratio de descuento para un miembro de club deportivo
 */
public class SportClubMember extends Decorator {

    public SportClubMember(ISuscriptionData isuscriptionM) {
        super(isuscriptionM);
    }

    @Override
    public String getName() {
        return super.getName() + Utils.SPORT_CLUB_MEMBER_NAME;
    }

    @Override
    public BigDecimal getPrice() {
        return (super.getPrice().multiply(Utils.SPORT_CLUB_MEMBER_RATIO)).setScale(1, RoundingMode.HALF_UP);//redondea el resultado si la parte decimal es mayor a 0.5
    }
}

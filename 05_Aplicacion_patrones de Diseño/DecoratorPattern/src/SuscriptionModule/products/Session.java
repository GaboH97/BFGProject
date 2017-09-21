package SuscriptionModule.products;

import SuscriptionModule.Utils.Utils;
import java.math.BigDecimal;

/**
 *
 * @author Cesar Cardozo, Gabriel Amaya
 * clase concreta de un producto sesion que describe una sesion de ejercicio y su costo
 */
public class Session extends Suscription{

    @Override
    public BigDecimal getPrice() {
        return Utils.BASIC_SESSION_PRICE;
    }

    @Override
    public String getDescription() {
        return Utils.SESION_BASICA_DE_EJERCICIO_DESCRIPCION;
    }

    @Override
    public String getName() {
        return Utils.SESION_NAME;
    }
}
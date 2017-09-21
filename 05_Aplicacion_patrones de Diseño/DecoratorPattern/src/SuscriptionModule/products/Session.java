package SuscriptionModule.products;

import SuscriptionModule.Utils.Utils;
import java.math.BigDecimal;

/**
 *
 * @author Cesar Cardozo, Gabriel Amaya
 * Descripción:clase concreta que extiende de la clase padre Suscription la cual tiene por herencia acceso a
                los métodos de la interfaz IsuscriptionData y los implementa
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

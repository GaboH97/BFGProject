package SuscriptionModule.decorators;

import SuscriptionModule.products.ISuscriptionData;
import java.math.BigDecimal;
/**
 *
 * @author Cesar Cardozo, Gabriel Amaya 
 * clase padre decorator encargada de extender a sus hijos
 */
public abstract class Decorator implements ISuscriptionData{

    /**
    *
    * relacion de asociacion con la interfaz iSuscriptionData
    *
    */
    public ISuscriptionData isuscriptionM;

    /**
    *
    * constructor de la clase abstracta decorator en la que entra una implementacion de la interfaz
    */
    public Decorator(ISuscriptionData isuscriptionM) {
        this.isuscriptionM = isuscriptionM;
    }

    @Override
    public BigDecimal getPrice() {
        return isuscriptionM.getPrice();
    }

    @Override
    public String getDescription() {
        return isuscriptionM.getDescription();
    }

    @Override
    public String getName() {
        return isuscriptionM.getName();
    }    
}

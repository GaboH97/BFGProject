package SuscriptionModule.decorators;

import SuscriptionModule.products.ISuscriptionData;
import java.math.BigDecimal;
/**
 *
 * @author Cesar Cardozo, Gabriel Amaya
 */
public abstract class Decorator implements ISuscriptionData{

    public ISuscriptionData isuscriptionM;

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
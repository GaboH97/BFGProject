package SuscriptionModule.products;

import java.math.BigDecimal;

/**
 *
 * @author Cesar Cardozo, Gabriel Amaya
 * interfaz abuelo utilizada en el patron decorator
 */ 
public interface ISuscriptionData {
    /**
     * 
     * @return precio final de la suscripcion
     */
    public BigDecimal getPrice();
    
    public String getDescription();
    public String getName();
}
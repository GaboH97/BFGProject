package SuscriptionModule.products;

import java.math.BigDecimal;

/**
 *
 * @author Cesar Cardozo, Gabriel Amaya
 * Interfaz abuelo que sirve de enlace entre los decoradores y los productos en el patron decorator
 */ 
public interface ISuscriptionData {
    /**
     * 
     * @return precio final de la suscripcion
     */
    public BigDecimal getPrice();
    /**
     * 
     * @return Descripción completa de la suscripción
     */
    public String getDescription();
    /**
     * 
     * @return Nombre completo de la suscripción
     */
    public String getName();
}

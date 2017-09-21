
package SuscriptionModule.products;

import java.math.BigDecimal;

/**
 *
 * @author Cesar Cardozo, Gabriel Amaya
 * 
 * Descripción: Clase abstracta que define los atributos básicos de una suscripción para ser modificados por sus clases hijas
 */
public abstract class Suscription implements ISuscriptionData{
    
    public BigDecimal price;
    public String Name;
    public String description;
    
}

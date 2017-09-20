package products;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: concrete product of the aerobics factory
 */
public class Insanity extends Aerobics{
    
    @Override
    public String getId() {
        return super.getId() + " - " + new String("1 ");
    }
     
    @Override
    public String getName() {
        return super.getName() + "Insanity ";
    }
    @Override
    public String getDescription() {
        return super.getDescription() + Utils.INSANITY_DESCRIPTION; 
    }
}
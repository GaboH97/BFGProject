package products;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: concrete product of the aerobics factory
 */
public class Yoga extends Aerobics{

    @Override
    public String getId() {
        return super.getId() + " - " + new String("3 ");
    }
    
    @Override
    public String getName() {
        return super.getName() + "Yoga ";
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + Utils.YOGA_DESCRIPTION;
    }
}
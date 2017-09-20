package products;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: concrete product of the aerobics factory
 */
public class Steps extends Aerobics{

     @Override
    public String getId() {
        return super.getId() + " - " + new String("2 ");
    }
    
    @Override
    public String getName() {
        return super.getName() + "Steps ";
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + Utils.STEPS_DESCRIPTION;
    }
}
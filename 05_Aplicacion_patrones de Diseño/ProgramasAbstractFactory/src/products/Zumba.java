package products;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: concrete product of the dance factory
 */
public class Zumba extends Dance{

     @Override
    public String getId() {
        return super.getId() + " - 2 ";
    }

    @Override
    public String getName() {
        return super.getName() + "Zumba: ";
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + Utils.ZUMBA_DESCRIPTION;
    }
}
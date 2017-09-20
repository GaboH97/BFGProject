package products;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: concrete product of the dance factory
 */
public class Rumba extends Dance{

     @Override
    public String getId() {
        return super.getId() + " - 1 ";
    }
@Override
    public String getName() {
        return super.getName() + "Rumba ";
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() +  Utils.RUMBA_DESCRIPTION;
    }
}
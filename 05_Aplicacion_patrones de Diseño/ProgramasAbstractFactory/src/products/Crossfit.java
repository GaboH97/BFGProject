package products;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: concrete product of the strengh training factory
 */
public class Crossfit extends StrenghTranning{

     @Override
    public String getId() {
        return super.getId() + " - 2 ";
    }

    @Override
    public String getName() {
        return super.getName() + "Crossfit ";
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + Utils.CROSSFIT_DESCRIPTION;
    }
}
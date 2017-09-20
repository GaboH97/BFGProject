package products;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: concrete product of the strengh training factory
 */
public class BodyBuilding extends StrenghTranning{

    @Override
    public String getId() {
        return super.getId() + " - 1 ";
    }

    @Override
    public String getName() {
        return super.getName() + "Body building ";
    }
    
    
    @Override
    public String getDescription() {
        return super.getDescription() + Utils.BODY_BUILDING_DESCRIPTION;
    }
}
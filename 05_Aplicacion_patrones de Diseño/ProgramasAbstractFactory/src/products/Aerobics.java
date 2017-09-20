package products;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: The father class that inherits the basic attributes of an
 * aerobics program to their children classes
 */
public abstract class Aerobics extends Program{

    private boolean useSteps;

    @Override
    public String getId() {
        return super.getId() + " - " + new String("1");
    }

    public boolean isUseSteps() {
        return useSteps;
    }

    public void setUseSteps(boolean useSteps) {
        this.useSteps = useSteps;
    }
    
    public String useEteps(){
        return useSteps?Utils.YES:Utils.NO;
    }

    @Override
    public String getDescription() {
        return Utils.AEROBICS_DESCRIPTION;
    }
}
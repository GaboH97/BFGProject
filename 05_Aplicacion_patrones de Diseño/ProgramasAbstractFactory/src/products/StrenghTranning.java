package products;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: The GodFather class that inherits the basic attributes of a strengh related
 * program to their children classes
 */
public abstract class StrenghTranning extends Program{

    private int numberSeries;
    private int numberRepetitions;

     @Override
    public String getId() {
        return super.getId() + " - 3";
    }
    
    public int getNumberSeries() {
        return numberSeries;
    }

    public void setNumberSeries(int numberSeries) {
        this.numberSeries = numberSeries;
    }

    public int getNumberRepetitions() {
        return numberRepetitions;
    }

    public void setNumberRepetitions(int numberRepetitions) {
        this.numberRepetitions = numberRepetitions;
    }

    @Override
    public String getDescription() {
        return Utils.STRENGH_TRAINNING_DESCRIPTION;
    }
}
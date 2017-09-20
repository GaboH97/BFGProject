package products;

import java.util.List;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: The Father class that inherits the basic attributes of a dance related
 * program to their children classes
 */
public abstract class Dance extends Program{

    private List<String> typeMusic;

    @Override
    public String getId() {
        return super.getId() + " - 2";
    }


    
    public List<String> getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(List<String> typeMusic) {
        this.typeMusic = typeMusic;
    }

    @Override
    public String getDescription() {
        return Utils.DANCE_DESCRIPTION;
    }
}
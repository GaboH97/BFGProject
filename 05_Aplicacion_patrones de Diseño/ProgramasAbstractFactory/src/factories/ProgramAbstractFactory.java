package factories;

import products.Program;
import products.Utils;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: The GodFather class that inherits the basic attributes of a
 * program to their children classes
 */
public abstract class ProgramAbstractFactory {
    
    /**
     * 
     * @param type
     * @return An instance of a raw program according to the given parameters
     * @throws Exception when no existing type of program matches with the input
     *         value.
     */
    public abstract Program createProgram(String type) throws Exception;
    
    /**
     * 
     * @param factoryType
     * @return An instance of a concrete Factory according to the given parameters
     * @throws Exception when no existing type of program matches with the input
     *         value.
     */
    public static ProgramAbstractFactory getFactory(String factoryType) throws Exception {
        switch (factoryType) {
            case Utils.CASE_AEROBICS_FACTORY:
                return new AerobicsFactory();
            case Utils.CASE_DANCE_STYLE_FACTORY:
                return new DanceStyleFactory();
            case Utils.CASE_STRENGHT_TRAINNING_FACTORY:
                return new StrenghTranningFactory();
            default:
                throw new Exception(Utils.ERROR_NO_EXISTS_FACTORY);
        }
    }
}
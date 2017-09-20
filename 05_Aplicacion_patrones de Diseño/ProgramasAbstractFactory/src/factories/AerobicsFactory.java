package factories;

import products.Insanity;
import products.Program;
import products.Steps;
import products.Utils;
import products.Yoga;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: A concrete factory that extends from the abstract factory
 *              which creates Aerobics-related programs 
 */
public class AerobicsFactory extends ProgramAbstractFactory{
    
    /**
     * 
     * @param type selects wich type of Aerobic related program will return
     * it depends on the constant used;
     * @return 
     * @throws Exception when there is no results
     */
    @Override
    public Program createProgram(String type) throws Exception{
        switch (type){
            case Utils.CASE_INSANITY:
                return new Insanity();
            case Utils.CASE_STEPS:
                return new Steps();
            case Utils.CASE_YOGA:
                return new Yoga();
            default:
                throw new Exception(Utils.ERROR_NO_EXISTS_PROGRAM);
        }
    }
}
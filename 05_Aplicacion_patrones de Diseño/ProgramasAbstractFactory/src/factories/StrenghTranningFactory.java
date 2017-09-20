package factories;

import products.BodyBuilding;
import products.Crossfit;
import products.Program;
import products.Utils;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: The GodFather class that inherits the basic attributes of a
 * program to their children classes
 */
public class StrenghTranningFactory extends ProgramAbstractFactory{

    /**
     * 
     * @param tipo dictates the tipe of program to be returned
     * @return
     * @throws Exception 
     */
    @Override
    public Program createProgram(String tipo) throws Exception{
        switch (tipo){
            case Utils.CASE_CROSSFIT:
                return new Crossfit();
            case Utils.CASE_BODY_BUILDING:
                return new BodyBuilding();
            default:
                throw new Exception(Utils.ERROR_NO_EXISTS_PROGRAM);
        }
    }
}
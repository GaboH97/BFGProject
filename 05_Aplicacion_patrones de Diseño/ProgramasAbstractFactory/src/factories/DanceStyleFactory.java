package factories;

import products.Program;
import products.Rumba;
import products.Utils;
import products.Zumba;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: A concrete factory that extends from the abstract factory
 *              which creates dance-style related programs 
 */
public class DanceStyleFactory extends ProgramAbstractFactory{

    /**
     * 
     * @param tipo dictates the tipe of dance related program to be returned
     * @return
     * @throws Exception when thre is no results 
     */
    @Override
    public Program createProgram(String tipo) throws Exception{
        switch (tipo){
            case Utils.CASE_RUMBA:
                return new Rumba();
            case Utils.CASE_ZUMBA:
                return new Zumba();
            default:
                throw new Exception(Utils.ERROR_NO_EXISTS_PROGRAM);
        }    
    }
}
package run;

import factories.ProgramAbstractFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import products.Program;
import products.Utils;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: test where there is a factory that will change through the
 * excecution of the code
 */
public class Test {

    public static void main(String[] args) {

        ProgramAbstractFactory factory;
        try {
            factory = ProgramAbstractFactory.getFactory(Utils.CASE_AEROBICS_FACTORY);
            Program aerobics = factory.createProgram(Utils.CASE_YOGA);
            System.out.println(aerobics.getId() + aerobics.getName() + Utils.LINE_SEPARATOR + aerobics.getDescription());
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            factory = ProgramAbstractFactory.getFactory(Utils.CASE_DANCE_STYLE_FACTORY);
            Program aerobics = factory.createProgram(Utils.CASE_ZUMBA);
            System.out.println(aerobics.getId() + aerobics.getName() + Utils.LINE_SEPARATOR + aerobics.getDescription());
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            factory = ProgramAbstractFactory.getFactory(Utils.CASE_STRENGHT_TRAINNING_FACTORY);
            Program aerobics = factory.createProgram(Utils.CASE_BODY_BUILDING);
            System.out.println(aerobics.getId() + aerobics.getName() + Utils.LINE_SEPARATOR + aerobics.getDescription());
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

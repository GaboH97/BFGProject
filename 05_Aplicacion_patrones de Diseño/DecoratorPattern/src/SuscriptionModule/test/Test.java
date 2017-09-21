package SuscriptionModule.test;

import SuscriptionModule.decorators.ExecutiveCard;
import SuscriptionModule.decorators.Group;
import SuscriptionModule.decorators.MontlyPayment;
import SuscriptionModule.decorators.Personal;
import SuscriptionModule.decorators.Student;
import SuscriptionModule.products.ISuscriptionData;
import SuscriptionModule.products.MonthlySuscription;
import SuscriptionModule.products.MonthlySuscritionType;
import SuscriptionModule.products.Session;



/**
 *
 * @author Cesar Cardozo
 */
public class Test {

    public static void main(String[] args) {
        ISuscriptionData session = new ExecutiveCard(new Session(),5);
        System.out.println(session.getName() +": "+ session.getDescription() + ": " +session.getPrice());
        //este deveria dar un entrenamiento de 15 dias en grupo con precio de 36 barras.
        ISuscriptionData month = new Group(new MontlyPayment(new MonthlySuscription(MonthlySuscritionType.WEIGHTLIFINTG),0));
        System.out.println(month.getName() +": "+ month.getDescription() + ": " +month.getPrice());
    }
}

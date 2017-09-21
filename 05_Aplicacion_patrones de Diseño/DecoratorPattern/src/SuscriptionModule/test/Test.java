package SuscriptionModule.test;

import SuscriptionModule.decorators.ExecutiveCard;
import SuscriptionModule.decorators.Group;
import SuscriptionModule.decorators.MontlyPayment;
import SuscriptionModule.decorators.SportClubMember;
import SuscriptionModule.products.ISuscriptionData;
import SuscriptionModule.products.MonthlySuscription;
import SuscriptionModule.products.MonthlySuscritionType;
import SuscriptionModule.products.Session;

/**
 *
 * @author Cesar Cardozo, Gabriel Amaya 
 * Descripción: Clase prueba del módulo de suscripciones aplicando patrón de diseño Decorator
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("PRUEBAS DE CONCEPTO MÓDULO DE SUSCRIPCIÓN UTILIZANDO PATRÓN DE DISEÑO DECORATOR");
        //Crea una instancia de la clase Session que es decorada con la opción de tarjeta ejecutiva de 5 sesiones
        
        ISuscriptionData suscription2 = new ExecutiveCard(new Session(),5);
        System.out.println(suscription2.getName() +": "+ suscription2.getDescription() + ": " +suscription2.getPrice());
        
        // Crea una instancia de la clase MontlySuscription de tipo pesas que se
        // Decora para que ofrecerla en plan quincenal para grupos de dos o más
        // personas
        ISuscriptionData suscription1 = new Group(new MontlyPayment(new MonthlySuscription(MonthlySuscritionType.WEIGHTLIFINTG),0));
        System.out.println(suscription1.getName() +": "+ suscription1.getDescription() + ": " +suscription1.getPrice());
        
        // Crea una instancia de la clase MontlySuscription general que se
        // Decora para que ofrecerla en tipo membresía de un año para miembro de club deportivo
        ISuscriptionData suscription3 = new SportClubMember(new MontlyPayment(new MonthlySuscription(MonthlySuscritionType.ALL)  , 12));
         System.out.println(suscription3.getName() +": "+ suscription3.getDescription() + ": " +suscription3.getPrice());
    }
}

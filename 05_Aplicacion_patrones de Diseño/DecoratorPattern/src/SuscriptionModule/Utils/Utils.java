package SuscriptionModule.Utils;

import java.math.BigDecimal;

/**
 *
 * @author Cesar Cardozo
 */
public class Utils {

    //**************************CONSTANTES SESION******************************************
    public static final BigDecimal BASIC_SESSION_PRICE = new BigDecimal(6000);                          //Describe el precio base de una sesion
    public static final String SESION_NAME = "Sesion";                                                  //nombre de una sesion
    public static final String SESION_BASICA_DE_EJERCICIO_DESCRIPCION = "Sesion basica de ejercicio";   //descripcion de una sesion
    //****************************TARJETAS EJECUTIVAS**************************************
    //descripcion de las diferentes tarjetas ejecutivas_________________________________
    public static final String X5CARD_DESCRITION = "Tarjeta de 5 sesiones";
    public static final String X10CARD_DESCRITION = "Tarjeta de 10 sesiones";
    public static final String X15CARD_DESCRITION = "Tarjeta de 15 sesiones";
    public static final String X20CARD_DESCRITION = "Tarjeta de 20 sesiones";
    public static final String X30CARD_DESCRITION = "Tarjeta de 30 sesiones";
    //__________________________________________________________________________________
    //nombre de las diferentes tarjetas ejectivas_______________________________________
    public static final String X5CARD_NAME = "Tarjeta ejecutiva x5";
    public static final String X10CARD_NAME = "Tarjeta ejecutiva x10";
    public static final String X20CARD_NAME = "Tarjeta ejecutiva x20";
    public static final String X15CARD_NAME = "Tarjeta ejecutiva x15";
    public static final String X30CARD_NAME = "Tarjeta ejecutiva x30";
    //___________________________________________________________________________________    
    public static final String ERROR_MESSAGE = "Error";                                                 //mensaje de error
    //ratios de conversion para aplicar a las diferentes tarjetasejecutivas
    public static final BigDecimal X5CARD_RATIO = new BigDecimal(0.866);
    public static final BigDecimal X10CARD_RATIO = new BigDecimal(0.833);
    public static final BigDecimal X15CARD_RATIO = new BigDecimal(0.777);
    public static final BigDecimal X30CARD_RATIO = new BigDecimal(0.666);
    public static final BigDecimal X20CARD_RATIO = new BigDecimal(0.75);
    //***************************SUSCRIPCION MENSUAL**************************
    //nombre de los diferentes paquetes de meses que se pueden adquirir
    public static final String HALF_MONTH_MP_NAME ="Membresia por 15 dias";
    public static final String TWO_MONTH_MP_NAME = "Membresia por dos meses";
    public static final String THREE_MONTH_MP_NAME = "Membresia por tres meses";
    public static final String SIX_MONTH_MP_NAME = "Membresia por seis meses";
    public static final String ONE_YEAR_MP_NAME = "Membresia por un año"
    public static final String MONTHLY_SUSCRIPTION_NAME = "Mensual";
    //_____________________________________________________________________________________
    //ratios de conversion para aplicar descuentos a los diferentes paquetes de meses que se pueden adquirir
    public static final BigDecimal X1_2MONTH_RATIO = new BigDecimal(1.333);
    public static final BigDecimal X2MONTH_RATIO = new BigDecimal(.916);
    public static final BigDecimal X3MONTH_RATIO = new BigDecimal(.833);
    public static final BigDecimal X6MONTH_RATIO = new BigDecimal(.75);
    public static final BigDecimal X12MONTH_RATIO = new BigDecimal(.666);
    //______________________________________________________________________________________
    //descripcion de los diferentes paquetes de meses que se pueden adquirir
    public static final String HALF_MONTH_MP_DESCRIPTION = "Membresia por medio mes con precio reducido";
    public static final String TWO_MONTH_MP_DESCRIPTION = "Membresia por 2 meses con precio reducido";
    public static final String THREE_MONTH_MP_DESCRIPTION = "Membresia por 3 meses con precio reducido";
    public static final String SIX_MONTH_MP_DESCRIPTION = "Membresia por 6 meses con precio reducido" ;
    public static final String ONE_YEAR_MP_DESCRIPTION = "Membresia por 1 año con precio reducido ";
    //_____________________________________________________________________________________
    //descripcion de los diferentes tipos de mensualidades que se pueden adquirir
    public static final String MONTHLY_SUSCRIPTION_DESCRIPTION = "Este es un tipo de suscripcion mensual de tipo ";
    public static final String MONTHLY_SUSCRIPTION_SPINNING_DESCRIPTION = "Este es un tipo de suscripcion mensual de spinning de tipo ";
    public static final String MONTHLY_SUSCRIPTION_ALL_DESCRIPTION = "Este es un tipo de suscripcion mensual con acceso a todo el gym de tipo ";
    //______________________________________________________________________________________
    //precio base de los diferentes tipos de mensualidades que se pueden adquiriri
    public static final BigDecimal MONTHLY_SUSCRIPTION_BASIC_PRICE = new BigDecimal(60000);
    public static final BigDecimal MONTHLY_SUSCRIPTION_SPINNING_BASIC_PRICE = new BigDecimal(80000);
    public static final BigDecimal MONTHLY_SUSCRIPTION_ALL_BASIC_PRICE = new BigDecimal(100000);
    //******************************MIEMBRO DE CLUB DEPORTIVO************************************
    public static final BigDecimal SPORT_CLUB_MEMBER_RATIO = new BigDecimal(0.75);                          //ratio de conversion para un miembro de club deportivo
    public static final String SPORT_CLUB_MEMBER_NAME = " de miembro deportivo";                            //nombre de una suscripcion para un miembro de club deportivo
    //******************************ESTUDIANTES¨***********************************************
    public static final String STUDENT_NAME = " de estudiante";                                             //nombre de una suscripcion para un estudia
    public static final BigDecimal STUDENT_RATIO = new BigDecimal(0.833);                                   //ratio de conversion para un estudiante
    //*¨**************************ENTRENAMIENTO PERSONAL*************************
    public static final String PERSONAL_NAME = " de entrenamiento personal";                                //nombre de una suscripcion de entrenamiento personal
    public static final BigDecimal PERSONAL_RATIO = new BigDecimal(7.5);                                    //ratio de conversion para una suscripcion de entrenamiento personal
    //***************************ENTRENAMIENTO EN GRUPO**************************
    public static final String GROUP_NAME = " de entrenamiento en grupo";                                   //nombre de una suscripcion adquirida en grupo
    public static final BigDecimal GROUP_RATIO = new BigDecimal(0.916);                                     //ratio de conversion para una suscripcion adquirida en grupo
}

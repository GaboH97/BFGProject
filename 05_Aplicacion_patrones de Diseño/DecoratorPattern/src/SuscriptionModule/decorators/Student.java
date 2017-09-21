package SuscriptionModule.decorators;

import SuscriptionModule.Utils.Utils;
import SuscriptionModule.products.ISuscriptionData;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Cesar Cardozo, Gabriel Amaya
 * Description: describe la modificacion a un tipo de suscripcion en la que el interesado
 * es un estudiante de primaria o secundaria en un colegio, lo que le da acceso a un descuento 
 * dictado por el ratio de conversion de estudiante
 */
public class Student extends Decorator {

    public Student(ISuscriptionData isuscriptionM) {
        super(isuscriptionM);
    }

    @Override
    public String getName() {
        return super.getName() + Utils.STUDENT_NAME;
    }

    @Override
    public BigDecimal getPrice() {
        return (super.getPrice().multiply(Utils.STUDENT_RATIO)).setScale(1, RoundingMode.HALF_UP);//redondea el resultado si la parte decimal es mayor a 0.5
    }
}

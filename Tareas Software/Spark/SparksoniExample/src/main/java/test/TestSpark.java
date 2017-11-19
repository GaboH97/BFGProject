package test;

import java.math.BigDecimal;
import java.util.Calendar;
import models.dao.Manager;
import models.entity.Movements;
import models.entity.Students;
import models.entity.Trainners;

/**
 *
 * @author Gabriel Huertas, Juan Molina, Cesar Cardozo
 */
public class TestSpark {

    public static void main(String[] args) {
        Students student = new Students("123", "name", "phone", "eMail", "imgURL");
        Movements mv = new Movements(123, "tipo", Calendar.getInstance().getTime(), BigDecimal.ONE, "description");
        Trainners tn = new Trainners("identification", "name", "phone", "eMail", "imgURL", "programs");
        Manager manager = new Manager();
//        manager.addStudent(student);
//        manager.addTrainner(tn);
//        manager.addMovement(mv);
    }
    
}

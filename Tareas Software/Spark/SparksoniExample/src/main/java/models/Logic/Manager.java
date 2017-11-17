package models.Logic;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.Movements;
import models.Students;
import models.Trainners;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

/**
 *
 * @author Cesar Cardozo
 */
public class Manager {

    private Session sessionHibernate;
    private Transaction tx;

    public Manager() {
    }

    /**
     * Adds persistent student data to the DBMS
     *
     * @param user
     */
    public void addStudent(Students student) {
        saveHibernate(student);
    }

    public Students createStudent(String id, String name, String phone, String eMail, String imgUrl) {
        Students st = new Students(id, name, phone, eMail, imgUrl);
        addStudent(st);
        return st;
    }

    /**
     * Adds persistent trainner data to the DBMS
     *
     * @param user
     */
    public void addTrainner(Trainners trainner) {
        saveHibernate(trainner);
    }

    public Trainners createTrainner(String id, String name, String phone, String eMail, String imgUrl, String programs) {
        Trainners tn = new Trainners(id, name, phone, eMail, imgUrl, programs);
        addTrainner(tn);
        return tn;
    }

    /**
     * Adds persistent Movement data to the DBMS
     *
     * @param user
     */
    public void addMovement(models.Movements movement) {
        saveHibernate(movement);
    }

    public Movements createMovement(String id, String tipo, String movement_date, String value, String description) {
        int idInt = Integer.parseInt(id);
        DateFormat dateFormated = new SimpleDateFormat("yyyy-MM-dd");
        Date datefromDateFormated;
        try {
            datefromDateFormated = dateFormated.parse(movement_date);
        } catch (ParseException ex) {
            datefromDateFormated = new Date(1999, 12, 31);
        }
        BigDecimal valueBigDecimal = new BigDecimal(value);
        Movements mv = new Movements(idInt, tipo, datefromDateFormated, valueBigDecimal, description);
        addMovement(mv);
        return mv;
    }

    /**
     *
     * @param object A raw object to be persisted in the DB
     * @throws Exception when any of the steps during the transaction fails
     */
    public void saveHibernate(Object object) {
        try {
            sessionHibernate = HibernateUtil.getSessionFactory().openSession();
            tx = sessionHibernate.beginTransaction();
            sessionHibernate.save(object);
            tx.commit();
            sessionHibernate.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public List<Students> getAllStudents() {
        sessionHibernate = HibernateUtil.getSessionFactory().openSession();
        List<Students> list = sessionHibernate.createQuery("from students").list();
        sessionHibernate.close();
        return list;
    }

    public List<Trainners> getAllTrainners() {
        sessionHibernate = HibernateUtil.getSessionFactory().openSession();
        List<Trainners> list = sessionHibernate.createQuery("from trainners").list();
        sessionHibernate.close();
        return list;
    }

    public List<Movements> getAllMovements() {
        sessionHibernate = HibernateUtil.getSessionFactory().openSession();
        List<Movements> list = sessionHibernate.createQuery("from movements").list();
        sessionHibernate.close();
        return list;
    }

    public static void main(String[] args) {
        Manager mn = new Manager();
//        mn.addStudent(new Students("1234323", "name", "phone", "eMail", "imgURL"));
        mn.getAllMovements();
    }
}

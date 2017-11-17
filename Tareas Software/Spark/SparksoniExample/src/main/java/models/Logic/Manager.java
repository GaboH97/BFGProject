package models.Logic;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    public boolean addTrainner(Trainners trainner) {
        return saveHibernate(trainner);
    }

    public String createTrainner(String id, String name, String phone, String eMail, String imgUrl, String programs) {
        Trainners tn = new Trainners(id, name, phone, eMail, imgUrl, programs);
        System.out.println(tn.toString());
        if (addTrainner(tn)) {
            return "ok";
        } else {
            return "Ya existe un Trainer con esa identificacion";

        }
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
    public boolean saveHibernate(Object object) {
        try {
            sessionHibernate = HibernateUtil.getSessionFactory().openSession();
            tx = sessionHibernate.beginTransaction();
            sessionHibernate.save(object);
            tx.commit();
            sessionHibernate.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Students> getAllStudents() {
        sessionHibernate = HibernateUtil.getSessionFactory().openSession();
        List<Students> list = sessionHibernate.createQuery("from " + Students.class.getName()).list();
        sessionHibernate.close();
        return list;
    }

    public List<Trainners> getAllTrainners() {
        sessionHibernate = HibernateUtil.getSessionFactory().openSession();
        List<Trainners> list = sessionHibernate.createQuery("from " + Trainners.class.getName()).list();
        sessionHibernate.close();
        return list;
    }

    public List<Movements> getAllMovements() {
        sessionHibernate = HibernateUtil.getSessionFactory().openSession();
        List<Movements> list = sessionHibernate.createQuery("from " + Movements.class.getName()).list();
        sessionHibernate.close();
        return list;
    }

    public static void main(String[] args) {
        Manager mn = new Manager();
        //mn.addTrainner(new Trainners("122334343", "Jose sasa dain", "237327232247", "joseNos@has.com", "https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAANEAAAAJDM4ZGM1ZGZhLTYzODgtNGY4Ny04YjZmLTQwYjRlNGVmMDc3ZA.jpg","Spining"));
        System.err.println(mn.getAllMovements().get(0).getDescription());
    }
}

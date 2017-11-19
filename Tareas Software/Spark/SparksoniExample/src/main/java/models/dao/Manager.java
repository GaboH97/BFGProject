package models.dao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.entity.Movements;
import models.entity.Students;
import models.entity.Trainners;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

/**
 *
 * @author Gabriel Huertas, Juan Molina, Cesar Cardozo
 */
public class Manager {

    //==================Attributes======================
    
    private Session sessionHibernate;
    private Transaction tx;
    
    //=================Constructors=====================
    
    public Manager() {
    }
    
    //================Methods====================
    /**
     * Adds persistent student data to the DBMS
     *
     * @param student
     * @throws java.lang.Exception
     */
    public void addStudent(Students student) throws Exception {
        saveHibernate(student);
    }
    
    /**
     * 
     * @param id
     * @param name
     * @param phone
     * @param eMail
     * @param imgUrl
     * @return A message representing success/failure when adding a new student
     */
    public String createStudent(String id, String name, String phone, String eMail, String imgUrl) {
        Students st = new Students(id, name, phone, eMail, imgUrl);
        try {
            addStudent(st);
            return "Student added sucessfully";
        } catch (Exception e) {
            return "Couldn't add Student, please retry";
        }
    }

    /**
     * Adds persistent trainner data to the DBMS
     *
     * @param trainner
     * @throws java.lang.Exception
     */
    public void addTrainner(Trainners trainner) throws Exception {
        saveHibernate(trainner);
    }

    public String createTrainner(String id, String name, String phone, String eMail, String imgUrl, String programs) {
        Trainners tn = new Trainners(id, name, phone, eMail, imgUrl, programs);
        try {
            addTrainner(tn);
            return "Trainner Added Sucessfully";
        } catch (Exception e) {
            return "Couldn't add trainner, please retry";
        }
    }

    /**
     * Adds persistent Movement data to the DBMS
     *
     * @param movement
     * @throws java.lang.Exception
     */
    public void addMovement(Movements movement) throws Exception {
        saveHibernate(movement);
    }
    
    /**
     * 
     * @param id                Movement identificator
     * @param tipo              Movement type: Income/Expense
     * @param movement_date     The date in which the movement was done
     * @param amount            The amount in monetary units  
     * @param description       Some description to append to the movement (not required)
     * @return A message representing success/failure when adding a new movement
     */
    public String createMovement(String id, String tipo, String movement_date, String amount, String description) {
        int idInt = Integer.parseInt(id);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = formatter.parse(movement_date);
            BigDecimal valueBigDecimal = new BigDecimal(amount);
            Movements mv = new Movements(idInt, tipo, date, valueBigDecimal, description);
            addMovement(mv);
        } catch (ParseException ex) {
            date = Calendar.getInstance().getTime();
        } catch (Exception ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            return "Movement added successfully";
        } catch (Exception e) {
            return "Couldn't save movement, please, retry";
        }
    }

    /**
     *
     * @param object A raw object to be persisted in the DB
     * @throws Exception when any of the steps during the transaction fails
     */
    public void saveHibernate(Object object) throws Exception {
        sessionHibernate = HibernateUtil.getSessionFactory().openSession();
        tx = sessionHibernate.beginTransaction();
        sessionHibernate.save(object);
        tx.commit();
        sessionHibernate.close();
    }
    
    /**
     * 
     * @return A list of existing students in the DB 
     */
    public List<Students> getAllStudents() {
        sessionHibernate = HibernateUtil.getSessionFactory().openSession();
        List<Students> list = sessionHibernate.createQuery("from " + Students.class.getName()).list();
        sessionHibernate.close();
        return list;
    }
    
    /**
     * 
     * @return A list of existing trainners in the DB 
     */
    public List<Trainners> getAllTrainners() {
        sessionHibernate = HibernateUtil.getSessionFactory().openSession();
        List<Trainners> list = sessionHibernate.createQuery("from " + Trainners.class.getName()).list();
        sessionHibernate.close();
        return list;
    }
    
    /**
     * 
     * @return A list of existing movements in the DB 
     */
    public List<Movements> getAllMovements() {
        sessionHibernate = HibernateUtil.getSessionFactory().openSession();
        List<Movements> list = sessionHibernate.createQuery("from " + Movements.class.getName()).list();
        sessionHibernate.close();
        return list;
    }
}


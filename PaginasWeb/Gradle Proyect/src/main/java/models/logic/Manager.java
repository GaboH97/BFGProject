package models.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import models.entity.SystemUser;
import persistence.HibernateUtil;

/**
 *	 This class represents a connector between Web Application requests
 *	 and data access to the DB using persistence framework Hibernate.
 *	 While this redirects Web Application request as input parameter and
 *	 passes it to the Hibernate Framework, it also manages both logical
 *	 operations and little persistent data in form of Lists. This last in
 *	 order to load data dynamically from the DB when required, avoiding
 *	 loading huge amounts of data.
 * 
 * @author Juan Diego Molina, Cesar Cardozo, Gabriel Huertas
 *
 */
public class Manager {

	//============ ATTRIBUTES =================
	
	private Session sessionHibernate;
	private Transaction tx;
	List<SystemUser> users;
	
	
	//============ CONSTRUCTORS ===============
	
	/**
	 * Empty constructor that opens an Hibernate Session to do transactions
	 * using SQL statements
	 */
	public Manager() {
		sessionHibernate = HibernateUtil.getSessionFactory().openSession();
		users = new ArrayList<>();
		//loadUsers();
		addTestUsers();
		sessionHibernate.close();
	}
	
	public void addTestUsers() {
		// usuarios de prueba
		addUser(new SystemUser("Juan", "123"));
		addUser(new SystemUser("cesar", "123"));
		addUser(new SystemUser("gabriel", "123"));
		addUser(new SystemUser("diego", "123"));
		addUser(new SystemUser("nicolas", "123"));
		addUser(new SystemUser("ricardo", "123"));
		addUser(new SystemUser("richi", "123"));
	}
	
	/**
	 * Load existing users from DBMS by creating and executing a SQL statement
	 */
	public void loadUsers() {
		users = sessionHibernate.createQuery("from " + SystemUser.class.getName()).list();
	}
	
	/**
	 * Adds persistent user data to the DBMS
	 * @param user
	 */
	public void addUser(SystemUser user) {
		users.add(user);
		saveHibernate(user);
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (SystemUser systemUser : users) {
			builder.append(systemUser.toString());
		}
		return builder.toString();
	}
	
	/**
	 * This method opens a Session to begin a transaction. Builds a query 
	 * as a string input parameter and executes it in search of any match
	 * for given userName/password parameters
	 * 
	 * @param userName
	 * @param password
	 * @return true if a User with input userName/password values exists in the
	 * 		   DB, otherwise, false
	 */
	public boolean userExist(String userName, String password) {
		SystemUser user = null;
		sessionHibernate = HibernateUtil.getSessionFactory().openSession();
		tx = sessionHibernate.beginTransaction();
		try {
			user = (SystemUser) sessionHibernate.createQuery("from " + SystemUser.class.getName() + " where name = "
					+ String.valueOf("'") + userName + String.valueOf("'") + "and password = " + String.valueOf("'")
					+ password + String.valueOf("'")).list().get(0);
		} catch (Exception e) {
		}
		tx.commit();
		sessionHibernate.close();
		return user != null;
	}

}
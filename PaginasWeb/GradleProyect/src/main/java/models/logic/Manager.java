package models.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Transaction;
import models.entity.SystemUser;
import persistence.HibernateUtil;

public class Manager {

	private org.hibernate.Session sessionHibernate;
	private Transaction tx;
	List<SystemUser> users;

	public Manager() {
		sessionHibernate = HibernateUtil.getSessionFactory().openSession();
		users = new ArrayList<>();
		loadUsers();
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

	public void loadUsers() {
		users = sessionHibernate.createQuery("from " + SystemUser.class.getName()).list();
	}

	public void addUser(SystemUser user) {
		users.add(user);
		saveHibernate(user);
	}

	public void saveHibernate(Object object) {
		sessionHibernate = HibernateUtil.getSessionFactory().openSession();
		tx = sessionHibernate.beginTransaction();
		sessionHibernate.save(object);
		tx.commit();
		sessionHibernate.close();
	}

	public void printTable() {
		for (SystemUser student : users) {
			System.out.println(student.toString());
		}
	}

	public boolean userExist(String userName, String password) {
		SystemUser user = null ;
		try {
			user= (SystemUser)sessionHibernate.createQuery("from " + SystemUser.class.getName() + " where name = " + String.valueOf("'")
					+ userName + String.valueOf("'") + "and password = " + String.valueOf("'") + password
					+ String.valueOf("'")).list().get(0);
		} catch (Exception e) {}
		return user !=null;
	}

}

package models.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * A POJO class that represents an user in the system
 * For current purpose, users only have username/passwords
 * credentials to log in into the system.
 * 
 * @author Juan Diego Quintero, Cesar Cardozo, Gabriel Amaya
 *		   
 */
@Entity
@Table(name = "SYSTEMUSER")
public class SystemUser {
	
	//================== ATRRIBUTES =================
	
    @Id
    private String name;
    private String password;
    
    /**
     * Two-param constructor creates a SystemUser given
     * username/password attributes
     * 
     * @param name
     * @param password
     */
    public SystemUser(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }
    
    /**
     * Alternative three-param constructor to load persistent SystemUser
     * data from the DBMS to OO entities.
     * @param id
     * @param name
     * @param password
     */
    public SystemUser(Long id, String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }
    
    /**
     * Empty constructor created for Hibernate library use
     */
    public SystemUser() {
    }

    //================ Getters & Setters ==================
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPasswordValid(String password) {
        return password.equals(this.password);
    }

    public String getPassword() {
        return this.password;
    }

	@Override
	public String toString() {
		return "User [ name=" + name + ", password=" + password + "]";
	}
}
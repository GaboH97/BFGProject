package models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  POJO class that represents a trainner
 * 
 * @author Gabriel Huertas, Juan Molina, Cesar Cardozo
 */
@Entity
@Table(name = "TRAINNERS")

public class Trainners {
    
    //===============Attributes===============
    
    @Id
    private String identification;
    private String name;
    private String phone;
    private String eMail;
    private String imgURL;
    private String programs;
    
    //===============Constructors=============
    
    public Trainners() {
    }

    public Trainners(String identification, String name, String phone, String eMail, String imgURL, String programs) {
        this.identification = identification;
        this.name = name;
        this.phone = phone;
        this.eMail = eMail;
        this.imgURL = imgURL;
        this.programs = programs;
    }
    
    //============Getters & Setters===========
    
    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getPrograms() {
        return programs;
    }

    public void setPrograms(String programs) {
        this.programs = programs;
    }
}
package models;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Cesar Cardozo
 */

@Entity
@Table(name = "MOVEMENTS")
public class Movements {

    @Id
    private int id;
    private String tipo;
    private Date movement_date;
    private BigDecimal value;
    private String description;

    public Movements() {
    }

    public Movements(int id, String tipo, Date movement_date, BigDecimal value, String description) {
        this.id = id;
        this.tipo = tipo;
        this.movement_date = movement_date;
        this.value = value;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDate() {
        return movement_date;
    }

    public void setDate(Date movement_date) {
        this.movement_date = movement_date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
package products;

/**
 *
 * @author Gabriel Huertas, Cesar Cardozo, Juan Diego Molina
 *
 * Description: The GodFather class that inherits the basic attributes of a
 * program to their children classes
 */
public abstract class Program {
    
    private String id;
    private String name;
    private String description;

    public String getId() {
        return new String("Id: 1");
    }
    public String getName() {
        return new String("Nombre: ");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }
}
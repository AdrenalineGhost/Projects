package be.ugent.iii.componisten;

public class Componist {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String category;


    public Componist (String id, String firstName, String lastName,
                      String category) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

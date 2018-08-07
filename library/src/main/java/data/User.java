package data;

import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable {
    private static final long serialVersionUID = 32947324324983247L;

    private String firstName;
    private String lastName;
    private String pesel;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public User(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(pesel, user.pesel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, pesel);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + pesel;
    }
}

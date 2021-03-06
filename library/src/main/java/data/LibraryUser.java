package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryUser extends User {
    private static final long serialVersionUID = 232342343434234L;

    private List<Publication> publicationHistory;
    private List<Publication> borrowedPublications;

    public List<Publication> getPublicationHistory() {
        return publicationHistory;
    }

    public List<Publication> getBorrowedPublications() {
        return borrowedPublications;
    }

    public LibraryUser(String firstName, String lastName, String pesel) {
        super(firstName, lastName, pesel);
        this.publicationHistory = new ArrayList<>();
        this.borrowedPublications = new ArrayList<>();
    }

    private void addPublicationToHistory(Publication pub) {
        publicationHistory.add(pub);
    }

    private void borrowPublication(Publication pub) {
        borrowedPublications.add(pub);
    }

    public boolean returnPublication(Publication pub) {
        boolean result = false;
        if (borrowedPublications.remove(pub)) {
            result = true;
            addPublicationToHistory(pub);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LibraryUser that = (LibraryUser) o;
        return Objects.equals(publicationHistory, that.publicationHistory) &&
                Objects.equals(borrowedPublications, that.borrowedPublications);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), publicationHistory, borrowedPublications);
    }
}

package data;

import java.io.Serializable;
import java.util.Arrays;

public class Library implements Serializable {
    public static final long serialVersionUID = 53847563775834L;
    public static final int INITIAL_CAPACITY = 1;
    private Publication[] publications;
    private int publicationsNumber;

    public Library() {
        publications = new Publication[INITIAL_CAPACITY];
    }

    public Publication[] getPublications() {
        return publications;
    }

    public int getPublicationsNumber() {
        return publicationsNumber;
    }

    private void addPublication(Publication publication) {
        if (publicationsNumber == publications.length) {
            publications = Arrays.copyOf(publications, publications.length * 2);
        }
            publications[publicationsNumber] = publication;
            publicationsNumber++;
    }

    public void removePublication(Publication publication) {
        if (publication == null) {
            return;
        }
        final int NOT_FOUND = -1;
        int found = NOT_FOUND;
        int i = 0;
        while (i < publications.length && found == NOT_FOUND) {
            if (publication.equals(publications[i])) {
                found = i;
            } else {
                i++;
            }
        }

        if (found != NOT_FOUND) {
            System.arraycopy(publications, found + 1, publications, found, publications.length - found - 1);
            publications[publications.length - 1] = null;
            publicationsNumber--;
        }
    }

    public void addBook(Book book) {
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < publicationsNumber; i++) {
            builder.append(publications[i])
                    .append("\n");
        }
        return builder.toString();
    }
}

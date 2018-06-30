package data;

import java.io.Serializable;

public class Library implements Serializable {
    public static final long serialVersionUID = 53847563775834L;
    public final int MAX_PUBLICATIONS = 2000;
    private Publication[] publications;
    private int publicationsNumber;

    public Library() {
        publications = new Publication[MAX_PUBLICATIONS];
    }

    public Publication[] getPublications() {
        return publications;
    }

    public int getPublicationsNumber() {
        return publicationsNumber;
    }

    private void addPublication(Publication publication) throws ArrayIndexOutOfBoundsException {
        if (publicationsNumber == MAX_PUBLICATIONS) {
            throw new ArrayIndexOutOfBoundsException("MAX PUBLICATIONS " + MAX_PUBLICATIONS);
        }
            publications[publicationsNumber] = publication;
            publicationsNumber++;
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

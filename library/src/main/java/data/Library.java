package data;

public class Library {
    public final int MAX_BOOKS = 1000;
    public final int MAX_MAGAZINES = 1000;
    private Book[] books;
    private Magazine[] magazines;
    private int booksNumber;
    private int magazinesNumber;

    public Library() {
        books = new Book[MAX_BOOKS];
        magazines = new Magazine[MAX_MAGAZINES];
    }

    public Book[] getBooks() {
        return books;
    }

    public int getBooksNumber() {
        return booksNumber;
    }

    public Magazine[] getMagazines() {
        return magazines;
    }

    public int getMagazinesNumber() {
        return magazinesNumber;
    }

    public void addBook(Book book) {
        if (booksNumber < MAX_BOOKS) {
            books[booksNumber] = book;
            booksNumber++;
        } else {
            System.out.println("Maksymalna liczba książek została osiągnięta.");
        }
    }

    public void addMagazine(Magazine magazine) {
        if (magazinesNumber < MAX_MAGAZINES) {
            magazines[magazinesNumber] = magazine;
            magazinesNumber++;
        } else {
            System.out.println("Maksymalna liczba magazynów została osiągnięta.");
        }
    }

    public void printBooks() {
        if (booksNumber == 0) {
            System.out.println("Brak książek w bibliotece.");
        }
        for (int i = 0; i < booksNumber; i++) {
            books[i].printInfo();
        }
    }

    public void printMagazines() {
        if (magazinesNumber == 0) {
            System.out.println("Brak magazynów w bibliotece.");
        }
        for (int i = 0; i < magazinesNumber; i++) {
            magazines[i].printInfo();
        }
    }
}

package app;

import data.Book;
import data.Magazine;
import data.Library;
import utils.DataReader;

public class LibraryControl {
    public final int EXIT = 0;
    public final int ADD_BOOK = 1;
    public final int ADD_MAGAZINE = 2;
    public final int PRINT_BOOKS = 3;
    public final int PRINT_MAGAZINES = 4;

    private DataReader dataReader;
    private Library library;

    public LibraryControl() {
        dataReader = new DataReader();
        library = new Library();
    }

    public void controlLoop() {
        int option;
        printOptions();
        while ((option = dataReader.getInt()) != EXIT) {
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                default:
                    System.out.println("Nie ma takiej opcji, wprowadź ponownie");
            }
            printOptions();
        }
        dataReader.close();
    }
    private void printOptions() {
        System.out.println("Wybierz opcję:");
        System.out.println(EXIT + " - wyjście z programu");
        System.out.println(ADD_BOOK + " - dodanie nowej książki");
        System.out.println(ADD_MAGAZINE + " - dodanie nowego magazynu");
        System.out.println(PRINT_BOOKS + " - wyświetl książki");
        System.out.println(PRINT_MAGAZINES + " - wyświetl magazyny");
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printBooks() {
        library.printBooks();
    }

    private void printMagazines() {
        library.printMagazines();
    }

}

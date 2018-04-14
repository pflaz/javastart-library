package app;

import data.Book;
import data.Library;
import utils.DataReader;

public class LibraryControl {
    public final int exit = 0;
    public final int addBook = 1;
    public final int printBooks = 2;

    private DataReader dataReader;
    private Library library;

    public LibraryControl() {
        dataReader = new DataReader();
        library = new Library();
    }

    public void controlLoop() {
        int option;
        printOptions();
        while ((option = dataReader.getInt()) != exit) {
            switch (option) {
                case addBook:
                    addBook();
                    break;
                case printBooks:
                    printBooks();
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
        System.out.println("0 - wyjście z programu");
        System.out.println("1 - dodanie nowej książki");
        System.out.println("2 - wyświetl książki");
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printBooks() {
        library.printBooks();
    }

}

package app;

import data.Book;
import data.Magazine;
import data.Library;
import utils.DataReader;
import utils.FileManager;
import utils.LibraryUtils;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class LibraryControl {

    private DataReader dataReader;
    private Library library;
    private FileManager fileManager;

    public LibraryControl() {
        dataReader = new DataReader();
        fileManager = new FileManager();
        try {
            library = fileManager.readLibraryFromFile();
            System.out.println("Wczytano dane biblioteki z pliku");
        } catch (IOException | ClassNotFoundException e) {
            library = new Library();
            System.out.println("Utworzono nową bazę biblioteki");
        }

    }

    public void controlLoop() {
        Option option = null;
        while (option != Option.EXIT) {
            try {
                printOptions();
                option = Option.createFromInt(dataReader.getInt());
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
                    case EXIT:
                        exit();
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono niepoprawne dane, publikacji nie dodano.");
            } catch (NumberFormatException | NoSuchElementException e) {
                System.out.println("Wybrana opcja nie istnieje, spróbuj ponownie.");
            }
        }
        dataReader.close();
    }
    private void printOptions() {
        System.out.println("Wybierz opcję:");
        for (Option option : Option.values()) {
            System.out.println(option);
        }
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
        LibraryUtils.printBooks(library);
    }

    private void printMagazines() {
        LibraryUtils.printMagazines(library);
    }

    private void exit() {
        fileManager.writeLibraryToFile(library);
        System.out.println("Zapisano dane biblioteki do pliku");
    }

    private enum Option {
        EXIT(0, "Wyjście z programu"),
        ADD_BOOK(1, "Dodanie książki"),
        ADD_MAGAZINE(2, "Dodanie magazynu"),
        PRINT_BOOKS(3, "Wyświetlenie książek"),
        PRINT_MAGAZINES(4, "Wyświetlenie magazynów");

        private int value;
        private String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        public static Option createFromInt(int option) throws NoSuchElementException {
            Option result = null;
            try {
                result = Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException("Brak elementu o wskazanym ID");
            }
            return result;
        }
    }
}

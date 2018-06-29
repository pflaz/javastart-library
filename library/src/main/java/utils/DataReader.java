package utils;

import data.Book;
import data.Magazine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner scanner;

    public DataReader() {
        scanner = new Scanner(System.in);
    }

    public void close() {
        scanner.close();
    }

    public int getInt() throws NumberFormatException {
        int number = 0;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new NumberFormatException("Liczba wprowadzona w niepoprawnej formie");
        } finally {
            scanner.nextLine();
        }
        return number;
    }

    public Book readAndCreateBook() throws InputMismatchException {
        System.out.print("Tytuł: ");
        String title = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        System.out.print("Wydawnictwo: ");
        String publisher = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Rok wydania: ");
        int releaseYear = 0;
        int pages = 0;
        try {
            releaseYear = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ilość stron: ");
            pages = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw e;
        }
        return new Book(title, author, releaseYear, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() throws InputMismatchException {
        System.out.print("Tytuł: ");
        String title = scanner.nextLine();
        System.out.print("Wydawnictwo: ");
        String publisher = scanner.nextLine();
        System.out.print("Język: ");
        String language = scanner.nextLine();
        System.out.print("Rok wydania: ");
        int year, month, day = 0;
        try {
            year = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Miesiąc: ");
            month = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Dzień: ");
            day = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw e;
        }
        return new Magazine(title, publisher, language, year, month, day);
    }
}

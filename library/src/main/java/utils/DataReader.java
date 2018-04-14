package utils;

import data.Book;

import java.util.Scanner;

public class DataReader {
    private Scanner scanner;

    public DataReader() {
        scanner = new Scanner(System.in);
    }

    public void close() {
        scanner.close();
    }

    public Book readAndCreateBook() {
        System.out.println("Tytuł: ");
        String title = scanner.nextLine();
        System.out.println("Autor: ");
        String author = scanner.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = scanner.nextLine();
        System.out.println("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.println("Rok wydania: ");
        int releaseYear = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ilość stron: ");
        int pages = scanner.nextInt();
        scanner.nextLine();
        return new Book(title, author, releaseYear, pages, publisher, isbn);
    }
}

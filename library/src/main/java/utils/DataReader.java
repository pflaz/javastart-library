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

    public int getInt() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public Book readAndCreateBook() {
        System.out.print("Tytuł: ");
        String title = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        System.out.print("Wydawnictwo: ");
        String publisher = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Rok wydania: ");
        int releaseYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ilość stron: ");
        int pages = scanner.nextInt();
        scanner.nextLine();
        return new Book(title, author, releaseYear, pages, publisher, isbn);
    }
}

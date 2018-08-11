package utils;

import data.*;

public class LibraryUtils {

    public static void printBooks(Library library) {
        printPublications(library, Book.class);
    }

    public static void printMagazines(Library library) {
        printPublications(library, Magazine.class);
    }

    private static void printPublications(Library library, Class cl) {
        long countMagazines = library.getPublications().values().stream()
                .filter(cl::isInstance)
                .sorted(new Library.AlphabeticalComparator())
                .peek(System.out::println)
                .count();
        if (countMagazines == 0) {
            System.out.println("W bibliotece nie znaleziono publikacji typu " + cl.getSimpleName());
        }
    }

    public static void printUsers(Library library) {
        library.getUsers().values().stream()
                .sorted((a, b) -> a.getLastName().compareTo(b.getLastName()))
                .forEach(System.out::println);
    }
}

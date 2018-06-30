package utils;

import data.Library;

import java.io.*;

public class FileManager {
    public static final String FILE_NAME = "Library.o";

    public void writeLibraryToFile(Library library) {
        try(
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream os = new ObjectOutputStream(fos);
                ) {
            os.writeObject(library);
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku: " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Błąd zapisu danych do pliku" + FILE_NAME);
        }
    }

    public Library readLibraryFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        Library library = null;
        try (
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            library = (Library)ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku: " + FILE_NAME);
            throw e;
        } catch (IOException e) {
            System.err.println("Błąd zapisu danych do pliku" + FILE_NAME);
            throw e;
        } catch (ClassNotFoundException e) {
            System.err.println("Nieprawidłowy format danych");
            throw e;
        }
        return library;
    }
}

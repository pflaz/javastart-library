package app;

public class LibraryApp {
    public static void main(String[] args) {
        final String appName = "Biblioteka v 0.9";
        System.out.println(appName);
        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();
    }
}

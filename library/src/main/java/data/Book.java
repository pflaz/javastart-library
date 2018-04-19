package data;

public class Book extends Publication {
    private String author;
    private int pages;
    private String isbn;

    public Book(String title, String author, int year, int pages, String publisher, String isbn) {
        super(year, title, publisher);
        this.setAuthor(author);
        this.setPages(pages);
        this.setIsbn(isbn);
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void printInfo() {
        System.out.println("Title: " + getTitle() + "\nAuthor: " + getAuthor() + "\nYear: " + getYear()
        + "\nPages: " + getPages() + "\nPublisher: " + getPublisher() + "\nISBN: " + getIsbn() + "\n");
    }
}

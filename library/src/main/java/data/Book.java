package data;

import java.util.Objects;

public class Book extends Publication {
    public static final long serialVersionUID = 29348294893L;
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

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append("Title: ")
                .append(getTitle())
                .append("\nAuthor: ")
                .append(getAuthor())
                .append("\nYear: ")
                .append(getDate().getYear())
                .append("\nPages: ")
                .append(getPages())
                .append("\nPublisher: ")
                .append(getPublisher())
                .append("\nISBN: ")
                .append(getIsbn());
        return print.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(author, book.author) &&
                Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), author, pages, isbn);
    }


}

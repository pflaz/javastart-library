package data;

import java.util.Objects;

public class Magazine extends Publication {
    private int month;
    private int day;
    private String language;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Magazine(String title, String publisher, String language, int year, int month, int day) {
        super(year, title, publisher);
        setLanguage(language);
        setMonth(month);
        setDay(day);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append("Title: ")
                .append(getTitle())
                .append("\nPublisher: ")
                .append(getPublisher())
                .append("\nLanguage: ")
                .append(getLanguage())
                .append("\nYear: ")
                .append(getYear())
                .append("\nMonth: ")
                .append(getMonth())
                .append("\nDay: ")
                .append(getDay());
        return print.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return month == magazine.month &&
                day == magazine.day &&
                Objects.equals(language, magazine.language);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), month, day, language);
    }
}

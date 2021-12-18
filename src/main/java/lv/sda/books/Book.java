package lv.sda.books;

import java.time.LocalDate;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String description;
    private int pages;
    private LocalDate publishingYear;

    public Book() {
    }

    public Book(String isbn, String title, String author, String publisher, String description, int pages, LocalDate publishingYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.description = description;
        this.pages = pages;
        this.publishingYear = publishingYear;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public Book setPublishingYear(LocalDate publishingYear) {
        this.publishingYear = publishingYear;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDescription() {
        return description;
    }

    public int getPages() {
        return pages;
    }

    public LocalDate getPublishingYear() {
        return publishingYear;
    }
}

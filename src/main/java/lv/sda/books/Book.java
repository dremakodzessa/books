package lv.sda.books;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String genre;
    private int pages;
    private int publishingYear;

    public Book() {
    }

    public Book(String isbn, String title, String author, String publisher, String genre, int pages, int publishingYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
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

    public Book setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public Book setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", pages=" + pages +
                ", publishingYear=" + publishingYear +
                '}';
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

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }

    public int getPublishingYear() {
        return publishingYear;
    }
}

package lv.sda.books;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class Bookstore {


    //book list
    private static ArrayList<Book> booksList = new ArrayList<Book>();


    public Bookstore() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Java\\books\\src\\main\\resources\\BookList.txt"));

            lines.stream().collect(Co)
        } catch (IOException e) {

        }
    }







    // Add book
    public void addBook(Book book) {

    }

    // Remove book
    public void removeBook(String isbn) {

    }

    // Find book by isbn
    public Book findByIsbn(String isbn) {

        return null;
    }

    // Find book by title
    public List<Book> findByTitle(String query) {

        return emptyList();
    }

    // Get book list
    public List<Book> allBooks() {

        return emptyList();
    }
}

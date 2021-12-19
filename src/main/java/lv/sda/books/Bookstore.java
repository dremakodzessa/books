package lv.sda.books;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class Bookstore {


    //book list
    private static ArrayList<Book> booksList = new ArrayList<>();


    public Bookstore() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Java\\books\\src\\main\\resources\\BookList.txt"));
            List<Book> books = lines.stream().map(line -> {
                List<String> fields = Arrays.asList(line.split(";"));
                return new Book(
                        fields.get(0),
                        fields.get(1),
                        fields.get(2),
                        fields.get(3),
                        fields.get(4),
                        Integer.parseInt(fields.get(5)),
                        Integer.parseInt(fields.get(6))
                );
            }).collect(Collectors.toList());
            booksList.addAll(books);
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

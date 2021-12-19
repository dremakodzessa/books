package lv.sda.books;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bookstore {


    //book list with all books
    private static ArrayList<Book> booksList = new ArrayList<>();


    public Bookstore() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Java\\books\\src\\main\\resources\\BookList.csv"));
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

        if(booksList.contains(book)){
            System.out.println("This book already exist");
        }
        booksList.add(book);



    }

    // Remove book
    public void removeBook(String isbn) {

        if(findByIsbn(isbn) != null){
            booksList.remove(isbn);
        }

    }

    // Find book by isbn
    public Book findByIsbn(String isbn) {
        for(Book book: booksList){
            if(book.getIsbn().equals(isbn) ){
                return book;
            }
        }

        return null;
    }

    // Find book by title
    public List<Book> findByTitle(String query) {
        List<Book> result = new ArrayList();

        for(Book book: booksList){
            if(book.getTitle().contains(query)){
                result.add(book);
            }
        }
        return result;
    }

    // Get book list
    public List<Book> allBooks() {

        return booksList;
    }
}

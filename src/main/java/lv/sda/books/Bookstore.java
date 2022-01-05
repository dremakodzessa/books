package lv.sda.books;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bookstore {

    // Get book list
    public List<Book> booksList = new ArrayList<>();

    public Bookstore() {
        try {
            List<String> lines = Files.readAllLines(Paths
                    .get("src\\main\\resources\\BookList.csv"));

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
            e.printStackTrace();
        }
    }

    // Add book
    public void addBook(Book i) {
        if(booksList.contains(i)){
            System.out.println("This book already exists!");
        }
        booksList.add(i);
    }

    // Remove book
    public boolean removeBook(String isbn) {
        boolean x = false;
        for (Book i : booksList){
            if(i.getIsbn().equals(isbn)){
                booksList.remove(isbn);
                x = true;
            }
        }
        if (!x){
           System.out.println("Record not found!");
        } else {
            System.out.println("Book successfully removed.");
        }
        return x;
    }

    // Find book by isbn
    public boolean findByIsbn(String isbn) {
        boolean x = false;
        for (Book i : booksList) {
            if (i.getIsbn().equals(isbn)) {
                System.out.println(i);
                x = true;
            }
        }
        if (!x) {
            System.out.println("Record not found!");
        }
        return x;
    }

    // Find book by title
    public boolean findByTitle(String title) {
        boolean x = false;
        for(Book i : booksList){
            if(i.getTitle().equalsIgnoreCase(title)){
                System.out.println(i);
                x = true;
            }
        }
        if (!x){
            System.out.println("Record not found!");
        }
        return x;
    }

    // Save to file
    public void saveToFile(){

    }
}

package lv.sda.books;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bookstore {
    public static final String DEFAULT_FILE = "src\\main\\resources\\BookList.csv";

    // Upload file to array list
    public List<Book> booksList = new ArrayList<>();

    public Bookstore() {
        readBooksFromFile(DEFAULT_FILE);
    }

    public Bookstore(String file) {
        readBooksFromFile(file);
    }

    private void readBooksFromFile(String file) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(file));

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

    // Get book list
    public void printList(){
        System.out.println("Book list:");
        for (Book i : booksList){
            System.out.println(i);
        }
    }

    public void addBook(Book book) {
            if (find(book.getIsbn()) != null) {
                System.out.println("This book already exists!");
            }else {
                booksList.add(book);
                System.out.println("Book successfully added to the database.");
            }
    }

    public void removeBook(String isbn) {

        if (find(isbn) != null) {
            booksList.removeIf(book -> book.getIsbn().equals(isbn));
            System.out.println("Book successfully removed from database.");
        } else {
            System.out.println("Record not found!");
        }
    }

    public Book find(String query) {
       return booksList.stream()
                .filter(book -> book.toString().contains(query))
                .findAny()
                .orElse(null);
    }

    public void saveData(String fileName, List<String> text)
            throws IOException{
                File file = new File(fileName);
                FileWriter fw = new FileWriter(file, false);
                PrintWriter pw = new PrintWriter(fw);
                text.forEach(pw::println);
                pw.close();
            }

    public void saveToFile() throws IOException {
        List<String> text = new ArrayList<>();
        for(int i = 0; i < booksList.size(); i++){
            String dataToSave = booksList.get(i).getIsbn()
                    +";"+booksList.get(i).getTitle()
                    +";"+booksList.get(i).getAuthor()
                    +";"+booksList.get(i).getPublisher()
                    +";"+booksList.get(i).getGenre()
                    +";"+booksList.get(i).getPages()
                    +";"+booksList.get(i).getPublishingYear();
            text.add(dataToSave);
        }
        saveData(DEFAULT_FILE, text);
    }

}

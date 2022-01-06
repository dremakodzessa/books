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

    public void printList(){
        System.out.println("Book list:");
        for (Book i : booksList){
            System.out.println(i);
        }
    }

    // Add book
    public void addBook(Book i) {
        if(booksList.contains(i)){
            System.out.println("This book already exists!");
        } else {
            booksList.add(i);
            System.out.println("Book successfully added to the database.");
        }

    }

    // Remove book
    public void removeBook(String isbn) {
        boolean x = false;
        for (Book i : booksList){
            if(i.getIsbn().equals(isbn)){
                booksList.remove(i);
                x = true;
            }
        }
        if (!x){
           System.out.println("Record not found!");
        } else {
            System.out.println("Book successfully removed.");
        }

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

    public void saveData(String fileName, String text, boolean append ) throws IOException{

        File file = new File(fileName);

        FileWriter fw = new FileWriter(file, append);

        PrintWriter pw = new PrintWriter(fw);

        pw.println(text);

        pw.close();
    }

    public void deleteFile() throws IOException{

        File file = new File("src\\main\\resources\\BookList.csv");

        file.delete();


    }

    // Save to file
    public void saveToFile() throws IOException {

        for(int i=0; i<booksList.size();i++){
            String dataToSave = booksList.get(i).getIsbn() +";"+booksList.get(i).getTitle()
                    +";"+booksList.get(i).getAuthor()+";"+booksList.get(i).getPublisher()
                    +";"+booksList.get(i).getGenre()+";"+booksList.get(i).getPages()
                    +";"+booksList.get(i).getPublishingYear();

                saveData("src\\main\\resources\\BookList.csv", dataToSave,true);
        }
    }
}

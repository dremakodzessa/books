package lv.sda.books;

import java.io.IOException;
import java.util.Scanner;

public class Application {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String input1;
        String input2;
        Bookstore bs = new Bookstore();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Find book by ISBN");
            System.out.println("2 - Find book by title");
            System.out.println("3 - Add book");
            System.out.println("4 - Remove book");
            System.out.println("5 - List available books");
            System.out.println("6 - Save");
            System.out.println("0 - Quit");
            System.out.println("======================================");
            System.out.println("Please enter command number from menu:");

            input1 = scanner.nextLine();

            if ("0".equals(input1)) {
                System.out.println("You have exited the application.");
                break;
            }

            switch (input1) {
                case "1":
                    // Search book by ISBN
                    System.out.println("Please enter book ISBN to search:");
                    input2 = scanner.nextLine();
                    bs.findByIsbn(input2);
                    break;

                case "2":
                    // Search book by title
                    System.out.println("Please enter book title to search:");
                    input2 = scanner.nextLine();
                    bs.findByTitle(input2);
                    break;

                case "3":
                    // Add book
                    Book newBook = new Book();
                    System.out.println("Please enter the following parameters ->");

                    System.out.println("ISBN:");
                    String i1 = scanner.nextLine();
                    newBook.setIsbn(i1);

                    System.out.println("Title:");
                    String i2 = scanner.nextLine();
                    newBook.setTitle(i2);

                    System.out.println("Author:");
                    String i3 = scanner.nextLine();
                    newBook.setAuthor(i3);

                    System.out.println("Publisher:");
                    String i4 = scanner.nextLine();
                    newBook.setPublisher(i4);

                    System.out.println("Genre:");
                    String i5 = scanner.nextLine();
                    newBook.setGenre(i5);

                    System.out.println("Page count:");

                    while (true){

                        String i6 = scanner.nextLine();

                        try {
                            newBook.setPages(Integer.parseInt(i6));
                            break;
                        }catch (NumberFormatException e){
                            System.out.println("Wrong input, please try again");
                        }

                    }

                    System.out.println("Publishing year:");

                    while (true){

                        String i7 = scanner.nextLine();

                        try {
                            newBook.setPublishingYear(Integer.parseInt(i7));
                            break;
                        }catch (NumberFormatException e){
                            System.out.println("Wrong input, please try again");
                        }

                    }


                    bs.addBook(newBook);

                    break;


                case "4":
                    // Remove book
                    System.out.println("Provide ISBN of the book to remove: ");
                    input2 = scanner.nextLine();
                    bs.removeBook(input2);
                    break;

                case "5":
                    // Get book list
                    bs.printList();
                    break;

                case "6":
                    // Save to file
                    bs.deleteFile();
                    bs.saveToFile();
                    System.out.println("All changes saved to the database.");
                    break;

                default:
                    System.out.println("Wrong input, please try again!");
            }

            System.out.println("======================================");

        }
    }
}

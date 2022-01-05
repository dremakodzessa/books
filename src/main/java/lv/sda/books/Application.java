package lv.sda.books;
import java.util.Scanner;

import static lv.sda.books.Bookstore.booksList;

public class Application {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        while (true) {
            Bookstore bs = new Bookstore();
                System.out.println("Enter q to exit application.");
                System.out.println("Enter command number:");
                System.out.println("Menu");
                System.out.println("1 Find book by ISBN");
                System.out.println("2 Find book by title");
                System.out.println("3 Add book");
                System.out.println("4 Remove book");
                System.out.println("5 List available books");
                System.out.println("To quit press: q");

                String input = scanner.nextLine();

        if ("q".equalsIgnoreCase(input)) {
                System.out.println("You have exited the application.");
                break;
        }

            switch (input) {
                case "1":
                   // Search book by ISBN (printout missing here!)
                    System.out.println("Please enter book ISBN to search:");
                    scanner.nextLine();
                    System.out.println(bs.findByIsbn(input));
                    break;

                case "2":
                    // Search book by title (printout missing here!)
                    System.out.println("Please enter book title to search:");
                    scanner.nextLine();
                    System.out.println(bs.findByTitle(input));
                    break;

                case "3":
                    // Add book (UB)

                    break;

                case "4":
                    // Remove book (does it work?)
                    System.out.println("Provide ISBN of the book to remove: ");
                    scanner.nextLine();
                    bs.removeBook(input);
                    break;

                case "5":
                    // Get book list (UB) (no printout!)
                    System.out.println("Book list:");
                    for (Book i : booksList){
                        System.out.println(i);
                    }
                    break;

                case "6":
                    // Save to file (UB)

                    break;

                default:
                    System.out.println("Wrong input, please try again");
            }

            System.out.println();
        }
    }
}

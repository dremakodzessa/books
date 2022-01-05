package lv.sda.books;
import java.util.Scanner;

public class Application {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
                    // Add book (UB)

                    break;

                case "4":
                    // Remove book (doesn't work!)
                    System.out.println("Provide ISBN of the book to remove: ");
                    input2 = scanner.nextLine();
                    bs.removeBook(input2);
                    break;

                case "5":
                    // Get book list
                    System.out.println("Book list:");
                    for (Book i : bs.booksList){
                        System.out.println(i);
                    }
                    break;

                default:
                    System.out.println("Wrong input, please try again!");
            }

            System.out.println("======================================");

        }
    }
}

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
            System.out.println("0 - Quit");
            System.out.println("======================================");
            System.out.println("Please enter command number from menu:");

            input1 = scanner.nextLine();

            if ("0".equals(input1)) {
                    System.out.println("You have exited the application.");
                    bs.saveToFile();
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
                    Book i = new Book();
                    System.out.println("Please enter the following parameters -");

                    System.out.println("ISBN:");
                    String i1 = scanner.nextLine();
                    i.setIsbn(i1);

                    System.out.println("Title:");
                    String i2 = scanner.nextLine();
                    i.setTitle(i2);

                    System.out.println("Author:");
                    String i3 = scanner.nextLine();
                    i.setAuthor(i3);

                    System.out.println("Publisher:");
                    String i4 = scanner.nextLine();
                    i.setPublisher(i4);

                    System.out.println("Genre:");
                    String i5 = scanner.nextLine();
                    i.setGenre(i5);

                    System.out.println("Page count:");
                    int i6 = scanner.nextInt();
                    i.setPages(i6);

                    System.out.println("Publishing year:");
                    int i7 = scanner.nextInt();
                    i.setPublishingYear(i7);

                    bs.addBook(i);
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

                default:
                    System.out.println("Wrong input, please try again!");
            }

            System.out.println("======================================");

        }
    }
}

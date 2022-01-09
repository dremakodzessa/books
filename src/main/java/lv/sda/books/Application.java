package lv.sda.books;

import java.io.IOException;
import java.util.Scanner;

public class Application {

    static Scanner scanner = new Scanner(System.in);
    static Bookstore bs;

    public static void main(String[] args) throws IOException {
        bs = new Bookstore();

        while (true) {
            printMenu();

            String input = scanner.nextLine();

            if ("0".equals(input)) {
                System.out.println("You have exited the application.");
                break;
            }

            switch (input) {
                case "1":
                    // Search book by ISBN
                    System.out.println("Please enter book ISBN to search:");
                    findBook();
                    break;

                case "2":
                    // Search book by title
                    System.out.println("Please enter book title to search:");
                    findBook();
                    break;

                case "3":
                    // Add book
                    addBook();
                    break;

                case "4":
                    // Remove book
                    System.out.println("Provide ISBN of the book to remove: ");
                    input = scanner.nextLine();
                    bs.removeBook(input);
                    break;

                case "5":
                    // Get book list
                    bs.printList();
                    break;

                case "6":
                    // Save to file
                    bs.saveToFile();
                    System.out.println("All changes saved to the database.");
                    break;

                default:
                    System.out.println("Wrong input, please try again!");
            }

            System.out.println("======================================");

        }
    }

    private static void printMenu() {
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
    }

    private static void addBook() {
        Book newBook = new Book();
        System.out.println("Please enter the following parameters ->");

        System.out.println("ISBN:");
        newBook.setIsbn(scanner.nextLine());

        System.out.println("Title:");
        newBook.setTitle(scanner.nextLine());

        System.out.println("Author:");
        newBook.setAuthor(scanner.nextLine());

        System.out.println("Publisher:");
        newBook.setPublisher(scanner.nextLine());

        System.out.println("Genre:");
        newBook.setGenre(scanner.nextLine());

        System.out.println("Page count:");
        newBook.setPages(inputNumber());

        System.out.println("Publishing year:");
        newBook.setPublishingYear(inputNumber());

        bs.addBook(newBook);
    }

    private static int inputNumber() {
        while (true) {
            String number = scanner.nextLine();
            try {
                return Integer.parseInt(number);
            } catch (NumberFormatException e) {
                System.out.println("Wrong input, please try again");
            }
        }
    }

    private static void findBook() {
        String input = scanner.nextLine();
        Book result = bs.find(input);
        if (result != null) {
            System.out.println(result);
        }else {
            System.out.println("This book is not found");
        }
    }
}

package lv.sda.books;

import java.util.Scanner;

public class Application {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

/*        String strFile = "BookList.txt";

        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader("C:\\Java\\books\\src\\main\\resources\\BookList.txt"));

        }catch(IOException e){
            e.printStackTrace();
        }



        BufferedWriter bw = null;

        try{
            bw = new BufferedWriter(new FileWriter("C:\\Java\\books\\src\\main\\resources\\BookList.txt"));

        }catch (IOException e){
            e.printStackTrace();
        }*/






        while (true) {
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
                    System.out.println("Searching for book by ISBN");
                    break;
                case "2":
                    System.out.println("Searching for book by title");
                    break;
                case "3":
                    System.out.println("Adding book");
                    break;
                case "4":
                    System.out.println("Removing book");
                    System.out.println("Provide ISBN of the book to remove: ");
                    scanner.nextLine();
                    break;
                case "5":
                    System.out.println("Listing available books:");
                    break;
                default:
                    System.out.println("Wrong input, please try again");
            }

            System.out.println();
        }
    }
}

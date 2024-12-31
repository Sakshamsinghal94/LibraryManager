package LibraryManagementSystem;

import java.util.Scanner;
/**
 * Main class for the Library Management System.
 * This class provides a command-line interface for managing a book library.
 * The user can add, remove, search, and list books in the library.
 */
public class LibraryMain {

    /**
     * Main method to run the Library Management System.
     * This method provides a menu interface for the user to interact with the library system.
     * It allows the user to add, remove, search, and list books in the library.
     *
     * @param args command-line arguments (not used in this application)
     */

    public static void main(String[] args) {
        BookLibrary library = new BookLibrary();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book ");
            System.out.println("2. Remove Book ");
            System.out.println("3. Search Book");
            System.out.println("4. List of Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter year published: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    library.addBook(title, author, year, genre);
                    break;
                case 2:
                    System.out.print("Enter title or author to remove: ");
                    String query = scanner.nextLine();
                    library.removeBook(query);
                    break;
                case 3:
                    System.out.print("Search by (title/author/year/genre): ");
                    String criteria = scanner.nextLine();
                    System.out.print("Enter your query: ");
                    String searchQuery = scanner.nextLine();
                    library.searchBook(criteria, searchQuery);
                    break;
                case 4:
                   library.listAllBooks();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


}

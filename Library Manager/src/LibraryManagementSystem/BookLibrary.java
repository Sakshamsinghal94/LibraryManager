package LibraryManagementSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A library management system for storing and managing books.
 * Books are stored persistently using serialization.
 */
public class BookLibrary {
    private static final String FILE_NAME = "library.txt";
    private List<Book> library;

    /**
     * Constructs a new LibraryManagementSystem.BookLibrary instance and loads books from the persistent storage.
     */
    public BookLibrary() {
        library = loadLibrary();
    }

    /**
     * Adds a new book to the library.
     *
     * @param title  the title of the book (must not be null or empty)
     * @param author the author of the book (must not be null or empty)
     * @param year   the publication year (must be positive)
     * @param genre  the genre of the book (must not be null or empty)
     */
    public void addBook(String title, String author, int year, String genre) {
        if (title == null || title.isEmpty() ||
                author == null || author.isEmpty() ||
                genre == null || genre.isEmpty() ||
                year <= 0) {
            System.out.println("Invalid book details. Please try again.");
            return;
        }
        library.add(new Book(title, author, year, genre));
        System.out.println("Book added successfully!");
        saveLibrary();
    }

    /**
     * Removes books from the library based on a query.
     * The query matches either the title or author of a book (case-insensitive).
     *
     * @param query the title or author to match
     */
    public void removeBook(String query) {
        boolean removed = library.removeIf(book ->
                book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query)
        );
        if (removed) {
            System.out.println("Book(s) removed successfully!");
        } else {
            System.out.println("No matching books found.");
        }
        saveLibrary();
    }

    /**
     * Searches for books in the library based on a given criteria and query.
     *
     * @param criteria the search criteria (e.g., "title", "author", "year", "genre")
     * @param query    the value to search for
     */
    public void searchBook(String criteria, String query) {
        List<Book> results = new ArrayList<>();
        for (Book book : library) {
            switch (criteria.toLowerCase()) {
                case "title":
                    if (book.getTitle().equalsIgnoreCase(query)) results.add(book);
                    break;
                case "author":
                    if (book.getAuthor().equalsIgnoreCase(query)) results.add(book);
                    break;
                case "year":
                    if (String.valueOf(book.getYear()).equals(query)) results.add(book);
                    break;
                case "genre":
                    if (book.getGenre().equalsIgnoreCase(query)) results.add(book);
                    break;
                default:
                    System.out.println("Invalid search criteria. Use title, author, year, or genre.");
                    return;
            }
        }
        if (results.isEmpty()) {
            System.out.println("No matching books found.");
        } else {
            System.out.println("Search Results:");
            results.forEach(System.out::println);
        }
    }

    /**
     * Lists all books in the library.
     */
    public void listAllBooks() {
        if (library.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Library Contents:");
            for (Book book : library) {
                System.out.println(book);
            }
        }
    }

    /**
     * Saves the library to persistent storage.
     */
    private void saveLibrary() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(library);
            System.out.println("Library saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving library: " + e.getMessage());
        }
    }

    /**
     * Loads the library from persistent storage.
     *
     * @return a list of books from the saved file, or an empty list if the file doesn't exist
     */
    @SuppressWarnings("unchecked")
    private List<Book> loadLibrary() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("Library file not found. Starting with an empty library.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading library: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}

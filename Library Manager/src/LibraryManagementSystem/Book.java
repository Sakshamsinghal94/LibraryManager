package LibraryManagementSystem;

import java.io.Serializable;

/**
 * Represents a book with details such as title, author, publication year, and genre.
 * Implements {@link Serializable} for object serialization.
 */
public class Book implements Serializable {

    // Fields representing book details
    private final String title;
    private final String author;
    private final int year;
    private final String genre;

    /**
     * Constructs a new LibraryManagementSystem.Book object with the specified details.

     */
    public Book(String title, String author, int year, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    /**
     * Returns the title of the book.
     *
     * @return the book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the book.
     *
     * @return the book's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the publication year of the book.
     *
     * @return the book's publication year
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the genre of the book.
     *
     * @return the book's genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Returns a string representation of the book.
     *
     * @return a string in the format "LibraryManagementSystem.Book{title='...', author='...', year=..., genre='...'}"
     */
    @Override
    public String toString() {
        return "LibraryManagementSystem.Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }

}

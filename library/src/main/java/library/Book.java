package library;

import java.util.*;

/**
 * Stores information about a book
 */
public class Book implements Printable {

    public int id;
    public String title;
    public String author;
    /**
     * List of copies of the book
     */
    public List<Copy> copy = new ArrayList<>();

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    /**
     * Create a newCopy of the book CREATOR
     * @return
     */
    public Copy addCopy() {
        Copy newCopy = new Copy(this.copy.size() + 1, this.id);
        this.copy.add(newCopy);
        return newCopy;
    }

    public void print() {
        System.out.println("ID: " + id + " title: " + title + " by " + author);
    }
}

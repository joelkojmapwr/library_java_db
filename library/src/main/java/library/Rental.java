package library;

import java.time.LocalDateTime;

/**
 * Rents of books
 */
public class Rental implements Printable {
    public int id;
    public LocalDateTime rentalDateTime;
    public LocalDateTime returnDateTime;
    public int memberId;
    public int bookId;
    /** Id of the rented copy of the book */
    int copyId;

    /**
     * For importing the rental from the database
     * @param readerId
     * @param bookId
     * @param copyId
     */
    public Rental(int memberId, int bookId, int copyId, LocalDateTime rentalDateTime, LocalDateTime returnDateTime) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.copyId = copyId;
        this.rentalDateTime = rentalDateTime;
        this.returnDateTime = returnDateTime;
    }

    /**
     * For creating a new rental
     * @param id
     * @param memberId
     * @param bookId
     * @param copyId
     */
    public Rental(int id, int memberId, int bookId, int copyId) {
        this.id = id;
        this.memberId = memberId;
        this.bookId = bookId;
        this.copyId = copyId;
        this.rentalDateTime = LocalDateTime.now();
    }

    /**
     * Return the book
     */
    public void returnBook() {
        this.returnDateTime = LocalDateTime.now();
    }

    public Boolean isReturned() {
        return returnDateTime != null;
    }

    public void print() {
        System.out.println("Rental ID: " + id + " Member ID: " + memberId + " Book ID: " + bookId + " Copy ID: " + copyId + " Rental date: " + rentalDateTime + " Return date: " + returnDateTime);
    }

}

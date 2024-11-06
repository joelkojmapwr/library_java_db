package library;

import java.util.ArrayList;
import java.util.List;


import dao.MemberDAO;
import dao.BookDAO;
import dao.CopyDAO;
import dao.RentalDAO;

/**
 * Stores all the lists of books, members, rentals and copies, also communicates with the database
 */
public class Library {
    public List<Book> books;
    public List<Member> members;
    public List<Rental> rentals;
    public List<Copy> copies;

    private BookDAO bookDAO;
    private CopyDAO copyDAO;
    private MemberDAO memberDAO;
    private RentalDAO rentalDAO;
    
    /**
     * initialize the lists of books, members, rentals and copies and import data from database;
     */
    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.rentals = new ArrayList<>();
        this.copies = new ArrayList<>();

        this.bookDAO = new BookDAO();
        this.copyDAO = new CopyDAO();
        this.memberDAO = new MemberDAO();
        this.rentalDAO = new RentalDAO();

        books = bookDAO.readAll();
        members = memberDAO.readAll();
        rentals = rentalDAO.readAll();
        copies = copyDAO.readAll();
    }
    /**
     * Generic type that implements Printable to print the list of entities
     * @param <T>
     * @param entity
     */
    public <T extends Printable> void print(List<T> entity) {
        for (T record : entity) {
            record.print();
        }
    }

    /**
     * Add a new book to the library
     * @param title
     * @param author
     */
    public void addBook(String title, String author) {
        Book newBook = new Book(books.size() + 1, title, author);
        bookDAO.insert(newBook);
        books.add(newBook);
    }
    /**
     * Add a new copy of the book
     * @param book
     */
    public void newCopy(Book book) {
        Copy newCopy = book.addCopy();
        copies.add(newCopy);
        copyDAO.insert(newCopy);
    }
    /**
     * Add a new member to the library
     * @param name
     * @param lastName
     */
    public void addMember(String name, String lastName) {
        Member newMember = new Member(members.size() + 1, name, lastName);
        members.add(newMember);
        memberDAO.insert(newMember);
    }
    /**
     * Add a new rental to the library
     * @param memberID
     * @param bookID
     * @param copyID
     */
    public void addRental(int memberID, int bookID, int copyID) {
        Rental newRental = new Rental(rentals.size() + 1, memberID, bookID, copyID);
        rentals.add(newRental);
        rentalDAO.insert(newRental);
    }
}

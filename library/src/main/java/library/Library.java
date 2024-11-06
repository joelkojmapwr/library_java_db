package library;

import library.Book;
import library.Member;
import library.Copy;
import library.Rental;

import java.util.ArrayList;
import java.util.List;


import dao.MemberDAO;
import dao.BookDAO;
import dao.CopyDAO;
import dao.RentalDAO;

public class Library {
    public List<Book> books;
    public List<Member> members;
    public List<Rental> rentals;
    public List<Copy> copies;
    private BookDAO bookDAO;
    private CopyDAO copyDAO;
    private MemberDAO memberDAO;
    private RentalDAO rentalDAO;
    
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
        /*
        //addBook("Tworzyc Liderow", "John C. Maxwell");
        //print(books);
        Book book1 = bookDAO.readById(5);
        book1.print();
        //newCopy(book1);
        //copies = copyDAO.readAll();
        //print(copies);

        //addMember("Joel2", "Kojma");
        //members = memberDAO.readAll();
        //print(members);

        addRental(1, 5, 1);
        print(rentals);
        */
    }

    public <T extends Printable> void print(List<T> entity) {
        for (T record : entity) {
            record.print();
        }
    }

    /**methods
     * 
     */
    public void addBook(String title, String author) {
        Book newBook = new Book(books.size() + 1, title, author);
        bookDAO.insert(newBook);
        books.add(newBook);
    }

    public void newCopy(Book book) {
        Copy newCopy = book.addCopy();
        copyDAO.insert(newCopy);
    }

    public void addMember(String name, String lastName) {
        Member newMember = new Member(members.size() + 1, name, lastName);
        members.add(newMember);
        memberDAO.insert(newMember);
    }
    public void addRental(int memberID, int bookID, int copyID) {
        Rental newRental = new Rental(rentals.size() + 1, memberID, bookID, copyID);
        rentals.add(newRental);
        rentalDAO.insert(newRental);
    }
    
    //public void returnBook()
}

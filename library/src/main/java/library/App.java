package library;


import java.util.List;
import java.util.ArrayList;

/**
 * Main java class responsible for starting up the library application and 
 * providing the user with a menu of options to interact with the library.
 */
public class App {

    public static Library library;
    /**
     * menu options
     */
    public static List<Option> options = new ArrayList<>();
    /**
     * Create instance of library and start the application
     * @param args
     */
    public static void main(String[] args) {
        library = new Library();
        createOptions();
        run();
    }
    /**
     * showing the options and executing the selected option
     */
    public static void run() {
        while (true) {
            System.out.println("Options:");

            for (int i = 0; i < options.size(); i++) {
                System.out.println(i + 1 + ". " + options.get(i).title);
            }
            System.out.print("Choose option id: ");
            int option = Integer.parseInt(System.console().readLine());
            if (option > 0 && option <= options.size()) {
                options.get(option -1).execute();
            } else {
                System.out.println("Invalid option");
            }
        }
    }
    /** Used only at the start to 
     * Create options for the menu
     */
    public static void createOptions(){
        options.add(new Option("Add book", () -> {
            System.out.print("Enter book title: ");
            String title = System.console().readLine();
            System.out.print("Enter book author: ");
            String author = System.console().readLine();
            library.addBook(title, author);
        }));
        options.add(new Option("Add member", () -> {
            System.out.print("Enter member name: ");
            String name = System.console().readLine();
            System.out.print("Enter member last name: ");
            String lastName = System.console().readLine();
            library.addMember(name, lastName);
        }));
        options.add(new Option("Add Copy", () -> {
            System.out.print("Enter book id: ");
            int bookId = Integer.parseInt(System.console().readLine());
            library.newCopy(library.books.get(bookId - 1));
        }));
        options.add(new Option("Add rental", () -> {
            System.out.print("Enter member id: ");
            int memberId = Integer.parseInt(System.console().readLine());
            System.out.print("Enter book id: ");
            int bookId = Integer.parseInt(System.console().readLine());
            System.out.print("Enter copy id: ");
            int copyId = Integer.parseInt(System.console().readLine());
            library.addRental(memberId, bookId, copyId);
        }));

        options.add(new Option("List members", () -> {
            library.print(library.members);
        }));

        options.add(new Option("List rentals", () -> {
            library.print(library.rentals);
        }));

        options.add(new Option("List copies", () -> {
            library.print(library.copies);
        }));

        options.add(new Option("List books", () -> {
            library.print(library.books);
        }));

        options.add(new Option ("Get book by Id", () -> {
            System.out.print("Enter book id: ");
            int bookId = Integer.parseInt(System.console().readLine());
            library.books.get(bookId - 1).print();
        }));
        options.add(new Option ("Return book", () -> {
            System.out.print("Enter rental id: ");
            int rentalId = Integer.parseInt(System.console().readLine());
            library.returnRental(rentalId);
        }));
        options.add(new Option("Quit", () -> System.exit(0)));
    }
}

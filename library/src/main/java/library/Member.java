package library;

/**
 * Holds members of the library
 * @implNote implements Printable
 */
public class Member implements Printable {
    public int id;
    public String name;
    public String lastName;

    public Member(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
    @Override
    public void print() {
        System.out.println("ID: " + id + " Name: " + name + " Lastname: " + lastName);
    }
}

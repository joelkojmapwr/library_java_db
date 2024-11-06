package library;

/**
 * Represents a copy of a title
 * @implNote implements Printable
 */
public class Copy implements Printable {
    public int id;
    public int titleId;
    private State state;

    public Copy(int id, int titleId) {
        this.id = id;
        this.titleId = titleId;
        state = State.AVAILABLE;
    }

    public Boolean isAvailable() {
        return state == State.AVAILABLE;
    }

    public void rent() {
        state = State.RENTED;
    }

    public void returnCopy() {
        state = State.AVAILABLE;
    }

    public void print() {
        System.out.println("Copy ID: " + id + " Title ID: " + titleId + " State: " + state);
    }
}

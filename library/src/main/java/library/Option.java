package library;

// import java.lang.reflect.Executable;

/**
 * Represents an option in the menu
 */
public class Option {
    public String title;
    private Runnable executable;


    public Option(String title, Runnable executable) {
        this.title = title;
        this.executable = executable;
    }

    public void execute() {
        try {
            executable.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
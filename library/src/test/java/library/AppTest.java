package library;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dao.Database;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testConnectionWithDatabase() throws Exception {
        assertTrue(Database.getConnection() != null);
    
    }

    @Test
    public void checkBookwithID8() {
        library.Library library = new library.Library();
        Book book = library.books.get(7);
        assertTrue(book.title.equals("bible"));
    }
}

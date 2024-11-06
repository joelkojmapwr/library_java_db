package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import library.Book;
import dao.Database;

public class BookDAO implements ReadWriteDb<Book> {
    
    public List<Book> readAll() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT id, title, author FROM books";

        try (Connection conn = Database.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Map each row to a Book object
                Book book = mapRowToBook(rs);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    private Book mapRowToBook(ResultSet rs) throws SQLException {
        return new Book(
            rs.getInt("id"),
            rs.getString("title"),
            rs.getString("author")
        );
    }

    public Book readById(int id){
        String sql = "SELECT id, title, author FROM books WHERE id = " + id;
        System.out.println("sql command: " + sql);
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next() == false) {
                    throw new SQLException("No record found");
                }
                return mapRowToBook(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to create a new record
    public void insert(Book book) {
        String sql = "INSERT INTO books (title, author) VALUES ('" + book.title + "', '" + book.author + "')";
        System.out.println("sql command: " + sql);
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


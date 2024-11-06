package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import library.Copy;
/**
 * Responsible for handling the SQL requests with the Copy table
 */
public class CopyDAO implements ReadWriteDb<Copy> {
    /**
     * Reads all records from the table
     */
    public List<Copy> readAll() {
        List<Copy> copies = new ArrayList<>();
        String sql = "SELECT id, titleID FROM copies";

        try (Connection conn = Database.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Map each row to a Copy object
                Copy copy = mapRowToCopy(rs);
                copies.add(copy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return copies;
    }

    private Copy mapRowToCopy(ResultSet rs) throws SQLException {
        return new Copy(
            rs.getInt("id"),
            rs.getInt("titleID")
        );
    }

    public Copy readById(int id){
        String sql = "SELECT id, titleID FROM copies WHERE id = " + id;
        System.out.println("sql command: " + sql);
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next() == false) {
                    throw new SQLException("No record found");
                }
                return mapRowToCopy(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to create a new record
    public void insert(Copy copy) {
        String sql = "INSERT INTO copies (titleID) VALUES ('" + copy.titleId + "')";
        System.out.println("sql command: " + sql);
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

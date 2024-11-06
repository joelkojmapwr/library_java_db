package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import library.Rental;
import dao.Database;

public class RentalDAO implements ReadWriteDb<Rental> {
    
    public List<Rental> readAll() {
        List<Rental> rentals = new ArrayList<>();
        String sql = "SELECT id, book_id, member_id, rental_date, return_date FROM rentals";

        try (Connection conn = Database.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Map each row to a Rental object
                Rental rental = mapRowToRental(rs);
                rentals.add(rental);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }

    private Rental mapRowToRental(ResultSet rs) throws SQLException {
        return new Rental(
            rs.getInt("id"),
            rs.getInt("book_id"),
            rs.getInt("member_id"),
            rs.getTimestamp("rental_date").toLocalDateTime(),
            rs.getTimestamp("return_date").toLocalDateTime()
        );
    }

    public Rental readById(int id){
        String sql = "SELECT id, book_id, member_id, rental_date, return_date FROM rentals WHERE id = " + id;
        System.out.println("sql command: " + sql);
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next() == false) {
                    throw new SQLException("No record found");
                }
                return mapRowToRental(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to create a new record
    public void insert(Rental rental) {
        String sql = "INSERT INTO rentals (book_id, member_id) VALUES ('" + rental.bookId + "', '" + rental.memberId + "')";
        System.out.println("sql command: " + sql);
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

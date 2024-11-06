package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import library.Member;
import dao.Database;

public class MemberDAO implements ReadWriteDb<Member> {
    
    public List<Member> readAll() {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT member_id, name, last_name FROM members";

        try (Connection conn = Database.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Map each row to a Member object
                Member member = mapRowToMember(rs);
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    private Member mapRowToMember(ResultSet rs) throws SQLException {
        return new Member(
            rs.getInt("member_id"),
            rs.getString("name"),
            rs.getString("last_name")
        );
    }

    public Member readById(int id){
        String sql = "SELECT member_id, name, last_name FROM members WHERE id = " + id;
        System.out.println("sql command: " + sql);
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next() == false) {
                    throw new SQLException("No record found");
                }
                return mapRowToMember(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to create a new record
    public void insert(Member member) {
        String sql = "INSERT INTO members (name, last_name) VALUES ('" + member.name + "', '" + member.lastName + "')";
        System.out.println("sql command: " + sql);
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


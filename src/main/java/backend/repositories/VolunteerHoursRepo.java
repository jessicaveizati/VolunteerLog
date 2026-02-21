package backend.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VolunteerHoursRepo {
    private final Connection conn;

    public VolunteerHoursRepo(Connection conn) {
        this.conn = conn;
    }

    // Returns total hours for a given user name
    public int getTotalVolunteerHoursForUser(String userName) {
        String query = "SELECT SUM(hours) AS totalVolunteerHours " +
                "FROM volunteer_hours e " +
                "JOIN Users u ON u.id = e.user_id " +
                "WHERE u.name = ?";

        try (PreparedStatement sql = conn.prepareStatement(query)) {
            sql.setString(1, userName);
            try (ResultSet rs = sql.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("totalVolunteerHours");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }
}
package backend.repositories;

import models.Organizations;
import models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganizationsRepo {
    private final Connection conn;

    public OrganizationsRepo(Connection conn){this.conn = conn;}

    public List<Organizations> getOrganizations(){
        List<Organizations> organizationsList = new ArrayList<>();
        try (PreparedStatement sql = conn.prepareStatement("SELECT o.* FROM Organizations AS o")) {
            try (ResultSet rs = sql.executeQuery()) {
                while (rs.next()) {
                    organizationsList.add(new Organizations(rs.getInt("id"), rs.getString("name"),
                            rs.getString("email"), rs.getInt("graduation_year")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return organizationsList;

    }
}

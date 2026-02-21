package backend.repositories;

import models.Question;
import models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepo {
    private final Connection conn;

    public UsersRepo(Connection conn){this.conn = conn;}

    public List<Users> getUsers(){
        List<Users> usersList = new ArrayList<>();
        try (PreparedStatement sql = conn.prepareStatement("SELECT u.* FROM Users AS u")) {
            try (ResultSet rs = sql.executeQuery()) {
                while (rs.next()) {
                    usersList.add(new Users(rs.getInt("id"), rs.getString("name"),
                            rs.getString("email"), rs.getInt("graduation_year")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;

    }
}

package Repos;

import Models.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUsersRepo extends DBRepo<Users> {
    public DBUsersRepo(String dbUrl) throws Exception {
        super(dbUrl);
    }

    @Override
    public void create(Users obj) {
        String sql = "INSERT INTO Users (user_id, username, password, email, role) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, obj.user_id);
            statement.setString(2, obj.username);
            statement.setString(3, obj.password_hash);
            statement.setString(4, obj.role);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Users get(Integer id) {
        String sql = "SELECT * FROM Users WHERE user_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractFromResultSet(resultSet);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Users obj) {
        String sql = "UPDATE Users SET username = ?, password_hash = ?, role = ? WHERE user_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, obj.username);
            statement.setString(2, obj.password_hash);
            statement.setString(3, obj.role);
            statement.setInt(4, obj.user_id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Users WHERE user_id = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Users> getAll() {
        String sql = "SELECT * FROM Users";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            List<Users> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(extractFromResultSet(resultSet));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Users extractFromResultSet(ResultSet resultSet) throws SQLException {
        return new Users(
                resultSet.getInt("user_id"),
                resultSet.getString("username"),
                resultSet.getString("password_hash"),
                resultSet.getString("role")
        );
    }
}
